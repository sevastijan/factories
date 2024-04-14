package pl.kurs.models;


public class Square implements IShape{
    private double width;

    private Square(double a) {
        this.width = a;
    }

    public static Square create(double a) {
        return new Square(a);
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getShapeArea() {
        return width * width;
    }

    @Override
    public double getShapePerimeter() {
        return 4 * width;
    }


    @Override
    public String toString() {
        return "Square{" +
                "a=" + width +
                '}';
    }
}
