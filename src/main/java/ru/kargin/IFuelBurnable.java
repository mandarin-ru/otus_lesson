package ru.kargin;

import ru.kargin.exceptions.CommandException;

public interface IFuelBurnable {
    void setFuelLevel(int fuelLevel);
    int getFuelLevel();
    int getFuelVelocity();
}
