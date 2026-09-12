import java.util.Scanner;

public class Assignment_1_2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Assignment_1 dateObj = new Assignment_1();
        int choice =0;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Set Date");
            System.out.println("2. Add Days");
            System.out.println("3. Add Months");
            System.out.println("4. Add Years");
            System.out.println("5. Display Date");
            System.out.println("6. Compare Dates");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Day (1-31): ");
                    int d = sc.nextInt();
                    System.out.print("Enter Month (1-12): ");
                    int m = sc.nextInt();
                    System.out.print("Enter Year: ");
                    int y = sc.nextInt();
                    dateObj.setDate(d, m, y);
                    break;

                case 2:
                    System.out.print("Enter number of days to add: ");
                    int days = sc.nextInt();
                    dateObj.addDays(days);
                    break;

                case 3:
                    System.out.print("Enter number of months to add: ");
                    int months = sc.nextInt();
                    dateObj.addMonths(months);
                    break;

                case 4:
                    System.out.print("Enter number of years to add: ");
                    int years = sc.nextInt();
                    dateObj.addYears(years);
                    break;

                case 5:
                    dateObj.display();
                    break;

                case 6:
                    System.out.println("Feature not implemented yet.");
                    break;

                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select an option from 1 to 7.");
            }
        } while (choice != 7);

        sc.close();
    }
}



