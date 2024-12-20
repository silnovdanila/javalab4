public class Dish implements GetName{
    protected int price;
    protected String name;
    protected int discount;

    public Dish(int price, String name) {
        this.price = price;
        this.name = name;
        this.discount = 0;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return this.price;
    }
    public String getName() {
        return this.name;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public Dish add(Dish dish) {
        this.name = this.name + " " + dish.getName();
        this.price += dish.getPrice();
        return this;
    }

    public void getDescription() {
        System.out.println(this.name + "  " + this.price);
    }

    final void notVirtualDescription() {
        this.getDescription();
    }
}