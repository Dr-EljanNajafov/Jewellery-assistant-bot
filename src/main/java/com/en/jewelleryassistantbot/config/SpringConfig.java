package com.en.jewelleryassistantbot.config;

import com.en.jewelleryassistantbot.telegram.handler.CallbackQueryHandler;
import com.en.jewelleryassistantbot.telegram.handler.MessageHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import com.en.jewelleryassistantbot.telegram.WriteReadBot;

@Configuration
@AllArgsConstructor
public class SpringConfig {
    private final TelegramConfiguration telegramConfig;

//    @Bean
//    public SetWebhook setWebhookInstance() {
//        return SetWebhook.builder().url(telegramConfig.getWebhookPath()).build();
//    }

    @Bean
    public WriteReadBot springWebhookBot(/**SetWebhook setWebhook,*/
                                         MessageHandler messageHandler,
                                         CallbackQueryHandler callbackQueryHandler) {
        WriteReadBot bot = new WriteReadBot(/**setWebhook,*/ messageHandler, callbackQueryHandler);

//        bot.setBotPath(telegramConfig.getWebhookPath());
        bot.setBotUsername(telegramConfig.getBotName());
        bot.setBotToken(telegramConfig.getBotToken());

        return bot;
    }
}
