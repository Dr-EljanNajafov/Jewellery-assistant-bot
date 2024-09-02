package com.en.jewelleryassistantbot.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Item")
public class Product {

    @Id
    String id;            // Уникальный идентификатор товара
    String name;          // Название товара
    String category;      // Категория товара
    double price;         // Цена товара
    String description;   // Описание товара
    String imageUrl;      // Ссылка на изображение товара

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Сравнение с самим собой
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Разные классы
        }
        Product product = (Product) obj;
        return Objects.equals(id, product.id); // Сравнение по уникальному идентификатору
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Генерация хэш-кода на основе уникального идентификатора
    }
}
