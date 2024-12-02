import java.util.ArrayList;

public class Order {
    private ArrayList<Dish> order;
    private int dishes;

    public Order() {
        this.order = new ArrayList<>();
        this.dishes = 0;
    }
    public void addDish(Dish dish) {
        this.order.add(dish);
        this.dishes++;
    }
    public int orderSum() {
        int sum = 0;
        System.out.print("\nYour order: ");

        for (int i = 0; i < dishes; i++) {
            System.out.print(order.get(i).getName());
            sum += order.get(i).getPrice();

            if (i != dishes - 1) {
                System.out.print(", ");
            }
        }
        return sum;
    }
}