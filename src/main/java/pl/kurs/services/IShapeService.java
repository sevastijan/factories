package pl.kurs.services;

import pl.kurs.models.IShape;

import java.io.IOException;
import java.util.List;

public interface IShapeService {
    public IShape getShapeWithLargestArea(List<IShape> shapes);
    public IShape getShapeWithLargestPerimeter(List<IShape> shapes, Class<?> shapeType);
    public void exportShapesToJson(List<IShape> shapes, String filePath) throws IOException;
    public List<IShape> importShapesFromJson(String filePath) throws IOException;

}
