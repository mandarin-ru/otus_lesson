package ru.kargin;

import org.junit.Test;

import static org.junit.Assert.*;

public class BurnFuelCommandTest {

    @Test
    public void burnFuel() {
        Spaceship spaceship = new Spaceship();
        FuelBurnable fuelBurn = new FuelBurnable();
        fuelBurn.setFuelLevel(2);
        fuelBurn.setFuelVelocity(1);

        BurnFuelCommand burnFuel = new BurnFuelCommand(fuelBurn);
        burnFuel.execute();
        assertEquals(1, fuelBurn.getFuelLevel());
    }
}