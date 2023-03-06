package com.java.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import javax.swing.*;

@SpringBootApplication
@EnableConfigServer
public class Config_3344_startSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(Config_3344_startSpringCloudApp.class,args);
    }
}
