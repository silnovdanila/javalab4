public class Dessert extends Dish {
    private int weight;
    private int isSugar;
    private String reasonOfDiscount;

    public Dessert(int price, String name, int weight, int isSugar) {
        super(price, name);
        this.weight = weight;
        this.isSugar = isSugar;
    }
    public void setDiscount(int discount, String reason) {
        this.discount = discount;
        this.reasonOfDiscount = reason;
    }
    @Override
    public void getDescription() {
        if (isSugar == 0) {
            System.out.println(this.name + " with no sugar  " + price + "rub  " + weight + "gr  ");
        } else {
            System.out.println(this.name + "  " + price + "rub  " + weight + "gr  ");
        }
    }

    public static void main(String[] args) {
        Dessert dessert = new Dessert(150, "Chocolate cake", 200, 1);
        dessert.setDiscount(10, "Happy hour");
        dessert.getDescription();
    }
}