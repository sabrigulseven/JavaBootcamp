package com.godoro.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class MyDataReflect {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.godoro.source.MyData");
        Constructor<?> constructor = clazz.getConstructor();
        Object object = constructor.newInstance();

        for (Field field : clazz.getFields()) {
            System.out.println(field.getName()+" "+ field.getType().getName());
        }

        Field myDoubleField = clazz.getField("myDouble");
        myDoubleField.set(object, 98.6);
        Object myDoubleValue = myDoubleField.get(object);
        System.out.println("Double değeri: " +myDoubleValue);
    }
}
