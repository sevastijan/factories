package pl.kurs.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

@JsonTypeName("square")
public class Square implements IShape {
    @JsonProperty("width")
    private double width;

    private Square(double a) {
        this.width = a;
    }

    @JsonCreator
    public static Square create(@JsonProperty("width") double a) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}
