package ru.kargin;

import ru.kargin.exceptions.CommandException;

public class CheckFuelCommand implements ICommands {

    IFuelBurnable fuelBurnable;

    public CheckFuelCommand(IFuelBurnable fuelBurnable) {
        this.fuelBurnable = fuelBurnable;
    }

    public void execute() throws CommandException {
        if (fuelBurnable.getFuelLevel() - fuelBurnable.getFuelVelocity() < 0) {
            throw new CommandException("Невозможно прочитать координаты");
        }
    }
}
