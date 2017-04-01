package java4web;

import java4web.dao.CarDao;
import java4web.dao.impl.CarDaoImpl;
import java4web.entity.Car;
import java4web.entity.Engine;
import java4web.entity.Tyres;
import java4web.entity.Wheel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableTransactionManagement
public class ApplicationConfiguration {


    @Bean
    public CarDao carDao(){
        return new CarDaoImpl(source());
    }

    @Bean
    @Qualifier("car")
    public Car car(){
        Car car = new Car();
        car.setId(1);
        car.setName("Honda");
        car.setEngine(new Engine(3.1));
        List<Wheel> wheels = new ArrayList<>();
        wheels.add(new Wheel(new Tyres(18d, "Michlen")));
        wheels.add(new Wheel(new Tyres(18d, "Michlen")));
        wheels.add(new Wheel(new Tyres(18d, "Michlen")));
        wheels.add(new Wheel(new Tyres(18d, "Michlen")));
        car.setWheels(wheels);
        return car;
    }

    @Bean
    @Qualifier("brokenCar")
    public Car brokenCar(){
        Car car = new Car();
        car.setId(1);
        car.setName("Honda");
        car.setEngine(null);
        car.setWheels(null);
        return car;
    }

    @Bean
    public DataSource source(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUsername("root");
        source.setPassword("root");
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/cars");
        return source;
    }

    @Bean
    public PlatformTransactionManager manager(){
        return new DataSourceTransactionManager(source());
    }
}
