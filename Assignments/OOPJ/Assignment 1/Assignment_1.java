import java.util.Scanner;
class Assignment_1 {
    private int day;
    private int month;
    private int year;
    private boolean isSet = false;

    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }

    public static int getDaysInMonth(int m, int y) {
        if (m == 2 && isLeapYear(y)) {
            return 29;
        }
        return DAYS_IN_MONTH[m];
    }

    public boolean setDate(int d, int m, int y) {
        if (y < 1) {
            System.out.println("Error: Year must be greater than 0.");
            return false;
        }
        if (m < 1 || m > 12) {
            System.out.println("Error: Month must be between 1 and 12.");
            return false;
        }
        int maxDays = getDaysInMonth(m, y);
        if (d < 1 || d > maxDays) {
            System.out.println("Error: Invalid day for " + getMonthName(m) + " " + y + " (max allowed is " + maxDays + ").");
            return false;
        }

        this.day = d;
        this.month = m;
        this.year = y;
        this.isSet = true;
        System.out.println("Date set successfully.");
        return true;
    }

    public void addDays(int daysToAdd) {
        if (!isSet) {
            System.out.println("Please set a valid date first.");
            return;
        }
        if (daysToAdd < 0) {
            System.out.println("Please enter a non-negative number of days.");
            return;
        }

        day += daysToAdd;
        while (true) {
            int maxDays = getDaysInMonth(month, year);
            if (day <= maxDays) {
                break;
            }
            day -= maxDays;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
        System.out.println(daysToAdd + " day(s) added successfully.");
    }

    public void addMonths(int monthsToAdd) {
        if (!isSet) {
            System.out.println("Please set a valid date first.");
            return;
        }
        if (monthsToAdd < 0) {
            System.out.println("Please enter a non-negative number of months.");
            return;
        }

        int totalMonths = (month - 1) + monthsToAdd;
        year += totalMonths / 12;
        month = (totalMonths % 12) + 1;

        // Leap year and month-end boundary adjustment
        int maxDays = getDaysInMonth(month, year);
        if (day > maxDays) {
            day = maxDays;
        }
        System.out.println(monthsToAdd + " month(s) added successfully.");
    }

    public void addYears(int yearsToAdd) {
        if (!isSet) {
            System.out.println("Please set a valid date first.");
            return;
        }
        if (yearsToAdd < 0) {
            System.out.println("Please enter a non-negative number of years.");
            return;
        }

        year += yearsToAdd;

        // If the date is Feb 29 and target year is not a leap year, cap day at 28
        int maxDays = getDaysInMonth(month, year);
        if (day > maxDays) {
            day = maxDays;
        }
        System.out.println(yearsToAdd + " year(s) added successfully.");
    }

    public void display() {
        if (!isSet) {
            System.out.println("Date is not set yet.");
            return;
        }
        System.out.printf("Current Date: %02d/%02d/%04d%n", day, month, year);
    }

    private static String getMonthName(int m) {
        String[] names = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return names[m];
    }
}

