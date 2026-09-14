public class Emp_sal {
        double salary;
        int hoursPerDay;

        void getInfo(double salary, int hoursPerDay) {
            this.salary = salary;
            this.hoursPerDay = hoursPerDay;
        }

        void addSal() {
            if (salary < 500) {
                salary += 10;
            }
        }

        void addWork() {
            if (hoursPerDay > 6) {
                salary += 5;
            }
        }

        public static void main(String[] args) {
            Emp_sal emp = new Emp_sal();
            emp.getInfo(450, 7); // Input: salary = $450, hours = 7
            emp.addSal();
            emp.addWork();

            System.out.println("Final Salary: $" + emp.salary);
        }
    }
