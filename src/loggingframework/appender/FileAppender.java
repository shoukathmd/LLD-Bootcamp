package loggingframework.appender;

import loggingframework.LogMessage;
import loggingframework.formatter.LogFormatter;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{

    private final LogFormatter formatter;
    private FileWriter fileWriter;

    public FileAppender(String filepath, LogFormatter formatter) {
        this.formatter = formatter;

        try {
            this.fileWriter = new FileWriter(filepath, true);
        } catch (IOException e) {
            System.out.println("Failed to create writer for file logs, exception: " + e.getMessage());
        }

    }

    @Override
    public void append(LogMessage logMessage) {
        try {
            fileWriter.write(formatter.format(logMessage) + "/n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }
    }
}
