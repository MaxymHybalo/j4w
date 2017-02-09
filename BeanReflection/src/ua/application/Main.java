package ua.application;

import ua.application.domain.Car;
import ua.application.domain.Cat;
import ua.application.domain.Human;
import ua.application.impl.BeanComparator;
import ua.application.impl.BeanRepresenter;
import ua.application.impl.CloneCreator;
import ua.application.ui.SimpleJTable;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Cat testCat  = new Cat("Black",3,4,134);
        Car testCar = new Car("Yellow",360,"Sport","Hurricane");
        Human testHuman = new Human(175,"male",20,60);


        //BeanRepresenter test
        BeanRepresenter.represent(testCat);

        //CloneCreator test
        CloneCreator.clone(testHuman);

        //BeanComparator test
        Car testCar2 =  new Car("Black",360,"Sedan","rx-8");
        BeanComparator.compare(testCar2,testCar);
        //Or two different types
        BeanComparator.compare(testCat,testCar);
    }

}
