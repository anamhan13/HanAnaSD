package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"entity","repository","service","main","dto","builder","converter","controller","config"})
@EnableJpaRepositories(basePackages = {"repository"})
@PropertySource(value = "classpath:application.properties")
@EntityScan(basePackages ={"entity"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}