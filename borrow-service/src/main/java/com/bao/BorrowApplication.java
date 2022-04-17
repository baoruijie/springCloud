package com.bao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class BorrowApplication {
    public static void main(String[] args) {

        SpringApplication.run(BorrowApplication.class,args);
    }
}
