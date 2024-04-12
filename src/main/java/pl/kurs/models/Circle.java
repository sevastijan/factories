package pl.kurs.models;

public class Circle implements IShape {
    private double radius;

    private Circle(double r) {
        this.radius = r;
    }

    public static Circle create(double r) {
        return new Circle(r);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getShapeArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getShapePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
