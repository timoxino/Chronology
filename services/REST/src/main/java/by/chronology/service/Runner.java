package by.chronology.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * An entry point of Spring-based application to launch it
 * from a Java main method using Spring Boot.
 *
 * @author Tsimafei_Shchytkavets
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "by.chronology.service")
public class Runner
{
    public static void main(String[] args)
    {
        SpringApplication.run(Runner.class, args);
    }
}
