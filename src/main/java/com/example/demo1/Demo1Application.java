package com.example.demo1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //Springboot核心注解，主要用于开启spring自动配置
//SpringBoot的引导类是Boot工程的执行入口，运行main方法就可以启动项目
//入口
public class Demo1Application {
//springboot：项目代码必须放到Demo1Application类所在的同级目录或下级目录
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);

    }


}
