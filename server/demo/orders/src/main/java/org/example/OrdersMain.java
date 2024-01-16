package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@MapperScan("org.example.mapper")
@SpringBootApplication
public class OrdersMain {
    public static void main(String[] args) {
        SpringApplication.run(OrdersMain.class, args);
    }
}
