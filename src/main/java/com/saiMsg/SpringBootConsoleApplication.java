package com.saiMsg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication {

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo

        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

}