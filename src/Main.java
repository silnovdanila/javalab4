import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


    }


    public static void getOrder(String clientName, String waiterName, String chefName, Menu menu, int[] order) {
        Scanner scanner = new Scanner(System.in);
        int num;

        System.out.println("\nHello, " + clientName);
        System.out.println("Your waiter - " + waiterName);
        System.out.println("Your chef - " + chefName);
        System.out.println("Here is the menu:");
        menu.menuOut();

        System.out.print("\nHow many dishes you want to order. Enter a number > 0 - ");
        num = scanner.nextInt();

        if (num >= 0) {
            System.out.print("To place an order, enter the numbers of items you want to order - ");
            for (int i = 0; i < num; i++) {
                order[i] = scanner.nextInt();
            }
            order[num] = 0;
        } else {
            System.out.println("Invalid number of dishes. Please enter a number upper than 0.");
        }
    }

    public static int makeOrder(Client client, Waiter waiter, Chef chef, Menu menu, int[] sp) {
        ArrayList<Dish> dishes = new ArrayList<>();
        int dishCount = 0;

        for (int i = 0; sp[i] != 0; i++) {
            if (sp[i] <= menu.getHotDishesAmount()) {
                dishes.add(menu.getHotDish(sp[i] - 1));
            } else if (sp[i] <= menu.getHotDishesAmount() + menu.getDessertAmount()) {
                dishes.add(menu.getDessert(sp[i] - menu.getHotDishesAmount() - 1));
            } else {
                dishes.add(menu.getDrink(sp[i] - menu.getHotDishesAmount() - menu.getDessertAmount() - 1));
            }
            dishCount++;
        }

        Order newOrder = new Order();
        for (int i = 0; i < dishCount; i++) {
            newOrder.addDish(dishes.get(i));
        }
        client.setOrder(newOrder);
        waiter.setOrder(newOrder);
        chef.setOrder(newOrder);
        return dishCount;
    }
}