package pl.kurs.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import pl.kurs.models.IShape;
import pl.kurs.serializers.ShapeDeserializer;
import pl.kurs.serializers.ShapeSerializer;

import java.util.List;

public enum ObjectMapperHolder {
    INSTANCE;

    private final ObjectMapper objectMapper;

    ObjectMapperHolder() {
        this.objectMapper = create();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    private static ObjectMapper create() {
        ObjectMapper mapper = new ObjectMapper();

        ShapeSerializer shapeSerializer = new ShapeSerializer(IShape.class);
        SimpleModule shapeSerializerModule = new SimpleModule("shape serializer");
        shapeSerializerModule.addSerializer(IShape.class, shapeSerializer);

        ShapeDeserializer shapeDeserializer = new ShapeDeserializer(IShape.class);
        SimpleModule shapeDeserializerModule = new SimpleModule("shape deserializer");
        shapeDeserializerModule.addDeserializer(List.class, shapeDeserializer);

        mapper.registerModules(shapeSerializerModule, shapeDeserializerModule);

        return mapper;
    }
}
