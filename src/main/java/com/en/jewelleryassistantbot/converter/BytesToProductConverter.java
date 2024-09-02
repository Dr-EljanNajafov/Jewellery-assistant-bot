package com.en.jewelleryassistantbot.converter;

import com.en.jewelleryassistantbot.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

public class BytesToProductConverter implements Converter<byte[], Product> {

    private final Jackson2JsonRedisSerializer<Product> serializer;

    public BytesToProductConverter() {
        // Инициализируем сериализатор для преобразования массива байт в объект Product
        serializer = new Jackson2JsonRedisSerializer<>(Product.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public Product convert(byte[] source) {
        // Проверяем, что массив байт не равен null перед десериализацией
        return source != null ? serializer.deserialize(source) : null;
    }
}
