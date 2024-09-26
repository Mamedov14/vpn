package ru.mamedov.vpn.bot.telegram.command;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import ru.mamedov.vpn.bot.telegram.BotCommand;
import ru.mamedov.vpn.bot.telegram.service.MessageService;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HelpCommand implements BotCommand {

    private final MessageService messageService;
    private final List<BotCommand> commands;

    @Override
    public String getCommand() {
        return "/help";
    }

    @SneakyThrows
    @Override
    public void execute(final String chatId, final String messageText, final TelegramLongPollingBot bot) {
        final var availableCommands = commands.stream()
                .map(BotCommand::getCommand)
                .collect(Collectors.joining("\n"));
        final var helpMessage = "Это список доступных команд:\n" + availableCommands;
        messageService.sendMessage(chatId, helpMessage, bot);
    }
}
