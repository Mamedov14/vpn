package ru.mamedov.vpn.bot.telegram.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import ru.mamedov.vpn.bot.telegram.BotCommand;
import ru.mamedov.vpn.bot.telegram.service.MessageService;

@Component
@RequiredArgsConstructor
public class UnknownCommand implements BotCommand {

    private final MessageService messageService;

    @Override
    public String getCommand() {
        return "";
    }

    @Override
    public void execute(final String chatId, final String messageText, final TelegramLongPollingBot bot) {
        messageService.sendMessage(chatId, "Извините, я не понимаю эту команду. Попробуйте /help", bot);
    }
}
