package ua.j4w.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.j4w.entity.Car;

public class XmlConfigurationApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Car car =  context.getBean("car", Car.class);
        System.out.println(car.toString());
    }


}
