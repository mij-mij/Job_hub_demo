package com.noname.jobhub.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.cgi.bonnie.configuration", "com.noname.jobhub.h2storage.clientapplication", "com.noname.jobhub.h2storage.position"})
@SpringBootApplication
public class Starter {

    public static void main(String[] args) {

        SpringApplication.run(Starter.class, args);
    }

}
