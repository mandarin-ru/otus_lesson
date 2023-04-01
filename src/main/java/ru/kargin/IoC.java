package ru.kargin;

import javassist.tools.reflect.Reflection;
import org.reflections.Reflections;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class IoC<params> {

    Reflections scanner;

    private static final Map<String, Function<Object[], Object>> dependencies = new HashMap<>();
    private final ThreadLocal<Map<String, Object>> scopes = ThreadLocal.withInitial(HashMap::new);

    /*Class<?>[] mainClasses, String... args*/

    static <T> T  resolve1(String name/*, Object[] params*/) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Reflections scanner = new Reflections("ru.kargin");
        Set<Class<? extends MoveCommand>> a =  scanner.getSubTypesOf(MoveCommand.class);



        Constructor<?> constructor =  Class.forName("ru.kargin.MoveCommand").getConstructor();

        System.out.println(Arrays.toString(constructor.getParameterTypes()));

        Object myObj = constructor.newInstance();
        return (T) myObj;

    }


    private static Map<String, ExecutableInstance> map = new HashMap<>();


    static <T> T resolve(String name, Object[] params) {
        ExecutableInstance result;

        if (name.equalsIgnoreCase("IoC.Register")) {
            Function<Object[], Object> instanceInitializer = (Function<Object[], Object>) params[1];

            result = new ExecutableRegister(instanceInitializer);

            map.put(String.valueOf(params[0]), result);
            dependencies.put(String.valueOf(params[0]), instanceInitializer);
            return null;
        } else {
            Function<Object[], Object> t = dependencies.get(name);
            return (T)t.apply(params);
            /*Function<Object[], Object> execute = (Function<Object[], Object>) result.execute();

            result = new ExecutableInstanceImpl(execute, params);*/
        }
    }


    public void register(String key, Function<Object[], Object> creator) {
        dependencies.put(key, creator);
    }


    public <T> T resolve2(String key, Object... args) {


        if (!dependencies.containsKey(key)) {
            throw new RuntimeException("Dependency " + key + " is not registered");
        }
        return (T) dependencies.get(key).apply(args);
    }

    public void newScope(String scopeId) {
        scopes.get().put(scopeId, new HashMap<>());
        //or
        scopes.set(new HashMap<>());
    }

    public void setCurrentScope(String scopeId) {
        // noop, потому что мы используем ThreadLocal
    }


    /*public static void switchScope(String scopeId) {
        if (!scopes.get().containsKey(scopeId)) {
            throw new RuntimeException("Scope not found");
        }
        scopes.set(scopes.get().get(scopeId));
    }

    private static Map<String, Object> getCurrentScope() {
        Map<String, Object> scope = scopes.get().get(Thread.currentThread().getName());
        if (scope == null) {
            scope = globalScope;
        }
        return scope;
    }*/

}