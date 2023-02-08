package budget;
import java.util.*;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        HashMap<String,ArrayList<Purchase>> purMap = new HashMap<>();
        double balance = 0;
        double totalSum = 0;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Choose your action:");
            System.out.println("1) Add income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Analyze (Sort)");
            System.out.println("0) Exit");
            int choice = Integer.valueOf(scanner.nextLine());
            System.out.println();
            if(choice == 0) {
                break;
            }
            if(choice == 1) {
                System.out.println("Enter income:");
                int input = Integer.valueOf(scanner.nextLine());
                balance = balance + input;
                System.out.println("Income was added!");
                System.out.println();
            }
            if(choice == 4) {
                System.out.println("Balance: $"+balance);
                System.out.println();
            }
            if(choice == 2) {
                while(true) {
                    System.out.println("Choose the type of purchase");
                    System.out.println("1) Food");
                    System.out.println("2) Clothes");
                    System.out.println("3) Entertainment");
                    System.out.println("4) Other");
                    System.out.println("5) Back");
                    System.out.println();
                    int purCho = Integer.valueOf(scanner.nextLine());
                    if (purCho == 5) {
                        break;
                    }
                    if (purCho == 1) {
                        System.out.println("Enter purchase name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter its price:");
                        double price = Double.valueOf(scanner.nextLine());
                        if(!purMap.containsKey("Food")) {
                            purMap.put("Food", new ArrayList<>());
                        }
                        purMap.get("Food").add(new Purchase(name,price));
                        if (price <= balance) {
                            balance = balance - price;
                        } else {
                            balance = 0.0;
                        }
                        System.out.println("Purchase was added!");
                        System.out.println();
                        continue;
                    }
                    if (purCho == 2) {
                        System.out.println("Enter purchase name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter its price:");
                        double price = Double.valueOf(scanner.nextLine());
                        if(!purMap.containsKey("Clothes")) {
                            purMap.put("Clothes", new ArrayList<>());
                        }
                        purMap.get("Clothes").add(new Purchase(name,price));
                        if (price <= balance) {
                            balance = balance - price;
                        } else {
                            balance = 0.0;
                        }
                        System.out.println("Purchase was added!");
                        System.out.println();
                        continue;
                    }
                    if (purCho == 3) {
                        System.out.println("Enter purchase name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter its price:");
                        double price = Double.valueOf(scanner.nextLine());
                        if(!purMap.containsKey("Entertainment")) {
                            purMap.put("Entertainment", new ArrayList<>());
                        }
                        purMap.get("Entertainment").add(new Purchase(name,price));
                        if (price <= balance) {
                            balance = balance - price;
                        } else {
                            balance = 0.0;
                        }
                        System.out.println("Purchase was added!");
                        System.out.println();
                        continue;
                    }
                    if (purCho == 4) {
                        System.out.println("Enter purchase name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter its price:");
                        double price = Double.valueOf(scanner.nextLine());
                        if(!purMap.containsKey("Other")) {
                            purMap.put("Other", new ArrayList<>());
                        }
                        purMap.get("Other").add(new Purchase(name,price));
                        if (price <= balance) {
                            balance = balance - price;
                        } else {
                            balance = 0.0;
                        }
                        System.out.println("Purchase was added!");
                        System.out.println();
                        //continue;
                    }
                }
            }
            if(choice == 3) {
                while (true) {
                    System.out.println("Choose the type of purchases");
                    System.out.println("1) Food");
                    System.out.println("2) Clothes");
                    System.out.println("3) Entertainment");
                    System.out.println("4) Other");
                    System.out.println("5) All");
                    System.out.println("6) Back");
                    System.out.println();
                    int purCho = Integer.valueOf(scanner.nextLine());
                    if (purCho == 6) {
                        break;
                    }
                    if (purCho == 1) {
                        double foodSum = 0;
                        System.out.println("Food:");
                        if (!purMap.containsKey("Food")) {
                            System.out.println("The purchase list is empty!");
                            System.out.println();
                            continue;
                        }
                        for (Purchase temp : purMap.get("Food")) {
                            System.out.println(temp);
                            foodSum = foodSum + temp.getPrice();
                        }
                        System.out.println("Total sum: $" + foodSum);
                        System.out.println();
                        continue;
                    }
                    if (purCho == 2) {
                        double clSum = 0;
                        System.out.println("Clothes:");
                        if (!purMap.containsKey("Clothes")) {
                            System.out.println("The purchase list is empty!");
                            System.out.println();
                            continue;
                        }
                        for (Purchase temp : purMap.get("Clothes")) {
                            System.out.println(temp);
                            clSum = clSum + temp.getPrice();
                        }
                        System.out.println("Total sum: $" + clSum);
                        System.out.println();
                        continue;
                    }
                    if (purCho == 3) {
                        double enSum = 0;
                        System.out.println("Entertainment:");
                        if (!purMap.containsKey("Entertainment")) {
                            System.out.println("The purchase list is empty!");
                            System.out.println();
                            continue;
                        }
                        for (Purchase temp : purMap.get("Entertainment")) {
                            System.out.println(temp);
                            enSum = enSum + temp.getPrice();
                        }
                        System.out.println("Total sum: $" + enSum);
                        System.out.println();
                        continue;
                    }
                    if (purCho == 4) {
                        double otSum = 0;
                        System.out.println("Other:");
                        if (!purMap.containsKey("other")) {
                            System.out.println("The purchase list is empty!");
                            System.out.println();
                            continue;
                        }
                        for (Purchase temp : purMap.get("Other")) {
                            System.out.println(temp);
                            otSum = otSum + temp.getPrice();
                        }
                        System.out.println("Total sum: $" + otSum);
                        System.out.println();
                        continue;
                    }
                    if (purCho == 5) {
                        System.out.println("All:");
                        for (String temp : purMap.keySet()) {
                            for (Purchase tempo : purMap.get(temp)) {
                                System.out.println(tempo);
                                totalSum = totalSum + tempo.getPrice();
                            }
                        }
                        System.out.println("Total sum: $" + totalSum);
                        System.out.println();
                        //continue;
                        }
                    }
                }
                if (choice == 5) {
                    File file = new File(".//purchases.txt");
                    try (PrintWriter writer = new PrintWriter(file)){
                        writer.println("Category: " + "balance: " + balance );
                        for (String temp : purMap.keySet()) {
                            for(Purchase tempo: purMap.get(temp)) {
                                writer.println(temp + ": " + tempo.getName() + ": " + String.format("%.2f",tempo.getPrice()));
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Purchases were saved!");
                    System.out.println();
                }
                if (choice == 6) {
                    File file  = new File(".//purchases.txt");
                    try (Scanner scanner1 = new Scanner(file)) {

                        while(scanner1.hasNext()) {
                            String[] string = scanner1.nextLine().split(": ");
                            String category = string[0];
                            String name = string[1];
                            Double price = Double.parseDouble(string[2]);
                            if(name.equals("balance")) {
                                balance = price;
                                continue;
                            }
                            if(!purMap.containsKey(category)) {
                                purMap.put(category, new ArrayList<>());
                            }
                            purMap.get(category).add(new Purchase(name,price));
                        }
                        System.out.println("Purchases were loaded!");
                        System.out.println();
                    } catch (FileNotFoundException e) {
                        System.out.println("No file found!");
                    }
                }
                if(choice == 7) {
                    while (true) {
                        System.out.println("How do you want to sort?");
                        System.out.println("1) Sort all purchases");
                        System.out.println("2) Sort by type");
                        System.out.println("3) Sort certain type");
                        System.out.println("4) Back");
                        System.out.println();
                        int input = Integer.valueOf(scanner.nextLine());
                        if(input == 1) {
                            if (purMap.isEmpty()) {
                                System.out.println();
                                System.out.println("The purchase list is empty!");
                                System.out.println();
                                continue;
                            }
                            System.out.println();
                            sortAll(purMap);
                            System.out.println();
                        }
                        if (input == 2) {
                            System.out.println();
                            sortByType(purMap);
                            System.out.println();
                        }
                        if (input == 3) {
                            System.out.println();
                            System.out.println("Choose the type of purchases");
                            System.out.println("1) Food");
                            System.out.println("2) Clothes");
                            System.out.println("3) Entertainment");
                            System.out.println("4) Other");
                            System.out.println();
                            int secInput = Integer.valueOf(scanner.nextLine());
                            if (secInput == 1) {
                                if(!purMap.containsKey("Food")) {
                                    System.out.println();
                                    System.out.println("The purchase list is empty!");
                                    System.out.println();
                                    continue;
                                }
                                System.out.println();
                                sortCertain(purMap,"Food");
                                System.out.println();
                            }
                            if (secInput == 2) {
                                if(!purMap.containsKey("Clothes")) {
                                    System.out.println();
                                    System.out.println("The purchase list is empty!");
                                    System.out.println();
                                    continue;
                                }
                                System.out.println();
                                sortCertain(purMap,"Clothes");
                                System.out.println();
                            }
                            if (secInput == 3) {
                                if(!purMap.containsKey("Entertainment")) {
                                    System.out.println();
                                    System.out.println("The purchase list is empty!");
                                    System.out.println();
                                    continue;
                                }
                                System.out.println();
                                sortCertain(purMap,"Entertainment");
                                System.out.println();
                            }
                            if (secInput == 4) {
                                if(!purMap.containsKey("Other")) {
                                    System.out.println();
                                    System.out.println("The purchase list is empty!");
                                    System.out.println();
                                    continue;
                                }
                                System.out.println();
                                sortCertain(purMap,"Other");
                                System.out.println();
                            }
                        }
                        if (input == 4) {
                            System.out.println();
                            break;
                        }
                    }
                }

            }
        System.out.println();
        System.out.println("Bye!");
    }

    public static void sortAll(Map<String,ArrayList<Purchase>> aMap) {

        double totalSum = 0;
        ArrayList<Purchase> tempList = new ArrayList<>();
        for (String temp : aMap.keySet()) {
            for (Purchase tempo : aMap.get(temp)) {
                tempList.add(tempo);
                totalSum = totalSum + tempo.getPrice();
            }
        }
        Collections.sort(tempList,Collections.reverseOrder());

        System.out.println("All:");
        for (Purchase pur : tempList) {
            System.out.println(pur);
        }
        System.out.printf("%s$%.2f","Total: ",totalSum);
        System.out.println();
    }
    public static void sortByType(Map<String,ArrayList<Purchase>> aMap) {
        //double total = 0;
        double grandTotal = 0;
        Map<String, Double> newMap = new HashMap<>();
        for (String temp : aMap.keySet()) {
            double total = 0;
            for (Purchase pur : aMap.get(temp)) {
                total = total + pur.getPrice();
            }
            newMap.put(temp, total);
        }
        ArrayList<Double> tempList = new ArrayList<>(newMap.values());
        Collections.sort(tempList,Collections.reverseOrder());
        //Collections.reverse(tempList);
        System.out.println("Types:");
        for (double tempo : tempList) {
            for (String t : newMap.keySet()) {
                if (newMap.get(t) == tempo) {
                    System.out.printf("%s - $%.2f",t,tempo);
                    System.out.println();
                    grandTotal = grandTotal + tempo;
                    break;
                }
            }
        }
        System.out.printf("Total sum: $%.2f", grandTotal);
        System.out.println();
    }
    public static void sortCertain(Map<String,ArrayList<Purchase>> aMap, String input) {
        double totalSum = 0;
        ArrayList<Purchase> tempList = new ArrayList<>();
        System.out.println(input + ": ");
        for (Purchase tempo : aMap.get(input)) {
            tempList.add(tempo);
            totalSum = totalSum + tempo.getPrice();
        }
        Collections.sort(tempList,Collections.reverseOrder());
        //Collections.reverse(tempList);
        for (Purchase pur : tempList) {
            System.out.println(pur);
        }
        System.out.printf("%s: $%.2f","Total sum: ",totalSum);
        System.out.println();
    }


}

