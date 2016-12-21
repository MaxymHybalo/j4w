package ua.application.impl;

import ua.application.ui.SimpleJTable;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class BeanRepresenter {

    private BeanRepresenter(){}

    private static String title;

    private static Object[][] data;

    public static <T>  void represent(T object) throws IllegalAccessException {

        Class reflection = object.getClass();

        title = reflection.getSimpleName();

        Field[] fields = reflection.getDeclaredFields();

        data = new Object[fields.length][2];

        for(int i=0;i < fields.length;i++){
            fields[i].setAccessible(true);
            data[i][0] = fields[i].getName();
            data[i][1] = fields[i].get(object).toString();
        }

        new SimpleJTable(title,data,SimpleJTable.REPRESENTER_HEADERS);

    }

}
