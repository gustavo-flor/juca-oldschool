package com.github.gustavoflor.juca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class JucaApplication {
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    public static void main(String[] args) {
        SpringApplication.run(JucaApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        TimeZone.setDefault(UTC);
    }
}
