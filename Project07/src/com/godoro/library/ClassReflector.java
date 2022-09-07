package com.godoro.library;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassReflector {
    private Class<?> type;
    private Constructor<?> constructor;
    private Map<String, PropertyReflector> properties = new HashMap<>();

    public ClassReflector(Class<?> type) throws NoSuchMethodException, SecurityException {
        setType(type);
    }

    public ClassReflector(String className) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
        setType(Class.forName(className));
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) throws NoSuchMethodException, SecurityException {
        this.type = type;
        constructor = type.getConstructor();
        findProperties();
    }

    public Object newInstance()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return constructor.newInstance();
    }

    private void findProperties() throws NoSuchMethodException, SecurityException {
        for (Method method : type.getDeclaredMethods()) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                String sub = method.getName().substring(3);
                String property = Character.toLowerCase(sub.charAt(0)) + sub.substring(1);
                String title = Character.toUpperCase(property.charAt(0))
                        + property.substring(1);
                String get = "get" + title;
                Method getter = type.getMethod(get);
                String set = "set" + title;
                Class<?> parameterTypes[] = { getter.getReturnType() };
                Method setter = type.getMethod(set, parameterTypes);
                PropertyReflector propertyReflector = new PropertyReflector(this, set, getter, setter);
                properties.put(property, propertyReflector);
            }
        }
    }

    public Map<String, PropertyReflector> getProperties() {
        return properties;
    }

    public PropertyReflector getPropertyReflector(String properyName) {
        return properties.get(properyName);
    }

    public void setValue(Object object, String property, Object value)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        PropertyReflector propertyReflector = getPropertyReflector(property);
        Object arguments[] = { value };
        propertyReflector.getSetter().invoke(object, arguments);
    }

    public Object getValue(Object object, String property)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        PropertyReflector propertyReflector = getPropertyReflector(property);
        Object result = propertyReflector.getGetter().invoke(object);
        return result;
    }
}
