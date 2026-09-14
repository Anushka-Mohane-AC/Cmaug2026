import java.util.Scanner;
public class complex_arrays {

        private int number1;
        private int number2;

        public int getNumber1() {
            return number1;
        }

        public void setNumber1(int number1) {
            this.number1 = number1;
        }

        public int getNumber2() {
            return number2;
        }

        public void setNumber2(int number2) {
            this.number2 = number2;
        }

        public int computeComplexNumber() {
            return number1 * number2;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            complex_arrays[] arr = new complex_arrays[5];

            for (int i = 0; i < 5; i++) {
                arr[i] = new complex_arrays();
                System.out.println("Enter number1 and number2 for object " + (i + 1) + ":");
                arr[i].setNumber1(sc.nextInt());
                arr[i].setNumber2(sc.nextInt());
            }

            System.out.println("\nResults after multiplication:");
            for (int i = 0; i < 5; i++) {
                System.out.println("Object " + (i + 1) + " result: " + arr[i].computeComplexNumber());
            }
            sc.close();
        }
    }

