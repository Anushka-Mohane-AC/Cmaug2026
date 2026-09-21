import java.io.*;

public abstract class Employee implements Serializable {
    String name;
    String address;
    int age;
    String gender;
    float basicSal;

    public Employee(String name, String address, int age, String gender, float basicSal) {
        this.name = name;
        this.address = address;
        this.age = (age < 18 || age > 65) ? 21 : age;
        this.gender = gender;
        this.basicSal = basicSal;
    }

    public abstract void display();
}