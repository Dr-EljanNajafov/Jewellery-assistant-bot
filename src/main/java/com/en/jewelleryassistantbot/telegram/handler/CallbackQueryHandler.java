package com.en.jewelleryassistantbot.telegram.handler;

import com.en.jewelleryassistantbot.constant.bot.BotMessageEnum;
import com.en.jewelleryassistantbot.exception.ProductNotFoundException;
import com.en.jewelleryassistantbot.repository.ProductRepository;
import com.en.jewelleryassistantbot.telegram.TelegramApiClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import com.en.jewelleryassistantbot.constant.bot.CallbackDataPartsEnum;

import java.io.IOException;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CallbackQueryHandler {
    TelegramApiClient telegramApiClient;
    ProductRepository productRepository;  // Сервис для работы с продуктами

    public BotApiMethod<?> processCallbackQuery(CallbackQuery buttonQuery) throws IOException {
        final String chatId = buttonQuery.getMessage().getChatId().toString();
        String data = buttonQuery.getData();

        if (data.equals(CallbackDataPartsEnum.PRODUCT_DETAILS_.name())) {
            return getProductDetails(chatId, data);
        } else if (data.equals(CallbackDataPartsEnum.PRODUCT_LIST_.name())) {
            return getProductList(chatId);
        } else {
            return handleDefaultCallback(chatId, data);
        }
    }

    private SendMessage handleDefaultCallback(String chatId, String data) {
        return new SendMessage(chatId, BotMessageEnum.EXCEPTION_BAD_BUTTON_NAME_MESSAGE.getMessage());
    }

    private SendMessage getProductDetails(String chatId, String productId) {
        try {
            var product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
            // Формируем сообщение с деталями продукта
            String message = String.format("Product Name: %s\nPrice: %.2f\nDescription: %s",
                    product.getName(), product.getPrice(), product.getDescription());
            return new SendMessage(chatId, message);
        } catch (ProductNotFoundException e) {
            return new SendMessage(chatId, BotMessageEnum.EXCEPTION_PRODUCT_NOT_FOUND_MESSAGE.getMessage());
        } catch (Exception e) {
            return new SendMessage(chatId, BotMessageEnum.EXCEPTION_PRODUCT_WTF_MESSAGE.getMessage());
        }
    }

    private SendMessage getProductList(String chatId) {
        try {
            var products = productRepository.findAll();
            // Формируем сообщение с перечнем продуктов
            StringBuilder message = new StringBuilder("Available Products:\n");
            for (var product : products) {
                message.append(String.format("Name: %s - Price: %.2f\n", product.getName(), product.getPrice()));
            }
            return new SendMessage(chatId, message.toString());
        } catch (Exception e) {
            return new SendMessage(chatId, BotMessageEnum.EXCEPTION_PRODUCT_LIST_MESSAGE.getMessage());
        }
    }
}
