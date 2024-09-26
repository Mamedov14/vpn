package ru.mamedov.vpn.bot.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "telegram.bot.vpn")
public class BotProperties {
    private String name;
    private String token;
}