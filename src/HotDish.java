public class HotDish extends Dish {
    private int weight;
    private int discount;
    private String reasonOfDiscount;

    public HotDish(int price, String name, int weight) {
        super(price, name);
        this.weight = weight;
    }
    public void setDiscount(int discount, String reason) {
        this.discount = discount;
        this.reasonOfDiscount = reason;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public void getDescription() {
        System.out.println(this.name + "  " + price + "rub  " + weight + "gr  ");
    }
}