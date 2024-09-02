package com.en.jewelleryassistantbot.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.ApiResponse;
import org.telegram.telegrambots.meta.api.objects.File;

@Service
public class TelegramApiClient {
    private final String URL;
    private final String botToken;
    private final RestTemplate restTemplate;

    public TelegramApiClient(@Value("${telegram.api-url}") String URL,
                             @Value("${telegram.bot-token}") String botToken) {
        this.URL = URL;
        this.botToken = botToken;
        this.restTemplate = new RestTemplate();
    }

    public void sendMessage(String chatId, String text) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestPayload = String.format("{\"chat_id\":\"%s\",\"text\":\"%s\"}", chatId, text);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestPayload, headers);

        try {
            restTemplate.exchange(
                    String.format("%sbot%s/sendMessage", URL, botToken),
                    HttpMethod.POST,
                    requestEntity,
                    String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send message", e);
        }
    }

    public void sendPhoto(String chatId, ByteArrayResource photo) {
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("photo", photo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

        try {
            restTemplate.exchange(
                    String.format("%sbot%s/sendPhoto?chat_id=%s", URL, botToken, chatId),
                    HttpMethod.POST,
                    requestEntity,
                    String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send photo", e);
        }
    }
}
