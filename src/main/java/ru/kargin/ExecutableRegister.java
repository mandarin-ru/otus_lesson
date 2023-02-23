package ru.kargin;

import java.util.function.Function;

public class ExecutableRegister implements ExecutableInstance {

    private Function<Object[], Object> function;

    public ExecutableRegister(Function<Object[], Object> function) {
        this.function = function;
    }

    @Override
    public Object execute() {
        return function;
    }
}
