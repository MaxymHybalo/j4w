package java4web;

import java4web.dao.CarDao;
import java4web.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		Car car = ctx.getBean("car",Car.class);
		CarDao carDao = ctx.getBean(CarDao.class);
		carDao.save(car);
		System.out.println("[Written in database]");
		System.out.println(car.toString());
		car = carDao.find(1	);
		System.out.println("[Read from database]");
		System.out.println(car.toString());
		System.out.println("[Try to write broken object]");
		car = ctx.getBean("brokenCar", Car.class);
		carDao.save(car);

	}
}
