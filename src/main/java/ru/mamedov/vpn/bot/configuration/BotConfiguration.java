package ru.mamedov.vpn.bot.configuration;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.mamedov.vpn.bot.telegram.Bot;

@Configuration
public class BotConfiguration {

    @SneakyThrows
    @Bean
    public TelegramBotsApi telegramBotsApi(final Bot bot) {
        final var botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(bot);
        return botsApi;
    }
}
