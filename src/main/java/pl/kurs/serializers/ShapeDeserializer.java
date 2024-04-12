package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.factory.ShapeFactory;
import pl.kurs.models.IShape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShapeDeserializer extends StdDeserializer<List<IShape>> {
    public ShapeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<IShape> deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        List<IShape> shapes = new ArrayList<>();
        ShapeFactory shapeFactory = ShapeFactory.getInstance();

        for (JsonNode shapeNode : jsonNode) {
            String type = shapeNode.get("type").asText();
            switch (type) {
                case "circle":
                    shapes.add(shapeFactory.createCircle(shapeNode.get("radius").asDouble()));
                    break;
                case "square":
                    shapes.add(shapeFactory.createSquare(shapeNode.get("width").asDouble()));
                    break;
                case "rectangle":
                    shapes.add(shapeFactory.createRectangle(shapeNode.get("width").asDouble(), shapeNode.get("height").asDouble()));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported shape: " + type);
            }
        }

        return shapes;
     };
}
