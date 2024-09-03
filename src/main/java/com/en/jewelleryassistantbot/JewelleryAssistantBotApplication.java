package com.en.jewelleryassistantbot;

import com.en.jewelleryassistantbot.telegram.JewelleryBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class JewelleryAssistantBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(JewelleryAssistantBotApplication.class, args);

		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(new JewelleryBot());
		} catch (
				TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
