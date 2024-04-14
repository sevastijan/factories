package pl.kurs.factories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.kurs.models.Circle;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Square;

import static org.junit.Assert.*;

public class ShapeFactoryTest {

    private ShapeFactory shapeFactory;

    @Before
    public void init() {
        shapeFactory = ShapeFactory.getInstance();
    }

    @Test
    public void whenGetInstanceOfShapeFactoryMakeSureThisIsSingleton() {
        ShapeFactory instance1 = ShapeFactory.getInstance();
        ShapeFactory instance2 = ShapeFactory.getInstance();

        Assert.assertSame(instance1, instance2);
    }

    @Test
    public void whenCreateSquareWithSameSizesShouldGetSquareFromCache() {
        Square square1 = shapeFactory.createSquare(5);
        Square square2 = shapeFactory.createSquare(5);

        Assert.assertSame(square1, square2);
    }

    @Test
    public void whenCreateCircleWithSameRadiusShouldGetSquareFromCache() {
        Circle circle1 = shapeFactory.createCircle(5);
        Circle circle2 = shapeFactory.createCircle(5);

        Assert.assertSame(circle1, circle2);
    }

    @Test
    public void whenCreateRectangleWithSameWidthAndHeightShouldGetSquareFromCache() {
        Rectangle rectangle1 = shapeFactory.createRectangle(1, 1);
        Rectangle rectangle2 = shapeFactory.createRectangle(1, 1);

        Assert.assertSame(rectangle1, rectangle2);
    }
}