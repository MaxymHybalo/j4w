package java4web.javaconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java4web.entity.Car;
import java4web.entity.Engine;
import java4web.entity.Tyres;
import java4web.entity.Wheel;

@Configuration
@PropertySource("classpath:values.properties")
public class ApplicationConfiguration {

    @Value("${wheel.tyres.size}")
    private Double tyreSize;

    @Value("${wheel.tyres.name}")
    private String tyreName;

    @Value("${car.engine.capacity}")
    private Double engineCapacity;

    @Bean(name = "javaCar")
    public Car getCar(){
        return new Car(new Wheel[]{wheel(),wheel(),wheel()}, engine());
    }

    @Bean
    public Engine engine(){
        return new Engine(engineCapacity);
    }

    @Bean
    public Wheel wheel(){
        return new Wheel(tyres());
    }

    @Bean
    public Tyres tyres(){
        return new Tyres(tyreSize,tyreName);
    }

}
