package com.beginners.sim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

@SpringBootApplication
public class SchoolInventoryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolInventoryManagementApplication.class, args);
    }

    @Bean
    public ModelMap modelMap() {
        return new ModelMap();
    }

}
