public class SquareInheritance extends RectangleInheritance {
    public SquareInheritance() {
        super();
    }

    public SquareInheritance(double side) {
        super(side, side);
    }

    public void printSquare() {
        System.out.println("Square is a rectangle");
    }
}
