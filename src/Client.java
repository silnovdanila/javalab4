import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    private final String name;
    private final DiscountCard card;
    private Order currentOrder;

    public Client(String name) {
        this.card = new DiscountCard();
        this.name = name;
        this.currentOrder = new Order();
    }
    public static Client getNewClient() {
        System.out.print("\nWelcome to the cafe\nPlease, enter your name - ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return new Client(name);
    }

    public String getName() {
        return this.name;
    }

    public void setOrder(Order order) {
        this.currentOrder = order;
    }

    public void payWithCard() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        boolean i = false;
        do{
            System.out.print("\nEnter the PIN of your card: ");
            try{
                sum = scanner.nextInt();
                i = false;
            }catch(InputMismatchException e){
                i = true;
                System.out.print("\nThe PIN is incorrect\n");
            }
        } while (i);
        if (sum < 1000 || sum > 9999){
            throw(new IllegalArgumentException("PIN is incorrect"));
        }
        System.out.println("\nThe payment was successful");
    }

    public void payClient() {
        int sum = this.currentOrder.orderSum();
        double discountedPrice = sum * (1 - this.card.getDiscount());
        System.out.println("\nThe price of order is " + discountedPrice + " rub, your discount is " + this.card.getDiscount() * 100 + "%");
        try{
            this.payWithCard();
        }catch (IllegalArgumentException e){
            System.out.println("PIN is incorrect. Order is cancelled");
        }
    }

    public void addHistory() {
        this.card.setDiscount(DiscountCard.getNewDiscount(this.card.getDiscount()));
        this.card.addToHistoryOfOrders(this.currentOrder);
    }
}