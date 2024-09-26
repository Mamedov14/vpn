package ru.mamedov.vpn.bot.telegram;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mamedov.vpn.bot.telegram.command.UnknownCommand;
import ru.mamedov.vpn.bot.telegram.service.MessageService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BotCommandFactory {

    private final List<BotCommand> commands;
    private final MessageService messageService;

    public BotCommand findCommand(final String commandText) {
        return commands.stream()
                .filter(cmd -> commandText.startsWith(cmd.getCommand()))
                .findFirst()
                .orElse(new UnknownCommand(messageService));
    }
}
