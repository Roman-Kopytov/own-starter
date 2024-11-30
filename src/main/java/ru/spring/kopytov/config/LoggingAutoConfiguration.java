package ru.spring.kopytov.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.spring.kopytov.service.MainAspect;

import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@EnableConfigurationProperties(LoggingProperties.class)
public class LoggingAutoConfiguration {

    private final LoggingProperties loggingProperties;

    public LoggingAutoConfiguration(LoggingProperties loggingProperties) {
        this.loggingProperties = loggingProperties;
    }

    @Bean
    public MainAspect mainAspect(Logger logger) {
        return new MainAspect(logger);
    }

    @Bean
    public Logger logger(LoggingConfig loggingConfig) {
        Logger logger = loggingConfig.getLogger();
        return logger;
    }

    @Bean
    public LoggingConfig loggingConfig() {
        Logger logger = Logger.getLogger(MainAspect.class.getName());

        if (loggingProperties.getLevel() == null || loggingProperties.getLevel().isEmpty()) {
            logger.setLevel(Level.INFO);
            return new LoggingConfig(logger);
        }
        Level level = Level.parse(loggingProperties.getLevel());
        logger.setLevel(level);
        return new LoggingConfig(logger);
    }
}
