package ru.kargin;

import ru.kargin.exceptions.SpaceshipParamException;

public interface ICommands {
    void execute() throws Exception;
    void exception();
}
