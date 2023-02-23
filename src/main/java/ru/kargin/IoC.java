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

    static ExecutableInstance resolve(String name, Object[] params) {
        ExecutableInstance result;

        if (name.equalsIgnoreCase("IoC.Register")) {
            Function<Object[], Object> instanceInitializer = (Function<Object[], Object>) params[1];

            result = new ExecutableRegister(instanceInitializer);

            map.put(String.valueOf(params[0]), result);
        } else {
            result = map.get(name);
            Function<Object[], Object> execute = (Function<Object[], Object>) result.execute();

            result = new ExecutableInstanceImpl(execute, params);
        }

        return result;
    }


}