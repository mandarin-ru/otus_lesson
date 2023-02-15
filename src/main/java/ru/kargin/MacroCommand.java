package ru.kargin;

import ru.kargin.exceptions.CommandException;

import java.util.List;
import java.util.Queue;

public class MacroCommand implements ICommands {

    private List<ICommands> commands;

    public MacroCommand(List<ICommands> commands){
        this.commands = commands;
    }

    @Override
    public void execute() throws CommandException {
        try {
            for(ICommands item : this.commands){
               item.execute();
            }
        }catch (CommandException e){
            throw new CommandException("Невозможно выполнить команду");
        }
    }
}
