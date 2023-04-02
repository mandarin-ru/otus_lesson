package ru.kargin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionLogCommand implements ICommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionLogCommand.class);
    static int i = 0;
    private Exception exception;

    public ExceptionLogCommand(Exception exception) {
        this.exception = exception;
    }

    public void execute(){
        LOGGER.error("some message", exception);
        this.i++;
    }
}
