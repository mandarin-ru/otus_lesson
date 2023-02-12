package ru.kargin;

import ru.kargin.exceptions.CommandException;

public interface ICommands {
    void execute() throws CommandException;
}
