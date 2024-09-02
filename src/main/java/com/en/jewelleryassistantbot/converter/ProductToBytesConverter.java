package com.en.jewelleryassistantbot.converter;

import com.en.jewelleryassistantbot.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

public class ProductToBytesConverter implements Converter<Product, byte[]> {

    private final Jackson2JsonRedisSerializer<Product> serializer;

    public ProductToBytesConverter() {
        // Инициализируем сериализатор, который будет преобразовывать объект Product в JSON
        serializer = new Jackson2JsonRedisSerializer<>(Product.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public byte[] convert(Product product) {
        // Преобразуем объект Product в массив байт (JSON в байтовом формате)
        return serializer.serialize(product);
    }
}
