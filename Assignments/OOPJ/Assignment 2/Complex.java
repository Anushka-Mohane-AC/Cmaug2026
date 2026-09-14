import java.util.Scanner;

    class Complex {
        double real;
        double imag;

        Complex(double r, double i) {
            real = r;
            imag = i;
        }

        static Complex add(Complex c1, Complex c2) {
            return new Complex(c1.real + c2.real, c1.imag + c2.imag);
        }

        static Complex subtract(Complex c1, Complex c2) {
            return new Complex(c1.real - c2.real, c1.imag - c2.imag);
        }

        static Complex multiply(Complex c1, Complex c2) {
            double r = (c1.real * c2.real) - (c1.imag * c2.imag);
            double i = (c1.real * c2.imag) + (c1.imag * c2.real);
            return new Complex(r, i);
        }

        void display() {
            if (imag >= 0)
                System.out.println(real + " + " + imag + "i");
            else
                System.out.println(real + " - " + (-imag) + "i");
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter real and imaginary part of first number: ");
            Complex c1 = new Complex(sc.nextDouble(), sc.nextDouble());

            System.out.print("Enter real and imaginary part of second number: ");
            Complex c2 = new Complex(sc.nextDouble(), sc.nextDouble());

            System.out.print("Sum: ");
            add(c1, c2).display();

            System.out.print("Difference: ");
            subtract(c1, c2).display();

            System.out.print("Product: ");
            multiply(c1, c2).display();

            sc.close();
        }
    }
