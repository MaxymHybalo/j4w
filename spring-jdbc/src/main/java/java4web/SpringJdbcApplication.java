package java4web;

import java4web.entity.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringJdbcApplication.class, args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcApplication.class);
        Car car = (Car) ctx.getBean("javaCar");
        System.out.println(car.toString());
    }
}
