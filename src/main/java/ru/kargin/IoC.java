package ru.kargin;

import javassist.tools.reflect.Reflection;
import org.reflections.Reflections;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class IoC<params> {

    Reflections scanner;
    /*Class<?>[] mainClasses, String... args*/

    static <T> T  resolve(String name/*, Object[] params*/) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Reflections scanner = new Reflections("ru.kargin");
        Set<Class<? extends MoveCommand>> a =  scanner.getSubTypesOf(MoveCommand.class);





        Constructor<?> constructor =  Class.forName("ru.kargin.MoveCommand").getConstructor();

        System.out.println(Arrays.toString(constructor.getParameterTypes()));

        Object myObj = constructor.newInstance();
        return (T) myObj;

    }



}