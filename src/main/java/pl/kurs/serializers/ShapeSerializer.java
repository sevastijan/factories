package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.kurs.models.Circle;
import pl.kurs.models.IShape;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Square;

import java.io.IOException;

public class ShapeSerializer extends StdSerializer<IShape> {

    public ShapeSerializer(Class<IShape> t) {
        super(t);
    }

    @Override
    public void serialize(IShape shape, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("type", shape.getClass().getSimpleName().toLowerCase());

        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            jsonGenerator.writeNumberField("radius", circle.getRadius());
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            jsonGenerator.writeNumberField("width", rectangle.getWidth());
            jsonGenerator.writeNumberField("height", rectangle.getHeight());
        } else if (shape instanceof Square) {
            Square square = (Square) shape;
            jsonGenerator.writeNumberField("width", square.getWidth());
        }

        jsonGenerator.writeEndObject();
    }
}
