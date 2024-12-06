import java.util.ArrayList;

public class Menu {
    private ArrayList<Dish> hotDishes;
    private ArrayList<Dish> desserts;
    private ArrayList<Dish> drinks;

    public Menu() {
        this.hotDishes = new ArrayList<>();
        this.desserts = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }
    public int getHotDishesAmount(){ return this.hotDishes.size(); }
    public int getDessertAmount(){
        return this.desserts.size();
    }
    public int getDrinksAmount(){
        return this.drinks.size();
    }
    public Dish getHotDish(int index) {
        return this.hotDishes.get(index);
    }
    public Dish getDessert(int index) {
        return this.desserts.get(index);
    }
    public Dish getDrink(int index) {
        return this.drinks.get(index);
    }
    public void addHotDish(Dish dish) {
        this.hotDishes.add(dish);
    }
    public void addDessert(Dish dish) {
        this.desserts.add(dish);
    }
    public void addDrink(Dish dish) {
        this.drinks.add(dish);
    }

    public void menuOut() {
        if (!hotDishes.isEmpty()) {
            System.out.println("\n\n\tMENU\nHot Dishes:");
            for (int i = 0; i < hotDishes.size(); i++) {
                System.out.println((i + 1) + " - " + hotDishes.get(i).getName() + "  " + hotDishes.get(i).getPrice());
            }
        }

        if (!desserts.isEmpty()) {
            System.out.println("\nDesserts:");
            for (int i = 0; i < desserts.size(); i++) {
                System.out.println((i + 1 + hotDishes.size()) + " - " + desserts.get(i).getName() + "  " + desserts.get(i).getPrice());
            }
        }

        if (!drinks.isEmpty()) {
            System.out.println("\nDrinks:");
            for (int i = 0; i < drinks.size(); i++) {
                System.out.println((i + 1 + hotDishes.size() + desserts.size()) + " - " + drinks.get(i).getName() + "  " + drinks.get(i).getPrice());
            }
        }
    }
}