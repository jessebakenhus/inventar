package us.bakenh.inventar.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("us.bakenh")
@EnableJpaRepositories(basePackages = "us.bakenh")
@SpringBootApplication(scanBasePackages = { "us", "com" })
public class WebServer {

    public static void main(String[] args) {
        SpringApplication.run(WebServer.class, args);
    }

}
