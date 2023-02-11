package ru.kargin;

import ru.kargin.exceptions.SpaceshipParamException;

public interface ICommands {
    void execute() throws SpaceshipParamException;
   /* void cmdLog(SpaceshipParamException e);
    void cmdRun(SpaceshipParamException e);*/
}
