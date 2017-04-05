package java4web.servlets.config;

import java4web.servlets.dao.GuestDao;
import java4web.servlets.dao.GuestDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public GuestDao guestDao(){
        return new GuestDaoImpl(source());
    }

    @Bean
    public DataSource source(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUsername("root");
        source.setPassword("root");
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/geekhub");
        return source;
    }

    @Bean
    public PlatformTransactionManager manager(){
        return new DataSourceTransactionManager(source());
    }
}
