package ru.kargin;

import ru.kargin.exceptions.SpaceshipParamException;

public class RetryCommand implements ICommands {

    private final ICommands command;
    static int i = 0;

    public RetryCommand(ICommands command) {
        this.command = command;
    }

    public void execute() throws SpaceshipParamException {
        this.i++;
        command.execute();

    }

}
