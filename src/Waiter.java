public class Waiter extends Employee {
    private String name;
    private Order currentOrder;

    public Waiter(String name, int salary, String job) {
        super(salary, job, name);
        this.name = name;
        this.currentOrder = null;
    }

    public String getName() {
        return this.name;
    }

    public void setOrder(Order order) {
        this.currentOrder = order;
    }
}