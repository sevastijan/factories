package pl.kurs.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

@JsonTypeName("rectangle")
public class Rectangle implements IShape {
    @JsonProperty("width")
    private double width;

    @JsonProperty("height")
    private double height;

    private Rectangle(double a, double b) {
        this.width = a;
        this.height = b;
    }

    @JsonCreator
    public static Rectangle create(@JsonProperty("width") double a, @JsonProperty("height") double b) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
