package client;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Main {
    private static final String address = "127.0.0.1";
    private static final int port = 1234;
    //private static final String data_dir = "C:\\Users\\anind\\IdeaProjects\\File Server\\File Server\\task\\src\\client\\data\\";
    private static final String data_dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "client" + File.separator + "data" +File.separator;

    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try (
                Socket socket = new Socket(InetAddress.getByName(address), port);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        ) {


            while (true) {

                            System.out.println("Enter action (1 - get a file, 2 - save a file, 3 - delete a file): ");
                            String act = userInput.readLine();

                            if ("exit".equals(act)) {
                                out.writeUTF("EXIT");
                                //out.flush();
                                System.out.println("Exiting...");
                                break;
                            }
                            if (act.length() > 1) {
                                System.out.println("Invalid response");
                                continue;
                            }
                            int action = Integer.parseInt(act);

                            if (action == 1) {
                                System.out.println("Do you want to get the file by name or by id (1 - name, 2 - id): ");
                                int identifierType = Integer.parseInt(userInput.readLine());
                                if (identifierType == 2) {
                                    System.out.println("Enter id: ");
                                    int identifierValue = Integer.parseInt(userInput.readLine());
                                    out.writeUTF("GET BY_ID "+ identifierValue);
                                    System.out.println("The request was sent.");

                                } else {
                                    System.out.println("Enter name: ");
                                    String identifier = userInput.readLine();
                                    out.writeUTF("GET BY_NAME "+ identifier);
                                    System.out.println("The request was sent.");

                                }

                                int responseCode = in.readInt();
                                if (responseCode == 200) {
                                    int fileLength = in.readInt();
                                    byte[] fileContent = new byte[fileLength];
                                    in.readFully(fileContent, 0, fileContent.length);


                                    System.out.println("The file was downloaded! Specify a name for it: ");
                                    String fileName = userInput.readLine();

                                    saveFile(fileContent, fileName);
                                    System.out.println("File saved on the hard drive!");
                                } else if (responseCode == 404) {
                                    System.out.println("The response says that this file is not found!");
                                } else {
                                    System.out.println("Server error.");
                                }

                            } else if (action == 2) {
                                System.out.println("Enter name of the file: ");
                                String fileName = userInput.readLine();
                                String file = data_dir + fileName;
                                Path p = Path.of(file);
                                if (fileExists(fileName)) {
                                    System.out.println("Enter name of the file to be saved on server: ");
                                    String serverFileName = userInput.readLine();
                                    byte[] fileContent = Files.readAllBytes(p);
                                    String request = "PUT " + (serverFileName.isEmpty() ? "null" : serverFileName);
                                    out.writeUTF(request);
                                    out.writeInt(fileContent.length);
                                    out.write(fileContent);

                                } else {
                                    System.out.println("File not found!!");
                                    out.writeInt(403);
                                    break;
                                }
                                String responseCode = in.readUTF();
                                if (responseCode.startsWith("200")) {
                                    int fileId = Integer.parseInt(responseCode.split(" ")[1]);
                                    System.out.println("Response says that file is saved! ID = " + fileId);
                                } else {
                                    System.out.println("File upload failed.");
                                }

                            } else if (action == 3) {
                                System.out.println("Do you want to delete the file by name or by id (1 - name, 2 - id): ");
                                int identifierType = Integer.parseInt(userInput.readLine());
                                if (identifierType == 2) {
                                    System.out.println("Enter id: ");
                                    int identifierValue = Integer.parseInt(userInput.readLine());
                                    out.writeUTF("DELETE BY_ID "+ identifierValue);

                                } else {
                                    System.out.println("Enter name: ");
                                    String identifier = userInput.readLine();
                                    out.writeUTF("DELETE BY_NAME "+ identifier);

                                }

                                int responseCode = in.readInt();
                                if (responseCode == 200) {
                                    System.out.println("The response says that this file was deleted successfully!");
                                } else if (responseCode == 404) {
                                    System.out.println("The response says that this file is not found!");
                                } else {
                                    System.out.println("Server error.");
                                }

                            }
                        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void saveFile(byte[] content, String fileName) throws IOException {
        String file = data_dir + fileName;
        Path filePath = Paths.get(file);
        try (OutputStream os = Files.newOutputStream(filePath)) {
            os.write(content);
        }
    }
    private static boolean fileExists(String fileName) {
        String file = data_dir + fileName;
        Path filePath = Paths.get(file);
        return Files.exists(filePath);
    }
}
