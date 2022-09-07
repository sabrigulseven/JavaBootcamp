package com.godoro.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyActorReflect {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.godoro.source.MyActor");
        Constructor<?> constructor = clazz.getConstructor();
        Object object = constructor.newInstance();

        for (Method method : clazz.getDeclaredMethods()) {
            System.out.print(method.getReturnType() + " ");
            System.out.print(method.getName());
            for (Parameter parameter : method.getParameters()) {
                System.out.println(
                        parameter.getType() + " " + parameter.getName() + ",");
            }
            System.out.println();
        }

        Method proccesMethod = clazz.getMethod("process");
        proccesMethod.invoke(object);

        Class<?>[] parameterTypes = { int.class, String.class, double.class };
        Method transformMethod = clazz.getMethod("transform", parameterTypes);
        Object[] arguments = { 123, "godoro", 98.66 };
        Object result = transformMethod.invoke(object, arguments);
        System.out.println("Sonuç:" + result);
    }
}
