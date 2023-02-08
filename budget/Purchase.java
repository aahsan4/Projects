package budget;

public class Purchase implements Comparable<Purchase> {
    String name;
    double price;
    public Purchase(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    @Override
    public String toString() {
        return String.format("%s $%.2f",this.name,this.price);
    }
    @Override
    public int compareTo(Purchase purchase) {
        if(this.getPrice() == purchase.getPrice()) {
            return 0;
        } else if (this.getPrice() > purchase.getPrice()) {
            return 1;
        } else {
            return -1;
        }
    }
}
