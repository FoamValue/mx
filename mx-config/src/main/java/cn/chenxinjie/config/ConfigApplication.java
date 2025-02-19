package cn.chenxinjie.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableConfigServer
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        System.out.println("ConfigApplication start");
        SpringApplication.run(ConfigApplication.class, args);
    }
}
