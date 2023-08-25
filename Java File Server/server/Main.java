package server;

import java.net.ServerSocket;
import java.net.*;
import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
public class Main {
    private static final int port = 1234;
    private static final String address = "127.0.0.1";
    private static final String data_dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "server" + File.separator + "data" +File.separator;

    //private static final String data_dir = "C:\\Users\\anind\\IdeaProjects\\File Server\\File Server\\task\\src\\server\\data\\";
    private static final AtomicInteger fileIdCounter = new AtomicInteger(1);
    private static Map<Integer, String> fileMap = new ConcurrentHashMap<>();
    //private static final
    private static volatile boolean serverRunning = true;
    private static final Semaphore serverSemaphore = new Semaphore(1);

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        loadFileMapFromFile();


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            saveFileMapToFile();
            System.out.println("Server is shutting down...");
        }));
        DataInputStream input = null;
        DataOutputStream output = null;
        try {
            try (ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address))) {
                serverSemaphore.acquire();
                while (serverRunning) {

                    Socket clientSocket = server.accept();
                    input = new DataInputStream(clientSocket.getInputStream());
                    output = new DataOutputStream(clientSocket.getOutputStream());
                    DataInputStream finalInput = input;
                    DataOutputStream finalOutput = output;
                    String msgIn = input.readUTF();
                    if (msgIn.equals("EXIT")) {
                        break;
                    }
                    executorService.submit(() -> handleClient(clientSocket, finalInput, finalOutput, msgIn));
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            assert input != null;
            input.close();
            assert output != null;
            output.close();
            executorService.shutdownNow();

            System.exit(0);
        }
    }
    public static void handleClient(Socket socket, DataInputStream input,DataOutputStream output, String msgIn) {

        try {
            if (msgIn.equals("EXIT")) {
                handleExitRequest(socket, input, output);
                return;
            } else {
                String[] requestParts = msgIn.split(" ");
                String command = requestParts[0];
                switch (command) {
                    case "PUT":
                        handlePutRequest(input, output, requestParts);
                        break;
                    case "GET":
                        handleGetRequest(input, output, requestParts);
                        break;
                    case "DELETE":
                        handleDeleteRequest(input, output, requestParts);
                        break;
                    default:
                        output.writeInt(400);
                        output.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void handlePutRequest(DataInputStream input, DataOutputStream output, String[] requestParts) throws IOException {
        String fileName = requestParts[1];
        int fileLength = input.readInt();
        byte[] fileContent = new byte[0];
        if (fileLength > 0) {
            fileContent = new byte[fileLength];
            input.readFully(fileContent, 0, fileContent.length);
        }
        String savedFileName;
        if (fileName.equals("null")) {
            savedFileName = generateUniqueFileName();
        } else {
            savedFileName = fileName;
        }
        int fileID = fileIdCounter.getAndIncrement();
        fileMap.put(fileID, savedFileName);
        saveFile(fileContent, savedFileName);
        output.writeUTF("200 " + fileID);
    }

    private static void handleGetRequest(DataInputStream input, DataOutputStream output, String[] requestParts) throws IOException {
        String identifierType = requestParts[1];
        String identifierValue = requestParts[2];

        String fileName = null;
        if (identifierType.equals("BY_ID")) {
            int fileID = Integer.parseInt(identifierValue);
            fileName = fileMap.getOrDefault(fileID, null);
        } else if (identifierType.equals("BY_NAME")) {
            fileName = identifierValue;

        }

        if (fileName != null && fileExists(fileName)) {
            try {
                byte[] fileContent = Files.readAllBytes(Paths.get((data_dir + fileName)));
                output.writeInt(200);
                output.writeInt(fileContent.length);
                output.write(fileContent);
            } catch (IOException e) {
                e.printStackTrace();
                output.writeInt(500);
            }
        } else {
            output.writeInt(404);
        }
    }

    private static void handleDeleteRequest(DataInputStream input, DataOutputStream output, String[] requestParts) throws IOException {
        String identifierType = requestParts[1];
        String identifierValue = requestParts[2];

        int fileId = -1;
        String fileName = null;
        if (identifierType.equals("BY_ID")) {
            fileId = Integer.parseInt(identifierValue);
            fileName = fileMap.remove(fileId);
        } else if (identifierType.equals("BY_NAME")) {
            fileName = identifierValue;
            for (Map.Entry<Integer, String> entry : fileMap.entrySet()) {
                if (entry.getValue().equals(fileName)) {
                    fileId = entry.getKey();
                    fileMap.remove(fileId);
                    break;
                }
            }
        }

        if (fileName != null) {
            try {
                Files.delete(Paths.get(data_dir + fileName));
                output.writeInt(200);
                //output.flush();
            } catch (IOException e) {
                e.printStackTrace();
                output.writeInt(500);
                //output.flush();
            }
        } else {
            output.writeInt(404);
            //output.flush();
        }
    }

    private static void handleExitRequest(Socket socket, DataInputStream input, DataOutputStream output) throws IOException {
        serverRunning = false;
        serverSemaphore.release();
        output.close();
        input.close();
        socket.close();
    }

    private static void saveFile(byte[] content, String requestedFilename) throws IOException {
        String filename = (requestedFilename.isEmpty()) ? "file_" + System.currentTimeMillis() : requestedFilename;
        Path filePath = Path.of(data_dir+filename);

        try (OutputStream os = Files.newOutputStream(filePath)) {
            os.write(content);
        }
    }

    private static String generateUniqueFileName() {
        long timestamp = System.currentTimeMillis();
        int random = (int) (Math.random() * 10000);
        return "file_" + timestamp + "_" + random;
    }
    private static boolean fileExists(String fileName) {
        String file = data_dir + fileName;
        Path filePath = Paths.get(file);
        return Files.exists(filePath);
    }
    private static void saveFileMapToFile() {
        try (ObjectOutputStream fileMapOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\anind\\Desktop\\fileMap.ser"))) {
            fileMapOutputStream.writeObject(fileMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    private static void loadFileMapFromFile() {
        try (ObjectInputStream fileMapInputStream = new ObjectInputStream(Files.newInputStream(Path.of("C:\\Users\\anind\\Desktop\\fileMap.ser")))) {
            fileMap = (ConcurrentHashMap<Integer, String>) fileMapInputStream.readObject();
            if (fileMap == null) {
                fileMap = new ConcurrentHashMap<>();
            }
        } catch (IOException | ClassNotFoundException e) {
            fileMap = new ConcurrentHashMap<>();
        }
    }
}
