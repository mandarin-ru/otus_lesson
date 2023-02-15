package ru.kargin;

import org.junit.Test;
import ru.kargin.exceptions.CommandException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MacroCommandTest {

    @Test
    public void macroCommand() throws CommandException {

        Spaceship spaceship = new Spaceship();
        List<ICommands> commands = new ArrayList<>();

        FuelBurnable fuelBurn = new FuelBurnable();
        fuelBurn.setFuelLevel(5);
        fuelBurn.setFuelVelocity(1);
        commands.add(new CheckFuelCommand(fuelBurn));

        MoveCommand moveCommand = new MoveCommand();
        moveCommand.setPosition(12, 5);
        moveCommand.setVelocity(-7, 3);
        commands.add(moveCommand);

        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurn);
        commands.add(burnFuelCommand);

        MacroCommand macroCommand = new MacroCommand(commands);
        macroCommand.execute();
        assertEquals(4, fuelBurn.getFuelLevel());
        assertArrayEquals(new int[]{5, 8}, moveCommand.getPosition());

    }

    @Test(expected = CommandException.class)
    public void macroCommandException() throws CommandException {

        List<ICommands> commands = new ArrayList<>();

        FuelBurnable fuelBurn = new FuelBurnable();
        fuelBurn.setFuelLevel(5);
        fuelBurn.setFuelVelocity(10);
        commands.add(new CheckFuelCommand(fuelBurn));

        MoveCommand moveCommand = new MoveCommand();
        moveCommand.setPosition(12, 5);
        moveCommand.setVelocity(-7, 3);
        commands.add(moveCommand);

        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurn);
        commands.add(burnFuelCommand);

        MacroCommand macroCommand = new MacroCommand(commands);
        macroCommand.execute();
        assertEquals(4, fuelBurn.getFuelLevel());
        assertArrayEquals(new int[]{5, 8}, moveCommand.getPosition());
    }
}