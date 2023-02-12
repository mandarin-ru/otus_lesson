package ru.kargin;

import org.junit.Test;
import ru.kargin.exceptions.CommandException;

import static org.junit.Assert.*;

public class MacroCommandTest {

    @Test
    public void macroCommand() throws CommandException {

        Spaceship spaceship = new Spaceship();
        MacroCommand moveCommand = new MacroCommand();

        spaceship.getCommands().add(moveCommand);
        spaceship.move();

    }
}