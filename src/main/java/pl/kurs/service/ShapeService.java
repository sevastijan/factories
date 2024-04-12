package pl.kurs.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.models.IShape;
import pl.kurs.util.ObjectMapperHolder;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ShapeService {
    public ShapeService() {}

    public IShape getShapeWithLargestArea(List<IShape> shapes) {
        return shapes.stream()
                .max(Comparator.comparingDouble(IShape::getShapeArea))
                .orElse(null);
    }
    public IShape getShapeWithLargestPerimeter(List<IShape> shapes, Class<?> shapeType) {
        return shapes.stream()
                .filter(shapeType::isInstance)
                .max(Comparator.comparingDouble(IShape::getShapePerimeter))
                .orElse(null);
    }
    public void exportShapesToJson(List<IShape> shapes, String filePath) throws IOException {
        ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getObjectMapper();
        objectMapper.writeValue(new File(filePath), shapes);
    }
    public List<IShape> importShapesFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getObjectMapper();

        List<IShape> shapes = objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });

        return shapes;
    };
}
