import java.util.Scanner;

public class Client {
    private String name;
    private DiscountCard card;
    private Order currentOrder;

    public Client(int id, String name) {
        this.card = new DiscountCard(id);
        this.name = name;
        this.currentOrder = new Order();
    }

    public static Client getNewClient(int id) {
        System.out.println("\nWelcome to the cafe\nPlease, enter your name - ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return new Client(id, name);
    }

    public String getName() {
        return this.name;
    }

    public void setOrder(Order order) {
        this.currentOrder = order;
    }

    public void payWithCard() {
        Scanner scanner = new Scanner(System.in);
        int sum;
        System.out.print("Enter payment amount: ");
        sum = scanner.nextInt();
        System.out.println("\nThe payment was successful");
    }

    public void payClient() {
        int sum = this.currentOrder.orderSum();
        double discountedPrice = sum * (1 - this.card.getDiscount());
        System.out.println("\nThe price of order is " + discountedPrice + " rub, your discount is " + this.card.getDiscount() * 100 + "%");
        System.out.print("\nEnter the card details for the payment: ");
        this.payWithCard();
    }

    public void addHistory() {
        this.card.setDiscount(this.card.getNewDiscount(this.card.getDiscount()));
        this.card.addToHistoryOfOrders(this.currentOrder);
    }
}