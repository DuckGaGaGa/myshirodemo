package com.duckgagaga.shirodemo.myshirodemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication()

@MapperScan("com.duckgagaga.shirodemo.myshirodemo.dao")
/*
@SpringBootConfiguration*/

public class MyshirodemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshirodemoApplication.class, args);
    }

}
