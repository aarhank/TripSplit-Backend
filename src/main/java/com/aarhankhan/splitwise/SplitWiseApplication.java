package com.aarhankhan.splitwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan("com.aarhankhan.splitwise.repository")
@ComponentScan("com.aarhankhan.splitwise.entity")
@ComponentScan("com.aarhankhan.splitwise.model")
@ComponentScan("com.aarhankhan.splitwise.controller")
@ComponentScan("com.aarhankhan.splitwise.service")
@ComponentScan("com.aarhankhan.splitwise.config")
@ComponentScan("com.aarhankhan.splitwise.event")
public class SplitWiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SplitWiseApplication.class, args);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
}
