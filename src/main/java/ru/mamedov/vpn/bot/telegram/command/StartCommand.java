package ru.mamedov.vpn.bot.telegram.command;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import ru.mamedov.vpn.bot.telegram.BotCommand;
import ru.mamedov.vpn.bot.telegram.service.MessageService;

@Component
@RequiredArgsConstructor
public class StartCommand implements BotCommand {

    private final MessageService messageService;

    @Override
    public String getCommand() {
        return "/start";
    }

    @SneakyThrows
    @Override
    public void execute(final String chatId, final String messageText, final TelegramLongPollingBot bot) {
        messageService.sendMessage(chatId, "Привет! Добро пожаловать в VPN Bot!", bot);
    }
}
