package java4web.javaconfig;

import java4web.entity.Engine;
import java4web.entity.Tyres;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProductionConfiguration {
    private static Logger log = LoggerFactory.getLogger(ProductionConfiguration.class);

    @Bean
    public Engine engine(){
        log.info("Bind new engine in prod mode");
        return new Engine();
    }

    @Bean
    public Tyres tyres(){
        log.info("Bind new tyres in prod mode");
        return new Tyres();
    }
}
