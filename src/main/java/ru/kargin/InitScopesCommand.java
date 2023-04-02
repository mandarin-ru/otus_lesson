package ru.kargin;

import ru.kargin.exceptions.CommandException;

public class InitScopesCommand implements ICommands {
    @Override
    public void execute() throws CommandException {
        /*if(ScopeBaseDependencyStrategy.Root!= null)
        {
            return;
        }
        Func<String, Object[], Object> str = ScopeBaseDependencyStrategy.Resolve;

        IoC.Resolve<ICommand>("IoC.SetupStrategy", str).Execute();

        var dependencies = new ConcurrentDictionary<String, Func<Object[], Object>>();

        var scope = new Scope(
                dependencies,
                null
        );

        dependencies.TryAdd("Scopes.Storage", args =>
                {
        return new ConcurrentDictionary<String, Func<Object[], Object>>();
			});

        dependencies.TryAdd("Scopes.New", (args) =>
                {
        return new Scope(IoC.Resolve<IDictionary<String,
                Func<Object[], Object>>>("Scopes.Storage"),
                (Scope)args[0]);
			});

        dependencies.TryAdd("Scopes.Current", args =>
                {
                        var scope = ScopeBaseDependencyStrategy.CurrentScope.Value;
        if (scope != null)
        {
            return scope;
        }
        else
        {
            return ScopeBaseDependencyStrategy.DefaultScope;
        }
			});

        dependencies.TryAdd("Scopes.Current.Set", args =>
                {
        return new SetCurrentScopeCommand((Scope)args[0]);
			});

        dependencies.TryAdd("IoC.Register", args =>
                {
        return new IoCRegisterCommand((String)args[0], (Func<Object[], Object>)args[1]);
			});

        ScopeBaseDependencyStrategy.Root = scope;

        new SetCurrentScopeCommand(scope).Execute();
    }*/
    }
}
