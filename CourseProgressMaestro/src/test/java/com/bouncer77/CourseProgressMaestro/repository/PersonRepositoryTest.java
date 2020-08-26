package com.bouncer77.CourseProgressMaestro.repository;

import com.bouncer77.CourseProgressMaestro.entity.Author;
import com.bouncer77.CourseProgressMaestro.entity.Passport;
import com.bouncer77.CourseProgressMaestro.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 26.08.2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PassportRepository passportRepository;

    @Test
    public void findByFirstName() {

        List<Person> people = personRepository.findByFirstName("Anna");

        assertThat(people).hasSize(1);
        assertThat(people.get(0).getLastName()).isEqualTo("Andreeva");
    }

    @Test
    public void findAllOrderedByFirstName() {
        List<Person> people = personRepository.findAllOrderedByFirstName();
        System.out.println(people);
        assertThat(people).hasSize(2);
        assertThat(people.get(0).getFirstName()).isEqualTo("Anna");
        assertThat(people.get(1).getFirstName()).isEqualTo("Olesya");
    }

    /*
    * Если удалить Passport удалиться и Person
    * */
    @Test
    public void deletePassport() {
        Passport passport = passportRepository.findByNumber("222222222");

        // Если требуется удалить только пасспорт, а Person оставить
        // passport.getPerson().getPassport().getPerson()....
        // passport.getPerson().setPassport(null);

        passportRepository.delete(passport);
        List<Person> people = personRepository.findAll();
        assertThat(people).hasSize(1);

        List<Passport> passportList = passportRepository.findAll();
        assertThat(passportList).hasSize(1);
    }
}