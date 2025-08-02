package loggingframework;

import loggingframework.appender.LogAppender;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Logger {
    private LogLevel minLevel;
    private final List<LogAppender> appenmders;
    private final ExecutorService executor;

    public Logger(LogLevel minLevel, List<LogAppender> appenmders) {
        this.appenmders = appenmders;
        this.minLevel = minLevel;
        this.executor = Executors.newSingleThreadExecutor();
    }

    public void log(LogLevel level, String msg) {
        if(!level.isAsSevereAs(minLevel)) return;
        LogMessage logMessage = new LogMessage(level, msg);
        executor.submit(() -> appenmders.forEach(a -> a.append(logMessage)));
    }

    public void setMinLevel(LogLevel minLevel) {
        this.minLevel = minLevel;
    }

    public void shutDown() {
        executor.shutdown();
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }


}
