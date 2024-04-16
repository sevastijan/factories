package pl.kurs.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import pl.kurs.factories.ShapeFactory;
import pl.kurs.models.*;
import pl.kurs.services.IShapeService;
import pl.kurs.services.ShapeService;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        ShapeFactory shapeFactory = ShapeFactory.getInstance();
        IShapeService shapeService = new ShapeService();
//        Square sq = new Square(10);
//        Square sq1 = shapeFactory.createSquare(10);
//        Square sq2 = shapeFactory.createSquare(10);
//
//        System.out.println("sq1 = " + sq1);
//        System.out.println("sq2 = " + sq2);
//        System.out.println(sq1 == sq2);

        List<IShape> shapes = List.of(
                shapeFactory.createSquare(10),
                shapeFactory.createCircle(2),
                shapeFactory.createRectangle(10, 650)
        );

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
