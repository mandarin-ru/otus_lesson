package ru.kargin;

import ru.kargin.exceptions.SpaceshipParamException;

public class RetryCommand implements ICommands {

    private final ICommands command;

    public RetryCommand(ICommands command) {
        this.command = command;
    }

    public void execute() throws SpaceshipParamException {
        command.execute();
    }
    public void exception(){

    }
}
