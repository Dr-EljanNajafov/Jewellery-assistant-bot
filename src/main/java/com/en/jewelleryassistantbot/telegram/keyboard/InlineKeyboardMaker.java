package com.en.jewelleryassistantbot.telegram.keyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Клавиатуры, формируемые в ленте Telegram для базового взаимодействия
 */
@Component
public class InlineKeyboardMaker {

    public InlineKeyboardMarkup getMainMenuKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        // Добавляем кнопки для главного меню
        rowList.add(createButtonRow("Информация о магазинах", "info_stores"));
        rowList.add(createButtonRow("Наши ювелирные изделия", "view_jewels"));
        rowList.add(createButtonRow("Контактные данные", "contact_info"));

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup getAdditionalOptionsKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        // Добавляем дополнительные опции
        rowList.add(createButtonRow("Помощь", "help"));
        rowList.add(createButtonRow("Шаблон", "template"));

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private List<InlineKeyboardButton> createButtonRow(String buttonName, String buttonCallBackData) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(buttonName);
        button.setCallbackData(buttonCallBackData);

        List<InlineKeyboardButton> buttonRow = new ArrayList<>();
        buttonRow.add(button);
        return buttonRow;
    }
}
