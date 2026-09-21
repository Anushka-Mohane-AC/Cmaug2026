public class SalesPerson extends Employee {
    float commission;

    public SalesPerson(String name, String address, int age, String gender, float basicSal, float commission) {
        super(name, address, age, gender, basicSal);
        this.commission = commission;
    }

    public void display() {
        System.out.println("[Sales Person] Name: " + name + "Age: " + age + "Gender: " + gender +
                "Address: " + address + "Salary: " + basicSal + "Commission: " + commission);
    }
}