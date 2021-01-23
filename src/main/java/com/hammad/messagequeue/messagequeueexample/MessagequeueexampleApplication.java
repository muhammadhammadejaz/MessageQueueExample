package com.hammad.messagequeue.messagequeueexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessagequeueexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagequeueexampleApplication.class, args);
    }

}
