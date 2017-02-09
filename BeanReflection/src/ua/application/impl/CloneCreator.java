package ua.application.impl;

import ua.application.ui.SimpleJTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


public class CloneCreator {

    public static <T> Object clone(T object) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Class reflection = object.getClass();
        Constructor<T> constructor = reflection.getConstructors()[0];

        Object [] parameters = new Object[constructor.getParameterCount()];
        Class []  paramTypes = constructor.getParameterTypes();

        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = paramTypes[i].isPrimitive()? 0 : paramTypes[i].newInstance();
        }

        constructor.getParameterCount();

        Object instance;
        if(parameters.length!=0){
            instance = constructor.newInstance(parameters);
        }else {
            instance = reflection.newInstance();
        }

        Class instanceReflection = instance.getClass();
        Field [] inputObjectFields = reflection.getDeclaredFields();
        Field [] outputObjectFields = instanceReflection.getDeclaredFields();
        for (int i = 0; i < inputObjectFields.length; i++) {
            inputObjectFields[i].setAccessible(true);
            outputObjectFields[i].setAccessible(true);
            outputObjectFields[i].set(instance,inputObjectFields[i].get(object));
        }

        //Display massage
        String title = reflection.getSimpleName();
        Object[][] hashData = {
                {
                        object.hashCode(),
                        instance.hashCode()
                }
        };
        new SimpleJTable(title,hashData,SimpleJTable.CLONE_HEADERS);

        return instance;

    }

}
