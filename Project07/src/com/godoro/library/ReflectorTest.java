package com.godoro.library;


import com.godoro.source.MyBean;

public class ReflectorTest {
    public static void main(String[] args) throws Exception {

        ClassReflector classReflector = new ClassReflector(MyBean.class);
        Object object = classReflector.newInstance();

        classReflector.setValue(object, "myLong", 123);
        System.out.println("Özdeşliğim: " + classReflector.getValue(object, "myLong"));

        classReflector.setValue(object, "myString", "godoro");
        System.out.println("Adım: " + classReflector.getValue(object, "myString"));

        classReflector.setValue(object, "myDouble", 123);
        System.out.println("Değerim: " + classReflector.getValue(object, "myDouble"));
    }  
}
