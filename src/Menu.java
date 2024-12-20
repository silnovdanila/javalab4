import java.util.ArrayList;

public class Menu {
    private ArrayList<HotDish> hotDishes;
    private ArrayList<Dessert> desserts;
    private ArrayList<Drink> drinks;

    public Menu() {
        this.hotDishes = new ArrayList<>();
        this.desserts = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }
    public Menu(Menu menu){
        this.drinks = new ArrayList<>();
        Drink dr;
        for(int i = 0; i < menu.drinks.size(); i++){
            dr = menu.getDrink(i);
            this.drinks.add(dr);
        }
        this.desserts = new ArrayList<>();
        Dessert des;
        for(int i = 0; i < menu.desserts.size(); i++){
            des = menu.getDessert(i);
            this.desserts.add(des);
        }
        this.hotDishes = new ArrayList<>();
        HotDish hot;
        for(int i = 0; i < menu.hotDishes.size(); i++){
            hot = menu.getHotDish(i);
            this.hotDishes.add(hot);
        }
    }
    public int getHotDishesAmount(){ return this.hotDishes.size(); }
    public int getDessertAmount(){
        return this.desserts.size();
    }
    public int getDrinksAmount(){
        return this.drinks.size();
    }
    public HotDish getHotDish(int index) {
        return this.hotDishes.get(index);
    }
    public Dessert getDessert(int index) {
        return this.desserts.get(index);
    }
    public Drink getDrink(int index) {
        return this.drinks.get(index);
    }
    public void addHotDish(HotDish dish) {
        this.hotDishes.add(dish);
    }
    public void addDessert(Dessert dish) {
        this.desserts.add(dish);
    }
    public void addDrink(Drink dish) {
        this.drinks.add(dish);
    }

    public void menuOut() {
        if (!hotDishes.isEmpty()) {
            System.out.println("\n\n\tMENU\nHot Dishes:");
            for (int i = 0; i < hotDishes.size(); i++) {
                hotDishes.get(i).getDescription();
            }
        }

        if (!desserts.isEmpty()) {
            System.out.println("\nDesserts:");
            for (int i = 0; i < desserts.size(); i++) {
                desserts.get(i).getDescription();
            }
        }

        if (!drinks.isEmpty()) {
            System.out.println("\nDrinks:");
            for (int i = 0; i < drinks.size(); i++) {
                drinks.get(i).getDescription();
            }
        }
    }
}