public class Triangle {
    double a, b, c;
    Triangle(double side1, double side2, double side3) {
        a = side1;
        b = side2;
        c = side3;
    }

    double getPerimeter() {
        return a + b + c;
    }

    double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); 
    }

    public static void main(String[] args) {
        Triangle t = new Triangle(3, 4, 5);
        System.out.println("Perimeter: " + t.getPerimeter());
        System.out.println("Area: " + t.getArea());
    }
}
