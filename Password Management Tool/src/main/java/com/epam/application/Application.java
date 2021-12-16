package com.epam.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = "com.epam")
@EnableJpaRepositories(basePackages = "com.epam")
@EnableTransactionManagement
@EntityScan(basePackages = "com.epam")

public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}