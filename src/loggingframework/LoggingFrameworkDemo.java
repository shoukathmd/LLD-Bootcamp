package loggingframework;

public class LoggingFrameworkDemo {

    public static void main(String[] args) {

        // DEBUG, INFO, WARN, ERROR, FATAL
        Logger logger = LogManager.getLogger();

        logger.log(LogLevel.WARN, "Warning message - 1");
        logger.log(LogLevel.DEBUG, "Debug message - 2");

        logger.setMinLevel(LogLevel.WARN);

        logger.log(LogLevel.WARN, "Warning message - 3");
        logger.log(LogLevel.DEBUG, "Debug message - 4");
        logger.shutDown();
    }
}
