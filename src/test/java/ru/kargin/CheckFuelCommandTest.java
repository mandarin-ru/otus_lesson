package ru.kargin;

import org.junit.Test;
import ru.kargin.exceptions.CommandException;

import static org.junit.Assert.*;

public class CheckFuelCommandTest {
    @Test
    public void checkFuel() throws CommandException {
        Spaceship spaceship = new Spaceship();
        FuelBurnable fuelBurn = new FuelBurnable();
        fuelBurn.setFuelLevel(2);
        fuelBurn.setFuelVelocity(1);
        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(fuelBurn);
        checkFuelCommand.execute();
    }
}