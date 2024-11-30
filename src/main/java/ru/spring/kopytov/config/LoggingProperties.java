package ru.spring.kopytov.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.logging.Level;

@ConfigurationProperties(prefix = "log")
public class LoggingProperties {
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
