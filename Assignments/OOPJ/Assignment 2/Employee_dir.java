public class Employee_dir {
        String name;
        int yearOfJoining;
        String address;

        Employee_dir(String name, int yearOfJoining, String address) {
            this.name = name;
            this.yearOfJoining = yearOfJoining;
            this.address = address;
        }

        public static void main(String[] args) {
            Employee_dir e1 = new Employee_dir("Robert", 1994, "64C-Walls Streat");
            Employee_dir e2 = new Employee_dir("Sam", 2000, "68D-WallsStreat");
            Employee_dir e3 = new Employee_dir("John", 1999, "26B-WallsStreat");

            System.out.printf("%-10s %-20s %-20s%n", "Name", "Year of joining", "Address");
            System.out.printf("%-10s %-20d %-20s%n", e1.name, e1.yearOfJoining, e1.address);
            System.out.printf("%-10s %-20d %-20s%n", e2.name, e2.yearOfJoining, e2.address);
            System.out.printf("%-10s %-20d %-20s%n", e3.name, e3.yearOfJoining, e3.address);
        }
    }

