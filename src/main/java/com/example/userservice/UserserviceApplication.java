package com.example.userservice;

import com.example.userservice.models.Role;
import com.example.userservice.models.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "Role1"));
            userService.saveRole(new Role(null, "Role2"));
            userService.saveRole(new Role(null, "Role3"));
            userService.saveRole(new Role(null, "Role4"));

            userService.saveUser(new User(null, "John", "abc@gmail.com", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "John2", "abc2@gmail.com", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "John3", "abc3@gmail.com", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "John4", "abc4@gmail.com", "password", new ArrayList<>()));

            userService.addRoleToUser("abc@gmail.com", "Role1");
            userService.addRoleToUser("abc@gmail.com", "Role2");
            userService.addRoleToUser("abc2@gmail.com", "Role2");
            userService.addRoleToUser("abc3@gmail.com", "Role4");
            userService.addRoleToUser("abc4@gmail.com", "Role3");
            userService.addRoleToUser("abc3@gmail.com", "Role2");

        };
    }

}
