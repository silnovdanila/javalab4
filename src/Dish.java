public class Dish {
    private int price;
    private String name;
    public Dish(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public void setPrice(int a){
        this.price = a;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getPrice() {
        return this.price;
    }
    public String getName() {
        return this.name;
    }
}