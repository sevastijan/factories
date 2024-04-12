package pl.kurs.factory;

import pl.kurs.models.Circle;
import pl.kurs.models.IShape;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Square;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static ShapeFactory instance;
    private Map<String, IShape> shapeCache;

    private ShapeFactory() {
        shapeCache = new HashMap<>();
    }

    public static ShapeFactory getInstance() {
        if (instance == null)
            instance = new ShapeFactory();

        return instance;
    }
 
    public Square createSquare(double a) {
        String key = "SQUARE_" + a;
        if(!shapeCache.containsKey(key)) {
            shapeCache.put(key, Square.create(a));
        }
        return (Square) shapeCache.get(key);
    }

    public Rectangle createRectangle(double a, double b) {
        String key = "RECTANGLE_" + a + "x" + b;
        if(!shapeCache.containsKey(key)) {
            shapeCache.put(key, Rectangle.create(a, b));
        }
        return (Rectangle) shapeCache.get(key);
    }

    public Circle createCircle(double r) {
        String key = "CIRCLE_" + r;
        if(!shapeCache.containsKey(key)) {
            shapeCache.put(key, Circle.create(r));
        }
        return (Circle) shapeCache.get(key);
    }



}
