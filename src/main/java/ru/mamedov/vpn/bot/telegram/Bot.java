package ru.mamedov.vpn.bot.telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.mamedov.vpn.bot.configuration.BotProperties;

@Component
public class Bot extends TelegramLongPollingBot {

    private final BotProperties botProperties;
    private final BotCommandFactory commandFactory;

    public Bot(final BotProperties botProperties, final BotCommandFactory commandFactory) {
        super(botProperties.getToken());
        this.botProperties = botProperties;
        this.commandFactory = commandFactory;
    }

    @Override
    public String getBotUsername() {
        return botProperties.getName();
    }

    @Override
    public void onUpdateReceived(final Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            final var chatId = update.getMessage().getChatId().toString();
            final var messageText = update.getMessage().getText();
            final var botCommand = commandFactory.findCommand(messageText);
            if (botCommand != null) {
                botCommand.execute(chatId, messageText, this);
            }
        }
    }
}
