public class Engineer extends Employee {
    float overtime;

    public Engineer(String name, String address, int age, String gender, float basicSal, float overtime) {
        super(name, address, age, gender, basicSal);
        this.overtime = overtime;
    }

    public void display() {
        System.out.println("[Engineer] Name: " + name + "Age: " + age + "Gender: " + gender +
                "Address: " + address + "Salary: " + basicSal + "Overtime: " + overtime);
    }
}