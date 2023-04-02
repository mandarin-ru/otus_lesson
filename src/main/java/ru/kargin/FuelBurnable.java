package ru.kargin;

import ru.kargin.exceptions.CommandException;

public class FuelBurnable implements IFuelBurnable {

    private int fuelLevel;
    private int fuelVelocity;

    @Override
    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @Override
    public int getFuelLevel() {
        return this.fuelLevel;
    }

    @Override
    public int getFuelVelocity() {
        return this.fuelVelocity;
    }

    public void setFuelVelocity(int fuelVelocity) {
        this.fuelVelocity = fuelVelocity;
    }
}
