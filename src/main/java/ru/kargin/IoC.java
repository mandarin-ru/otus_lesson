package ru.kargin;

import org.reflections.Reflections;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class IoC<params> {

    Reflections scanner;

    private static final Map<String, Function<Object[], Object>> dependencies = new HashMap<>();
    private static final ThreadLocal<String> scopes =  new ThreadLocal<>();
    private static ThreadLocal<Map<String, Object>> scopeRegistry = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, Object>> scopes2 = ThreadLocal.withInitial(HashMap::new);


    static <T> T resolve(String name, Object[] params) {
        ExecutableInstance result;

        if (name.equalsIgnoreCase("IoC.Register")) {
            Function<Object[], Object> instanceInitializer = (Function<Object[], Object>) params[1];
            //Map<String, Object> scope = getCurrentScope();
            dependencies.put(String.valueOf(params[0]),  instanceInitializer);

            /*попробовать добавить*/
        } else if(name.equalsIgnoreCase("Scopes.New")) {

            String scope = scopes.get();
            scopes.set(String.valueOf(params[0]));
        } else if(name.equalsIgnoreCase("Scopes.Current")) {

            scopes.set(String.valueOf(params[0]));

        } else {
            String scope = scopes.get();

            /*if (scope.get(key)) {
                return (T) scopes.get();
            }else{*/
                Function<Object[], Object> t = dependencies.get(name);
                
                return (T)t.apply(params);
            //}
        }
        return null;
    }

}