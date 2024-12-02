public class Employee {
    protected int salary;
    protected String job;
    protected String name;

    public Employee(int salary, String job, String name) {
        this.salary = salary;
        this.job = job;
        this.name = name;
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
}