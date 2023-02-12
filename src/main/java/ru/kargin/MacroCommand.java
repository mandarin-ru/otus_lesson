package ru.kargin;

import ru.kargin.exceptions.CommandException;

public class MacroCommand implements ICommands {

    private  CheckFuelCommand checkFuelCommand;
    private  MoveCommand moveCommand;
    private  BurnFuelCommand burnFuelCommand;

    public MacroCommand(CheckFuelCommand checkFuelCommand, MoveCommand moveCommand, BurnFuelCommand burnFuelCommand){
        this.checkFuelCommand = checkFuelCommand;
        this.moveCommand = moveCommand;
        this.burnFuelCommand = burnFuelCommand;
    }

    @Override
    public void execute() throws CommandException {
        checkFuelCommand.execute();
        moveCommand.execute();
        burnFuelCommand.execute();
    }
}
