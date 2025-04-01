package com.multi.travel_404;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.multi.travel_404.model.dao")
@SpringBootApplication
public class Travel404Application {
    public static void main(String[] args) {
        SpringApplication.run(Travel404Application.class, args);
    }
}

