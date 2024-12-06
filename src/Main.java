import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Dish hotdish1 = new Dish(1200, "Mashed potato");
        menu.addHotDish(hotdish1);
        Dish hotdish2 = new Dish(1100, "Sup");
        menu.addHotDish(hotdish2);
        Dish dessert1 = new Dish(700, "Cake");
        menu.addDessert(dessert1);
        Dish drink1 = new Dish(120, "Tea");
        menu.addDrink(drink1);
        menu.menuOut();

        Chef[] chefs = {
                new Chef("Vasiliy", 60000, "Chef"),
                new Chef("Gregory", 45000, "Povar"),
                new Chef("Egor", 45000, "Povar")
        };

        Waiter[] waiters = {
                new Waiter("Anna", 45000, "Waiter"),
                new Waiter("Maria", 45000, "Waiter")
        };
        ArrayList<Integer> order = new ArrayList<>();
        Client client1 = Client.getNewClient();
        getOrder(client1.getName(), waiters[0].getName(), chefs[0].getName(), menu, order);
        makeOrder(client1, waiters[1], chefs[1], menu, order);
        client1.payClient();
        client1.addHistory();

        Client client2 = Client.getNewClient();
        getOrder(client2.getName(), waiters[1].getName(), chefs[1].getName(), menu, order);
        makeOrder(client2, waiters[1], chefs[2], menu, order);
        client2.payClient();
        client2.addHistory();

        getOrder(client1.getName(), waiters[1].getName(), chefs[2].getName(), menu, order);
        makeOrder(client1, waiters[1], chefs[2], menu, order);
        client1.payClient();
        client1.addHistory();

    }


    public static void getOrder(String clientName, String waiterName, String chefName, Menu menu, ArrayList<Integer> order) {
        Scanner scanner = new Scanner(System.in);
        int num, nextInt;

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
                nextInt = scanner.nextInt();
                if ((menu.getHotDishesAmount() + menu.getDessertAmount() + menu.getDrinksAmount()) >= nextInt){
                    order.add(nextInt);
                }
                else{
                    System.out.println("The entered numb is wrong!!! It's not added to order");
                    i--;
                }
            }
        } else {
            System.out.println("Invalid number of dishes.");
        }
    }

    public static void makeOrder(Client client, Waiter waiter, Chef chef, Menu menu, ArrayList<Integer> sp) {
        ArrayList<Dish> dishes = new ArrayList<>();

        for (Integer integer : sp) {
            if (integer <= menu.getHotDishesAmount()) {
                dishes.add(menu.getHotDish(integer - 1));
            } else if (integer <= menu.getHotDishesAmount() + menu.getDessertAmount()) {
                dishes.add(menu.getDessert(integer - menu.getHotDishesAmount() - 1));
            } else {
                dishes.add(menu.getDrink(integer - menu.getHotDishesAmount() - menu.getDessertAmount() - 1));
            }
        }
        Order newOrder = new Order();
        for (Dish dish : dishes) {
            newOrder.addDish(dish);
        }
        client.setOrder(newOrder);
        waiter.setOrder(newOrder);
        chef.setOrder(newOrder);
        sp.clear();
    }
}