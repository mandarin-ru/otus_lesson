package ru.kargin;

import ru.kargin.exceptions.CommandException;

public class SetupStrategyCommand implements ICommands{

    @Override
    public void execute() throws CommandException {
        //final Func<String, Object[], Object> newStrategy;
/*
		public SetupStrategyCommand(Func<string, object[], object> newStrategy) => this.newStrategy = newStrategy;
        public void Execute()
        {
            IoC.Strategy = this.newStrategy;
        }*/
    }
}
