package com.bouncer77.CourseProgressMaestro.repository;

import com.bouncer77.CourseProgressMaestro.entity.Address;
import com.bouncer77.CourseProgressMaestro.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnerRelationsTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void inverseEndTest() throws Exception {
        List<Person> people = personRepository.findByFirstName("Anna");
        Person anna = people.get(0);

        anna.setLastName("Kuznesova");
        anna.setAddress(Arrays.asList(new Address("Vologda")));

        personRepository.save(anna);
        // Была проблема
        // Адрес сохранился без внешних ключей

        // Решение
        //! Как сохранить внешние ключи в Inverse End?
        /*
        * В классе Person в setAddressList
        * Кажому адресу проставить id Person
        * */
    }

    @Test
    public void ownerTest() throws Exception {
        List<Address> cities = addressRepository.findByCity("Samara");
        Address samara = cities.get(0);

        samara.setHouseNumber("23");
        samara.setPerson(new Person("Alex", "Semenov"));

        addressRepository.save(samara);
        // Когда сохраняем Owner сохраняются и данные и внешние связи
    }
}
