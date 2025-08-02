package loggingframework;

import loggingframework.appender.ConsoleAppender;
import loggingframework.appender.LogAppender;
import loggingframework.formatter.SimpleFormatter;

import java.util.ArrayList;
import java.util.List;

public class LogManager {

    private static volatile Logger logger;

    public LogManager(Logger logger) {
        this.logger = logger;
    }

    public static Logger getLogger() {
        if(logger == null) {
            synchronized (LogManager.class) {
                if(logger == null) {
                    logger = new LoggerBuilder()
                            .setLevel(LogLevel.INFO)
                            .addAppender(new ConsoleAppender(new SimpleFormatter()))
                            .build();
                }
            }
        }
        return logger;
    }

    public static class LoggerBuilder {
        private LogLevel level = LogLevel.INFO;
        private final List<LogAppender> appenders = new ArrayList<>();

        public LoggerBuilder setLevel(LogLevel level) {
            this.level = level;
            return  this;
        }

        public LoggerBuilder addAppender(LogAppender appender) {
            this.appenders.add(appender);
            return  this;
        }

        public Logger build() {
            return new Logger(level, appenders);
        }
    }
}
