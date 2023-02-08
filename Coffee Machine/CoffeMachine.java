package machine;
import java.util.*;
public class CoffeMachine {
    private int water;
    private int milk;
    private int coffee;
    private int balance;
    private int cups;

    public CoffeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffee = 120;
        this.balance = 550;
        this.cups = 9;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getBalance() {
        return balance;
    }

    public int getCups() {
        return cups;
    }
    public void fill(int water,int milk,int coffee,int cups) {
        this.water = this.water + water;
        this.milk = this.milk + milk;
        this.coffee = this.coffee + coffee;
        this.cups = this.cups + cups;
    }
    public void take() {
        System.out.println();
        System.out.println("I gave you $"+this.getBalance());
        this.balance = 0;
    }
    public void buy(int water,int milk,int coffee,int price) {
        this.water = this.water - water;
        this.milk = this.milk - milk;
        this.coffee = this.coffee - coffee;
        this.balance = this.balance + price;
        this.cups--;
    }
    public boolean check(int water, int milk, int coffee) {
        if (this.water >= water && this.milk >= milk && this.coffee>=coffee) {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else {
            if (this.water < water) {
                System.out.println("Sorry, not enough water!");
                //return false;
            }
            if (this.milk < milk) {
                System.out.println("Sorry, not enough milk!");
                //return false;
            }
            if (this.coffee < coffee) {
                System.out.println("Sorry, not enough coffee!");
                //return false;
            }
        }
        return false;
    }
    public String toString() {
        System.out.println();
        return "The coffee machine has:\n"+this.water+" ml of water\n"
                +this.milk+" ml of milk\n" + this.coffee+" g of coffee beans\n"
                +this.cups+" disposable cups\n" + "$"+this.balance+" of money\n";
    }

}
