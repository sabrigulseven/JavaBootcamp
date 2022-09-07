package com.godoro.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBeanReflect {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.godoro.source.MyBean");
        Constructor<?> constructor = clazz.getConstructor();

        List<String> propertyNames = new ArrayList<>();
        Map<String, Method> getters = new HashMap<>();
        Map<String, Method> setters = new HashMap<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                String sub = method.getName().substring(3);
                String property = Character.toLowerCase(sub.charAt(0)) + sub.substring(1);
                propertyNames.add(property);
            }
        }

        for (String propertyName : propertyNames) {
            System.out.print(propertyName + " ");
            String title = Character.toUpperCase(propertyName.charAt(0))
                    + propertyName.substring(1);
            String get = "get" + title;
            Method getter = clazz.getMethod(get);
            System.out.print(getter.getName() + " ");
            getters.put(propertyName, getter);
            String set = "set" + title;
            Class<?> parameterTypes[] = { getter.getReturnType() };
            Method setter = clazz.getMethod(set, parameterTypes);
            System.out.print(setter.getName() + " ");
            setters.put(propertyName, setter);
            System.out.println();
        }

        Object object = constructor.newInstance();
        String propertyName = "myValue";
        Method getter = getters.get(propertyName);
        Method setter = setters.get(propertyName);

        Object arguments[] = { 98.76 };
        setter.invoke(object, arguments);
        Object result = getter.invoke(object);
        System.out.println("sonuç: " + result);
    }
}
