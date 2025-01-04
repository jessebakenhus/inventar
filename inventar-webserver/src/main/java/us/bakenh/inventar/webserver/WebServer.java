package us.bakenh.inventar.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "us.bakenh.inventar")
public class WebServer {

    public static void main(String[] args) {
        SpringApplication.run(WebServer.class, args);
    }
}
