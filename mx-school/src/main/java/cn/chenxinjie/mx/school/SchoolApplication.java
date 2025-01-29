package cn.chenxinjie.mx.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@EnableDiscoveryClient
@RestController
public class SchoolApplication {

    public static void main(String[] args) {
        System.out.println("SchoolApplication start");
        SpringApplication.run(SchoolApplication.class, args);
    }
}
