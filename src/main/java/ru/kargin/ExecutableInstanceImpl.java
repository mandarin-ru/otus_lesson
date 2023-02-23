package ru.kargin;

import java.util.function.Function;

public class ExecutableInstanceImpl implements ExecutableInstance {
    private Function<Object[], Object> function;
    private Object[] params;

    public ExecutableInstanceImpl(Function<Object[], Object> function, Object[] params) {
        this.function = function;
        this.params = params;
    }

    public Object execute() {
        return function.apply(params);
    }
}
