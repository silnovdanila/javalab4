public class Drink extends Dish  {
    private int ml;
    private int alcohol;
    private String reasonOfDiscount;

    public Drink(int price, String name, int ml, int alcohol) {
        super(price, name);
        this.ml = ml;
        this.alcohol = alcohol;
    }

    public void setDiscount(int discount, String reason) {
        super.setDiscount(discount);
        this.reasonOfDiscount = reason;
    }

    @Override
    public void getDescription() {
        if (alcohol == 0) {
            System.out.println(this.name + "  " + this.price + "rub  " + ml + "ml  ");
        } else {
            System.out.println(this.name + " with " + alcohol + "% alcohol  " + this.price + "rub  " + ml + "ml  ");
        }
    }
}