package java4web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource manager = new DriverManagerDataSource();
        manager.setDriverClassName("com.mysql.jdbc.Driver");
        manager.setUrl("jdbc:mysql://localhost:3306/cars");
        manager.setPassword("root");
        manager.setUsername("root");
        return manager;
    }
}
