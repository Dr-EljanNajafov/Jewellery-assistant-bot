package com.en.jewelleryassistantbot.telegram.keyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Основная клавиатура, расположенная под строкой ввода текста в Telegram
 */
@Component
public class ReplyKeyboardMaker {

    public ReplyKeyboardMarkup getMainMenuKeyboard() {
        // Создаем строки для клавиатуры
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Информация о магазинах"));
        row1.add(new KeyboardButton("Контактные данные"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Наши ювелирные изделия"));
        row2.add(new KeyboardButton("Помощь"));

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);

        // Создаем и настраиваем клавиатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true); // Показывать клавиатуру только для данного пользователя
        replyKeyboardMarkup.setResizeKeyboard(true); // Автоматически изменять размер клавиатуры под экран
        replyKeyboardMarkup.setOneTimeKeyboard(false); // Клавиатура не исчезает после первого использования

        return replyKeyboardMarkup;
    }
}

