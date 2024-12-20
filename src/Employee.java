import java.util.ArrayList;

public abstract class Employee implements GetName {
    protected int salary;
    protected String job;
    protected String name;
    protected ArrayList<Discription> items;

    public Employee(int salary, String job, String name) {
        this.salary = salary;
        this.job = job;
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getJob() {
        return this.job;
    }
    public void performAllMotions() {
        for (int i = 0; i <this.items.size(); i++) {
            this.items.get(i).getDiscription();
        }
    }
    public void addMotion(Discription newMotion) {
        this.items.add(newMotion);
    }

}