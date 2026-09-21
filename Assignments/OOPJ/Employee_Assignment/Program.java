import java.io.*;

public class Program {
    static DoublyLinkedList list = new DoublyLinkedList();
    static String fileName = "emp_data.txt";

    static Employee createEmployee(int type) {
        System.out.print("Enter Name: ");
        String name = Console_Emp.getString();
        System.out.print("Enter Address: ");
        String addr = Console_Emp.getString();
        System.out.print("Enter Age: ");
        int age = Console_Emp.getInt();
        System.out.print("Enter Gender: ");
        String gender = Console_Emp.getString();
        System.out.print("Enter Basic Salary: ");
        float sal = Console_Emp.getFloat();

        if (type == 1) {
            System.out.print("Enter HRA: ");
            float hra = Console_Emp.getFloat();
            return new Manager(name, addr, age, gender, sal, hra);
        } else if (type == 2) {
            System.out.print("Enter Overtime: ");
            float ot = Console_Emp.getFloat();
            return new Engineer(name, addr, age, gender, sal, ot);
        } else {
            System.out.print("Enter Commission: ");
            float comm = Console_Emp.getFloat();
            return new SalesPerson(name, addr, age, gender, sal, comm);
        }
    }

    // Bubble Sort
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

    static void printSorted(Class<?> filterClass, boolean asc) {
        Employee[] all = list.toArray();
        int count = 0;
        for (Employee e : all) {
            if (filterClass == null || filterClass.isInstance(e)) count++;
        }

        if (count == 0) {
            System.out.println("No matching records found.");
            return;
        }

        Employee[] filtered = new Employee[count];
        int idx = 0;
        for (Employee e : all) {
            if (filterClass == null || filterClass.isInstance(e)) {
                filtered[idx++] = e;
            }
        }

        bubbleSort(filtered, filtered.length, asc);
        for (Employee e : filtered) {
            e.display();
        }
    }

    public static void main(String[] args) {
        int ch = 0;

        do {
            System.out.println("1. Add an Employee");
            System.out.println("2. Display");
            System.out.println("3. Sort");
            System.out.println("4. Save to File");
            System.out.println("5. Load from File");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            ch = Console_Emp.getInt();

            switch (ch) {
                case 1:
                    String addOpt = "";
                    do {
                        System.out.println("\n1. Add Employee");
                        System.out.println("a. Manager");
                        System.out.println("b. Engineer");
                        System.out.println("c. Sales Person");
                        System.out.println("d. Exit to Main Menu");
                        System.out.print("Select role: ");
                        addOpt = Console_Emp.getString().toLowerCase();

                        if (addOpt.equals("a")) list.add(createEmployee(1));
                        else if (addOpt.equals("b")) list.add(createEmployee(2));
                        else if (addOpt.equals("c")) list.add(createEmployee(3));
                        else if (!addOpt.equals("d")) System.out.println("Invalid option.");
                    } while (!addOpt.equals("d"));
                    break;

                case 2:
                    String dispOpt = "";
                    do {
                        System.out.println("\n2. Display");
                        System.out.println("a. All Employees");
                        System.out.println("b. First Employee");
                        System.out.println("c. Next Employee");
                        System.out.println("d. Previous Employee");
                        System.out.println("e. Last Employee");
                        System.out.println("f. Exit to Main Menu");
                        System.out.print("Select option: ");
                        dispOpt = Console_Emp.getString().toLowerCase();

                        if (dispOpt.equals("a")) list.displayAll();
                        else if (dispOpt.equals("b")) list.displayFirst();
                        else if (dispOpt.equals("c")) list.displayNext();
                        else if (dispOpt.equals("d")) list.displayPrev();
                        else if (dispOpt.equals("e")) list.displayLast();
                        else if (!dispOpt.equals("f")) System.out.println("Invalid option.");
                    } while (!dispOpt.equals("f"));
                    break;

                case 3:
                    String sortOpt = "";
                    do {
                        System.out.println("\n3. Sort");
                        System.out.println("a. All Managers");
                        System.out.println("b. All Engineers");
                        System.out.println("c. All Sales Person");
                        System.out.println("d. All Employees Alphabetic order ascending");
                        System.out.println("e. All Employees Alphabetic order descending");
                        System.out.println("f. Exit to Main Menu");
                        System.out.print("Select option: ");
                        sortOpt = Console_Emp.getString().toLowerCase();

                        if (sortOpt.equals("a")) printSorted(Manager.class, true);
                        else if (sortOpt.equals("b")) printSorted(Engineer.class, true);
                        else if (sortOpt.equals("c")) printSorted(SalesPerson.class, true);
                        else if (sortOpt.equals("d")) printSorted(null, true);
                        else if (sortOpt.equals("e")) printSorted(null, false);
                        else if (!sortOpt.equals("f")) System.out.println("Invalid option.");
                    } while (!sortOpt.equals("f"));
                    break;

                case 4:
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
                        oos.writeObject(list);
                        oos.close();
                        System.out.println("Saved successfully to " + fileName);
                    } catch (Exception e) {
                        System.out.println("Error saving: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
                        list = (DoublyLinkedList) ois.readObject();
                        list.current = list.head;
                        ois.close();
                        System.out.println("Loaded successfully from " + fileName);
                    } catch (Exception e) {
                        System.out.println("Error loading: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Terminating program.");
                    break;

                default:
                    System.out.println("Invalid selection. Try again.");
            }
        } while (ch != 6);
    }
}