package cn.chenxinjie.mx.sys;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@EnableDiscoveryClient
@RestController
public class SysApplication {

    public static void main(String[] args) {
        System.out.println("SysApplication start");
        SpringApplication.run(SysApplication.class, args);
    }
}
