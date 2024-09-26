package ru.mamedov.vpn.bot.telegram.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class MessageService {

    @SneakyThrows
    public void sendMessage(final String chatId, final String text, final TelegramLongPollingBot bot) {
        final var message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        bot.execute(message);
    }
}
