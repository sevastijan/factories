package pl.kurs.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

@JsonTypeName("circle")
public class Circle implements IShape {
    @JsonProperty("radius")
    private double radius;

    private Circle(double r) {
        this.radius = r;
    }

    @JsonCreator
    public static Circle create(@JsonProperty("radius") double r) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
