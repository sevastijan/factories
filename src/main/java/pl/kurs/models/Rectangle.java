package pl.kurs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rectangle implements IShape {
    private double width;
    private double height;

    private Rectangle(double a, double b) {
        this.width = a;
        this.height = b;
    }

    public static Rectangle create(double a, double b) {
        return new Rectangle(a, b);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getShapeArea() {
        return width * height;
    }

    @Override
    public double getShapePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + width +
                ", b=" + height +
                '}';
    }
}
