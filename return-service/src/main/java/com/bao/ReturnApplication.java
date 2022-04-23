package com.bao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ReturnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReturnApplication.class,args);
    }
}
