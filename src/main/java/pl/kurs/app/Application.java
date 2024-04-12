package pl.kurs.app;

import pl.kurs.factory.ShapeFactory;
import pl.kurs.models.Circle;
import pl.kurs.models.IShape;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Square;
import pl.kurs.service.ShapeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        ShapeFactory shapeFactory = ShapeFactory.getInstance();
        ShapeService shapeService = new ShapeService();
//        Square sq = new Square(10);
//        Square sq1 = shapeFactory.createSquare(10);
//        Square sq2 = shapeFactory.createSquare(10);
//
//        System.out.println("sq1 = " + sq1);
//        System.out.println("sq2 = " + sq2);
//        System.out.println(sq1 == sq2);

        List<IShape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.createSquare(10));
        shapes.add(shapeFactory.createCircle(2));
        shapes.add(shapeFactory.createRectangle(10, 650));

        shapeService.exportShapesToJson(shapes, "src/main/resources/shapes.json");

        List<IShape> shapesFromJson = shapeService.importShapesFromJson("src/main/resources/shape2.json");
        System.out.println("shapesFromJson = " + shapesFromJson);

        IShape shapeWithLargestArea = shapeService.getShapeWithLargestArea(shapesFromJson);

        System.out.println("shapeWithLargestArea = " + shapeWithLargestArea);

        IShape circleWithLargestPerimeter = shapeService.getShapeWithLargestPerimeter(shapesFromJson, Circle.class);
        IShape squareWithLargestPerimeter = shapeService.getShapeWithLargestPerimeter(shapesFromJson, Square.class);
        IShape rectangleWithLargestPerimeter = shapeService.getShapeWithLargestPerimeter(shapesFromJson, Rectangle.class);

        System.out.println("circleWithLargestPerimeter = " + circleWithLargestPerimeter);
        System.out.println("squareWithLargestPerimeter = " + squareWithLargestPerimeter);
        System.out.println("rectangleWithLargestPerimeter = " + rectangleWithLargestPerimeter);
    }
}
