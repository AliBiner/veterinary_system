package com.alibiner.veterinary_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.alibiner", "com.alibiner.veterinary_management_system.config"})
@EnableJpaRepositories("com.alibiner.repositories")
@EntityScan("com.alibiner.entities")
public class VeterinaryManagementSystemApplication {

    static void main(String[] args) {
        SpringApplication.run(VeterinaryManagementSystemApplication.class, args);
    }

}
