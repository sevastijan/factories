package pl.kurs.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.models.IShape;
import pl.kurs.util.ObjectMapperHolder;

import java.io.File;
import java.io.IOException;
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
        ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getObjectMapper();
        objectMapper.writeValue(new File(filePath), shapes);
    }

    @Override
    public List<IShape> importShapesFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getObjectMapper();

        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

}
