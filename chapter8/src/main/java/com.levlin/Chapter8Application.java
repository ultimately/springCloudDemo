package com.levlin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: levlin
 * @Date: 2018/10/16
 * @version: 1.0
 * @Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.levlin.mapper")
public class Chapter8Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter8Application.class, args);
    }
}
