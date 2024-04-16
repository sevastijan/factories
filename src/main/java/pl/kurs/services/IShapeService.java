package pl.kurs.services;

import pl.kurs.models.IShape;

import java.io.IOException;
import java.util.List;

public interface IShapeService {
    IShape getShapeWithLargestArea(List<IShape> shapes);
    IShape getShapeWithLargestPerimeter(List<IShape> shapes, Class<?> shapeType);
    void exportShapesToJson(List<IShape> shapes, String filePath) throws IOException;
    List<IShape> importShapesFromJson(String filePath) throws IOException;

}
