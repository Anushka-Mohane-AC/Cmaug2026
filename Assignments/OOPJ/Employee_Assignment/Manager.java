public class Manager extends Employee {
    float hra;

    public Manager(String name, String address, int age, String gender, float basicSal, float hra) {
        super(name, address, age, gender, basicSal);
        this.hra = hra;
    }

    public void display() {
        System.out.println("[Manager] Name: " + name + "Age: " + age + "Gender: " + gender +
                "Address: " + address + "Salary: " + basicSal + "HRA: " + hra);
    }
}
