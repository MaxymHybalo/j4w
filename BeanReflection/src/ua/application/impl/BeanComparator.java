package ua.application.impl;

import ua.application.ui.SimpleJTable;

import java.lang.reflect.Field;

public class BeanComparator {

    public static <T,V> void compare(T firstObj,V secondObj) throws IllegalAccessException {
        Class firstReflection = firstObj.getClass();
        Class secondReflection = secondObj.getClass();

        String title = firstReflection.getSimpleName() + " - " + secondReflection.getSimpleName();

        Field[] firstFields = firstReflection.getDeclaredFields();

        Field[] secondFields = secondReflection.getDeclaredFields();

        Object[][] data = new Object[firstFields.length][4];

        for (int i = 0; i < firstFields.length; i++) {

            firstFields[i].setAccessible(true);
            secondFields[i].setAccessible(true);
            data[i][0] = firstFields[i].getName();
            data[i][1] = firstFields[i].get(firstObj);

            for (int j = 0; j < secondFields.length; j++) {

                if (firstFields[i].getName().equals(secondFields[j].getName())) {

                    data[i][2] = secondFields[j].get(secondObj);
                    data[i][3] = (firstFields[i].get(firstObj).equals(secondFields[j].get(secondObj))) ? "+": "-";
                    break;

                } else {
                    data[i][2] = "-";
                    data[i][3] = "-";
                }

            }

        }
        Object[] headers = {"Field", firstReflection.getSimpleName(), secondReflection.getSimpleName(), "Match"};
        new SimpleJTable(title,data,headers);
    }




}
