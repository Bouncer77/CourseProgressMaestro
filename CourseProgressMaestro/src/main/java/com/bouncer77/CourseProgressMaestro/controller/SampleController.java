package com.bouncer77.CourseProgressMaestro.controller;

import com.bouncer77.CourseProgressMaestro.entity.Person;
import com.bouncer77.CourseProgressMaestro.entity.User;
import com.bouncer77.CourseProgressMaestro.repository.PersonRepository;
import com.bouncer77.CourseProgressMaestro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 */

@Controller
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    @ResponseBody
    String home(String name) {

        if (Objects.isNull(name)) {
            return "В запросе не указано имя пользователя";
        }

        List<Person> people = personRepository.findByFirstName(name);

        if (people.isEmpty()) {
            return "Пользователь с именем \\'" + name + "\\' не найден";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Person p : people) {
            stringBuilder.append(p.toString());
        }
        return stringBuilder.toString();
    }

    @RequestMapping("/user")
    @ResponseBody
    String createUser(String email, String password) {

        if (Objects.isNull(email) || Objects.isNull(password)) {
            return "Не указана почта или пароль";
        }

        User user = new User(email, password);
        System.out.println(user);

        try {
            userRepository.save(user);
        } catch (Exception e) {
            return e.getCause().getCause().getLocalizedMessage();
        }


        System.out.println(userRepository.findAllOrderedByFirstName());
        return "Пользователь:\n" +
                "логин: '" + user.getLogin() + "'\n" +
                "пароль: '" + user.getPassword() + "'\n" +
                "Успешно создан";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}
