package com.en.jewelleryassistantbot.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class JewelleryBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // Здесь перенеси логику из WriteReadBot для обработки сообщений
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            // Обработка сообщений и команд
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("Вы написали: " + messageText);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return System.getenv("BOT_NAME"); // Укажи имя своего бота
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN"); // Укажи токен своего бота
    }
}
