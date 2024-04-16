package pl.kurs.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.models.IShape;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ShapeService implements IShapeService {
    public ShapeService() {}

    @Override
    public IShape getShapeWithLargestArea(List<IShape> shapes) {
        return shapes.stream()
                .max(Comparator.comparingDouble(IShape::getShapeArea))
                .orElse(null);
    }

    @Override
    public IShape getShapeWithLargestPerimeter(List<IShape> shapes, Class<?> shapeType) {
        return shapes.stream()
                .filter(shapeType::isInstance)
                .max(Comparator.comparingDouble(IShape::getShapePerimeter))
                .orElse(null);
    }

    @Override
    public void exportShapesToJson(List<IShape> shapes, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        IShape[] shapesToJson = shapes.toArray(IShape[]::new);

        objectMapper.writeValue(new File(filePath), shapesToJson);
    }

    @Override
    public List<IShape> importShapesFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

}
