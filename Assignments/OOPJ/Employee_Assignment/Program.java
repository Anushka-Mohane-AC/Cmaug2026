import java.io.*;
import java.util.Scanner;

abstract class Employee implements Serializable {
    String name, address, gender;
    int age;
    float basicSalary;

    Employee(String name, String address, int age, String gender, float basicSalary) {
        this.name = name;
        this.address = address;
        this.age = (age < 18 || age > 65) ? 21 : age;
        this.gender = gender;
        this.basicSalary = basicSalary;
    }

    abstract void display();
}

class Manager extends Employee {
    float hra;

    Manager(String name, String address, int age, String gender, float basicSalary, float hra) {
        super(name, address, age, gender, basicSalary);
        this.hra = hra;
    }

    void display() {
        System.out.println("[Manager] Name: " + name + " | Age: " + age + " | Gender: " + gender +
                " | Address: " + address + " | Salary: " + basicSalary + " | HRA: " + hra);
    }
}

class Engineer extends Employee {
    float overtime;

    Engineer(String name, String address, int age, String gender, float basicSalary, float overtime) {
        super(name, address, age, gender, basicSalary);
        this.overtime = overtime;
    }

    void display() {
        System.out.println("[Engineer] Name: " + name + " | Age: " + age + " | Gender: " + gender +
                " | Address: " + address + " | Salary: " + basicSalary + " | Overtime: " + overtime);
    }
}

class SalesPerson extends Employee {
    float commission;

    SalesPerson(String name, String address, int age, String gender, float basicSalary, float commission) {
        super(name, address, age, gender, basicSalary);
        this.commission = commission;
    }

    void display() {
        System.out.println("[Sales Person] Name: " + name + " | Age: " + age + " | Gender: " + gender +
                " | Address: " + address + " | Salary: " + basicSalary + " | Commission: " + commission);
    }
}

// Doubly Linked List Node
class Node implements Serializable {
    Employee data;
    Node prev, next;

    Node(Employee data) {
        this.data = data;
    }
}

// Doubly Linked List implementation
class DoublyLinkedList implements Serializable {
    Node head, tail;
    transient Node current;

    void add(Employee emp) {
        Node newNode = new Node(emp);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Employee added successfully!");
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No records found.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    void displayFirst() {
        if (head == null) { System.out.println("List is empty."); return; }
        current = head;
        current.data.display();
    }

    void displayLast() {
        if (tail == null) { System.out.println("List is empty."); return; }
        current = tail;
        current.data.display();
    }

    void displayNext() {
        if (head == null) { System.out.println("List is empty."); return; }
        if (current == null) current = head;
        else if (current.next != null) current = current.next;
        else System.out.println("(End of list reached)");
        current.data.display();
    }

    void displayPrev() {
        if (head == null) { System.out.println("List is empty."); return; }
        if (current == null) current = tail;
        else if (current.prev != null) current = current.prev;
        else System.out.println("(Beginning of list reached)");
        current.data.display();
    }

    int getCount() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    Employee[] toArray() {
        int size = getCount();
        Employee[] arr = new Employee[size];
        Node temp = head;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.data;
            temp = temp.next;
        }
        return arr;
    }
}

public class Program {
    static Scanner sc = new Scanner(System.in);
    static DoublyLinkedList list = new DoublyLinkedList();

    static Employee readAndCreate(int type) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Basic Salary: ");
        float salary = Float.parseFloat(sc.nextLine());

        if (type == 1) {
            System.out.print("Enter HRA: ");
            float hra = Float.parseFloat(sc.nextLine());
            return new Manager(name, address, age, gender, salary, hra);
        } else if (type == 2) {
            System.out.print("Enter Overtime: ");
            float overtime = Float.parseFloat(sc.nextLine());
            return new Engineer(name, address, age, gender, salary, overtime);
        } else {
            System.out.print("Enter Commission: ");
            float comm = Float.parseFloat(sc.nextLine());
            return new SalesPerson(name, address, age, gender, salary, comm);
        }
    }

    static void bubbleSort(Employee[] arr, int n, boolean asc) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int cmp = arr[j].name.compareToIgnoreCase(arr[j + 1].name);
                if ((asc && cmp > 0) || (!asc && cmp < 0)) {
                    Employee temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void printSorted(Class<?> filterType, boolean asc) {
        Employee[] fullArray = list.toArray();

        int matchCount = 0;
        for (Employee e : fullArray) {
            if (filterType == null || filterType.isInstance(e)) matchCount++;
        }

        if (matchCount == 0) {
            System.out.println("No records found to sort.");
            return;
        }

        Employee[] filtered = new Employee[matchCount];
        int idx = 0;
        for (Employee e : fullArray) {
            if (filterType == null || filterType.isInstance(e)) {
                filtered[idx++] = e;
            }
        }

        bubbleSort(filtered, filtered.length, asc);
        for (Employee e : filtered) {
            e.display();
        }
    }

    public static void main(String[] args) {
        int mainChoice = 0;
        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Add an Employee\n2. Display\n3. Sort\n4. Save to File\n5. Load from File\n6. Exit");
            System.out.print("Enter choice: ");
            mainChoice = Integer.parseInt(sc.nextLine());

            switch (mainChoice) {
                case 1:
                    char addOpt;
                    do {
                        System.out.println("\n--- Add Employee ---");
                        System.out.println("a. Manager\nb. Engineer\nc. Sales Person\nd. Exit to Main Menu");
                        System.out.print("Choice: ");
                        addOpt = sc.nextLine().toLowerCase().charAt(0);

                        if (addOpt == 'a') list.add(readAndCreate(1));
                        else if (addOpt == 'b') list.add(readAndCreate(2));
                        else if (addOpt == 'c') list.add(readAndCreate(3));
                    } while (addOpt != 'd');
                    break;

                case 2:
                    char dispOpt;
                    do {
                        System.out.println("\n--- Display Menu ---");
                        System.out.println("a. All Employees\nb. First Employee\nc. Next Employee\nd. Previous Employee\ne. Last Employee\nf. Exit to Main Menu");
                        System.out.print("Choice: ");
                        dispOpt = sc.nextLine().toLowerCase().charAt(0);

                        if (dispOpt == 'a') list.displayAll();
                        else if (dispOpt == 'b') list.displayFirst();
                        else if (dispOpt == 'c') list.displayNext();
                        else if (dispOpt == 'd') list.displayPrev();
                        else if (dispOpt == 'e') list.displayLast();
                    } while (dispOpt != 'f');
                    break;

                case 3:
                    char sortOpt;
                    do {
                        System.out.println("\n--- Sort Menu ---");
                        System.out.println("a. All Managers\nb. All Engineers\nc. All Sales Person\nd. All Employees Ascending\ne. All Employees Descending\nf. Exit to Main Menu");
                        System.out.print("Choice: ");
                        sortOpt = sc.nextLine().toLowerCase().charAt(0);

                        if (sortOpt == 'a') printSorted(Manager.class, true);
                        else if (sortOpt == 'b') printSorted(Engineer.class, true);
                        else if (sortOpt == 'c') printSorted(SalesPerson.class, true);
                        else if (sortOpt == 'd') printSorted(null, true);
                        else if (sortOpt == 'e') printSorted(null, false);
                    } while (sortOpt != 'f');
                    break;

                case 4:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
                        oos.writeObject(list);
                        System.out.println("Saved successfully to employees.dat!");
                    } catch (Exception e) {
                        System.out.println("Save error: " + e.getMessage());
                    }
                    break;

                case 5:
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
                        list = (DoublyLinkedList) ois.readObject();
                        list.current = list.head;
                        System.out.println("Loaded successfully from employees.dat!");
                    } catch (Exception e) {
                        System.out.println("Load error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Exiting. Bye!");
                    break;
            }
        } while (mainChoice != 6);
    }
}