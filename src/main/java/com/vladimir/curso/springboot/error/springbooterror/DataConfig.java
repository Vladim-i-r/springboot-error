package com.vladimir.curso.springboot.error.springbooterror;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vladimir.curso.springboot.error.springbooterror.models.domain.User;

@Configuration
public class DataConfig {

    @Bean
    List<User> users(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Vladimir","Lopez"));
        users.add(new User(2L, "Ana","Hernandez"));
        users.add(new User(3L, "Rafael","Gonzo"));
        users.add(new User(4L, "Gabriel","Murala"));
        users.add(new User(5L, "Jose","Perez"));
        return users;
    }
}
