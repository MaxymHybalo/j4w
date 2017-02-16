package ua.j4w.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.j4w.entity.Car;

public class JavaConfigApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Car car = context.getBean("javaCar", Car.class);
        System.out.println(car.toString());
    }
}
