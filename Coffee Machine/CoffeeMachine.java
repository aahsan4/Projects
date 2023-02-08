//import java.util.*;
package machine;
import java.util.*;
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeMachine machine = new CoffeMachine();
        System.out.println();
        start(scanner,machine);
        System.out.println();

    }
    public static void start(Scanner scanner,CoffeMachine machine) {
        while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String input = scanner.nextLine();
            if (input.equals("fill")) {
                System.out.println("Write how many ml of water you want to add:");
                int water = Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many ml of milk you want to add:");
                int milk = Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many grams of coffee beans you want to add:");
                int beans = Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many disposable cups you want to add:");
                int cups = Integer.parseInt(scanner.nextLine());
                machine.fill(water, milk, beans, cups);
            }
            if (input.equals("take")) {
                machine.take();
            }
            if (input.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String in = scanner.nextLine();
                if (in.equals("1")) {
                    if (machine.check(250,0,16)) {
                        machine.buy(250, 0, 16, 4);
                    }
                }
                if (in.equals("2")) {
                    if (machine.check(350,75,20)) {
                        machine.buy(350, 75, 20, 7);
                    }
                }
                if (in.equals("3")) {
                    if (machine.check(200,100,12)) {
                        machine.buy(200, 100, 12, 6);
                    }
                }
                if (in.equals("back")) {
                    continue;
                }

            }
            if (input.equals("exit")) {
                break;
            }
            if (input.equals("remaining")) {
                System.out.println(machine);
            }
        }
    }

}
