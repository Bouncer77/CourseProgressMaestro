package com.bouncer77.CourseProgressMaestro.controller;

import com.bouncer77.CourseProgressMaestro.entity.Person;
import com.bouncer77.CourseProgressMaestro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

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

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}
