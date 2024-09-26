package ru.mamedov.vpn.bot.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public interface BotCommand {
    String getCommand();

    void execute(final String chatId, final String messageText, final TelegramLongPollingBot bot);
}
