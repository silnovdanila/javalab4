public class Dish {
    private int price;
    private String name;
    public Dish(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public Dish() {
        this.price = 0;
        this.name = "";
    }
    public int getPrice() {
        return this.price;
    }
    public String getName() {
        return this.name;
    }
}