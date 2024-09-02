package com.en.jewelleryassistantbot.constant.bot;

/**
 * Названия кнопок основной клавиатуры
 */
public enum ButtonNameEnum {
    VIEW_PRODUCTS_BUTTON("Наши ювелирные изделия"),
    STORE_INFO_BUTTON("Информация о магазине"),
    CONTACT_INFO_BUTTON("Контактные данные"),
    HELP_BUTTON("Помощь");

    private final String buttonName;

    ButtonNameEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
