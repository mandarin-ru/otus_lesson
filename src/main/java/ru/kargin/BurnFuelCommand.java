package ru.kargin;

public class BurnFuelCommand implements ICommands {

    IFuelBurnable fuelBurnable;

    public BurnFuelCommand(IFuelBurnable fuelBurnable) {
        this.fuelBurnable = fuelBurnable;
    }

    public void execute() {
        fuelBurnable.setFuelLevel(
                fuelBurnable.getFuelLevel() -
                        fuelBurnable.getFuelVelocity()
        );
    }
}
