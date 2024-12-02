import java.util.ArrayList;

public class DiscountCard {
    private int id;
    private double discount;
    private ArrayList<Order> historyOfOrders;

    public DiscountCard(int id) {
        this.id = id;
        this.discount = 0.0;
        this.historyOfOrders = new ArrayList<Order>();
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public static double getNewDiscount(double currentDiscount) {
        if (currentDiscount >= 0.089) {
            return 0.1;
        } else {
            return currentDiscount + 0.01;
        }
    }

    public void addToHistoryOfOrders(Order newOrder) {
        this.historyOfOrders.add(newOrder);
    }
}