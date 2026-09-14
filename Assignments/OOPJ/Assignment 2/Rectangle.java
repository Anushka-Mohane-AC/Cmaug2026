class Rectangle {
    double length;
    double breadth;

    // Constructor taking length and breadth
    Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }

    // Method returning the area
    double area() {
        return length * breadth;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(5, 8);

        System.out.println("Area of Rectangle 1 (4, 5): " + r1.area());
        System.out.println("Area of Rectangle 2 (5, 8): " + r2.area());
    }
}