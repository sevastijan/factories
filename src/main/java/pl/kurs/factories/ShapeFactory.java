package pl.kurs.factories;

import pl.kurs.models.Circle;
import pl.kurs.models.IShape;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Square;
import pl.kurs.services.IShapeService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShapeFactory {
    private static final ShapeFactory instance = new ShapeFactory();
    private Map<String, IShape> shapeCache;

    private ShapeFactory() {
        shapeCache = new HashMap<>();
    }

    public static ShapeFactory getInstance() {
        return instance;
    }

    private String getKey(String className, double... dimensions) {
        return className + "_" + Arrays.stream(dimensions)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("_"));
    }

    private <T extends IShape> T createShape(Class<T> type, double... size) {
        String key = getKey(type.getSimpleName(), size);

        shapeCache.computeIfAbsent(key, k -> createShapeInstance(type, size));

        return (T) shapeCache.get(key);
    }

    private <T extends IShape> IShape createShapeInstance(Class<T> type, double... size) {
        if(type.equals(Square.class)) {
            return Square.create(size[0]);
        } else if(type.equals(Rectangle.class)) {
            return Rectangle.create(size[0], size[1]);
        } else if(type.equals(Circle.class)) {
            return Circle.create(size[0]);
        } else {
            throw new IllegalArgumentException("Unsupported shape: " + type);
        }
    }
 
    public Square createSquare(double a) {
        return createShape(Square.class, a);
    }

    public Rectangle createRectangle(double a, double b) {
        return createShape(Rectangle.class, a, b);
    }

    public Circle createCircle(double r) {
        return createShape(Circle.class, r);
    }
}
