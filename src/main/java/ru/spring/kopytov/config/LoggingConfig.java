package ru.spring.kopytov.config;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingConfig {
    private final Logger logger;

    public LoggingConfig(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return logger;
    }
}
