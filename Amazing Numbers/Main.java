package numbers;
import java.util.*;
public class Main {
    public static void main(String[] args) {
//        write your code here
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("""
                Supported requests:
                - enter a natural number to know its properties;
                - enter 0 to exit.
                """);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a request:");
            String num = scanner.nextLine();
            long input = Long.parseLong(num);
            if (input == 0) {
                break;
            }
            else if (input < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else {
                System.out.println("Properties of " + input);
                oddEven(input);
                checkBuzz(input);
                System.out.println("duck: " + checkDuck(num));
                System.out.println("palindromic: " + checkPalindrome(num));
                System.out.println();
            }
        }
        System.out.println("Goodbye!");
    }

    public static boolean checkDuck(String number) {
        String[] temp = number.split("");
        for (int i = 1; i < temp.length; i++) {
            if (temp[i].equals("0")) {
                return true;
            }
        }
        return false;
    }
    public static void oddEven(long num) {
        //int num = Integer.parseInt(number);
        if (num % 2 == 0) {
            System.out.println("even: true");
            System.out.println("odd: false");
        } else {
            System.out.println("even: false");
            System.out.println("odd: true");
        }
    }
    public static void checkBuzz(long input) {
        //int input = Integer.parseInt(number);
        if (input % 7 == 0 || (input % 10) == 7) {
            System.out.println("buzz: true");
        } else {
            System.out.println("buzz: false");
        }
    }
    public static boolean checkPalindrome(String number) {
        String[] temp = number.split("");
        int i = 0; int j = temp.length-1;
        while (i < j) {
            if (!temp[i].equals(temp[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
