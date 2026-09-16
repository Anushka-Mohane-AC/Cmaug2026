import java.util.Scanner;

public class Program_Inheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Question 1
        System.out.println("QUESTION 1");
        Parent p = new Parent();
        Child c = new Child();

        p.printParent();
        c.printChild();
        c.printParent();

        //Question 2
        System.out.println("\nQUESTION 2");
        Member m = new Member();
        System.out.println("Enter Member details (Name, Age, Phone, Address, Salary):");
        m.setName(sc.nextLine());
        m.setAge(Integer.parseInt(sc.nextLine()));
        m.setPhoneNumber(sc.nextLine());
        m.setAddress(sc.nextLine());
        m.setSalary(Double.parseDouble(sc.nextLine()));

        System.out.println("\nMember Info:");
        System.out.println("Name: " + m.getName() + " | Age: " + m.getAge() +
                " | Phone: " + m.getPhoneNumber() + " | Address: " + m.getAddress());
        m.printSalary();

        PrimeMembers pm = new PrimeMembers();
        System.out.println("\nEnter PrimeMember details (Name, Age, Phone, Address, Salary, Year, Fees, IsActive):");
        pm.setName(sc.nextLine());
        pm.setAge(Integer.parseInt(sc.nextLine()));
        pm.setPhoneNumber(sc.nextLine());
        pm.setAddress(sc.nextLine());
        pm.setSalary(Double.parseDouble(sc.nextLine()));
        pm.setJoiningYear(Integer.parseInt(sc.nextLine()));
        pm.setJoiningFees(Double.parseDouble(sc.nextLine()));
        pm.setIsActive(Boolean.parseBoolean(sc.nextLine()));

        System.out.println("\nPrime Member Info:");
        pm.display();

        //Question 3
        System.out.println("\nQUESTION 3");
        RectangleInheritance rect = new RectangleInheritance(5, 4);
        SquareInheritance sq3 = new SquareInheritance(5);

        System.out.println("Rectangle (5x4):");
        rect.printArea();
        rect.printPerimeter();

        System.out.println("Square (Side 5):");
        sq3.printArea();
        sq3.printPerimeter();

        //Question 4
        System.out.println("\nQUESTION 4");
        SquareInheritance sq4 = new SquareInheritance();
        sq4.printShape();
        sq4.printRectangular();

        sc.close();
    }
}