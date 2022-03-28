package com.test;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


/**
 * @author mac
 * test
 */
@SpringBootApplication
@MapperScan(basePackages = "com.test.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
