package ru.kargin;

import ru.kargin.exceptions.CommandException;

public class MacroCommand implements ICommands {

    private final CheckFuelCommand checkFuelCommand;
    private final MoveCommand moveCommand;
    private final BurnFuelCommand burnFuelCommand;

    public MacroCommand(CheckFuelCommand checkFuelCommand, MoveCommand moveCommand, BurnFuelCommand burnFuelCommand){
        this.checkFuelCommand = checkFuelCommand;
        this.moveCommand = moveCommand;
        this.burnFuelCommand = burnFuelCommand;
    }

    @Override
    public void execute() throws CommandException {
        try {
            checkFuelCommand.execute();
            moveCommand.execute();
            burnFuelCommand.execute();
        }catch (CommandException e){
            throw new CommandException("Невозможно выполнить команду");
        }
    }
}
