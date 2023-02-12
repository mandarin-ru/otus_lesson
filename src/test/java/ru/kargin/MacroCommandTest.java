package ru.kargin;

import org.junit.Test;
import ru.kargin.exceptions.CommandException;

import static org.junit.Assert.*;

public class MacroCommandTest {

    @Test
    public void macroCommand() throws CommandException {

        Spaceship spaceship = new Spaceship();
        FuelBurnable fuelBurn = new FuelBurnable();
        fuelBurn.setFuelLevel(5);
        fuelBurn.setFuelVelocity(1);

        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(fuelBurn);

        MoveCommand moveCommand = new MoveCommand();
        moveCommand.setPosition(12, 5);
        moveCommand.setVelocity(-7, 3);

        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurn);

        MacroCommand macroCommand = new MacroCommand(checkFuelCommand, moveCommand, burnFuelCommand);
        macroCommand.execute();
        assertEquals(4, fuelBurn.getFuelLevel());
        assertArrayEquals(new int[]{5, 8}, moveCommand.getPosition());

    }

    @Test(expected = CommandException.class)
    public void macroCommandException() throws CommandException {

        Spaceship spaceship = new Spaceship();
        FuelBurnable fuelBurn = new FuelBurnable();
        fuelBurn.setFuelLevel(5);
        fuelBurn.setFuelVelocity(10);

        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(fuelBurn);

        MoveCommand moveCommand = new MoveCommand();
        moveCommand.setPosition(12, 5);
        moveCommand.setVelocity(-7, 3);

        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurn);

        MacroCommand macroCommand = new MacroCommand(checkFuelCommand, moveCommand, burnFuelCommand);
        macroCommand.execute();
    }
}