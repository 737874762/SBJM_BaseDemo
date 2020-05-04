package com.example.basedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.basedemo.dao")
public class BasedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasedemoApplication.class, args);
    }

}
