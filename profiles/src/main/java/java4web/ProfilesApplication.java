package java4web;

import java4web.entity.Car;
import java4web.entity.Engine;
import java4web.javaconfig.DevelopmentConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProfilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilesApplication.class,args);
	}
}
