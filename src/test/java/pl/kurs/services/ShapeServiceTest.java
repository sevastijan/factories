package pl.kurs.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.kurs.factories.ShapeFactory;
import pl.kurs.models.Circle;
import pl.kurs.models.IShape;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Square;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ShapeServiceTest {
    private List<IShape> shapesList;
    private ShapeService shapeService;
    private ShapeFactory shapeFactory;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        shapeFactory = ShapeFactory.getInstance();

        shapeService = new ShapeService();

        shapesList = Arrays.asList(
                shapeFactory.createCircle(2),
                shapeFactory.createCircle(23),
                shapeFactory.createCircle(21),
                shapeFactory.createRectangle(23,5),
                shapeFactory.createRectangle(66, 30),
                shapeFactory.createRectangle(100, 100),
                shapeFactory.createSquare(7),
                shapeFactory.createSquare(199),
                shapeFactory.createSquare(250)
        );
    }

    @Test
    public void whenSquareHas250WidthReturnItAsLargestShape() {
        IShape expectedShape = shapeFactory.createSquare(250);
        IShape largestShape = shapeService.getShapeWithLargestArea(shapesList);

        Assert.assertEquals(expectedShape, largestShape);
    }

    @Test
    public void whenCircleHas23RadiusReturnIsAsCircleWithLargestPerimeter() {
        IShape expectedShape = shapeFactory.createCircle(23);
        IShape largestShape = shapeService.getShapeWithLargestPerimeter(shapesList, Circle.class);

        Assert.assertEquals(expectedShape, largestShape);
    }

    @Test
    public void whenSquareHas250WidthReturnIsAsSquareWithLargestPerimeter() {
        IShape expectedShape = shapeFactory.createSquare(250);
        IShape largestShape = shapeService.getShapeWithLargestPerimeter(shapesList, Square.class);

        Assert.assertEquals(expectedShape, largestShape);
    }

    @Test
    public void whenRectangleHas100WidthAnd100HeightReturnIsAsRectangleWithLargestPerimeter() {
        IShape expectedShape = shapeFactory.createRectangle(100,100);
        IShape largestShape = shapeService.getShapeWithLargestPerimeter(shapesList, Rectangle.class);

        Assert.assertEquals(expectedShape, largestShape);
    }

    @Test
    public void whenImportShapesFromJsonListShouldBeEqualAsExpected() throws IOException {
        List<IShape> importedShapes = shapeService.importShapesFromJson("src/main/resources/newShapes.json");

        Assert.assertEquals(importedShapes, shapesList);
    }

    @Test
    public void whenFileDoesNotExistThenThrow() throws IOException {
        Assert.assertThrows(IOException.class, () -> {
            shapeService.importShapesFromJson("src/main/resources/notFoundFile.json");
        });
    }

    @Test
    public void whenExportShapesToJsonWillBeImportItShouldContainSameShapes() throws IOException {
        String filePath = "src/main/resources/newShapes.json";
        shapeService.exportShapesToJson(shapesList, filePath);
        List<IShape> importedShapes = shapeService.importShapesFromJson(filePath);

        Assert.assertEquals(shapesList, importedShapes);
    }

}