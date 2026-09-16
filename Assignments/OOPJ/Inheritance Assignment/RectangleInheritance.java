public class RectangleInheritance extends Shape {
    double length;
    double breadth;

    public RectangleInheritance() {
    }

    public RectangleInheritance(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void printRectangular() {
        System.out.println("This is rectangular shape");
    }

    public void printArea() {
        System.out.println("Area: " + (length * breadth));
    }

    public void printPerimeter() {
        System.out.println("Perimeter: " + (2 * (length + breadth)));
    }
}