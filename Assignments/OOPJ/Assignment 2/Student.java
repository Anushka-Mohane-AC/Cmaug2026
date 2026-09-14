public class Student {
        String name;
        int roll_no;
        String phone_no;
        String address;

        public static void main(String[] args) {
            Student s1 = new Student();
            s1.name = "John";
            s1.roll_no = 2;

            Student sam = new Student();
            sam.name = "Sam";
            sam.roll_no = 1;
            sam.phone_no = "9876543210";
            sam.address = "12th Street, City";

            Student john = new Student();
            john.name = "John";
            john.roll_no = 2;
            john.phone_no = "9123456780";
            john.address = "45th Avenue, City";

            System.out.println("Student 1:");
            System.out.println("Name: " + sam.name + ", Roll No: " + sam.roll_no +
                    ", Phone: " + sam.phone_no + ", Address: " + sam.address);

            System.out.println("\nStudent 2:");
            System.out.println("Name: " + john.name + ", Roll No: " + john.roll_no +
                    ", Phone: " + john.phone_no + ", Address: " + john.address);
        }
    }

