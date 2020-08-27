package com.bouncer77.CourseProgressMaestro.repository;

import com.bouncer77.CourseProgressMaestro.entity.Person;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 26.08.2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationsTest {

    @Autowired
    PersonRepository personRepository;

    /*
    * Для того чтобы получить доступ к бд нам нужна сессия
    *
    * Spring Data закрывает сессию после выполнения метода findByFirstName
    * Это гарантирует отсутствие утечек памяти, когда сессии не закрываются
    * Однако, когда сессия закрыта, то к БД нельзя обратиться
    *
    * При попытке обратиться в бд, то выбрасывается исключежние, которое сообщает, что
    * коллекция имеет тип загрузки lazy, просто не загрузилась в данном случае
    * */
    @Test(expected = LazyInitializationException.class)
    public void lazyLoadingException() {
        List<Person> anna = personRepository.findByFirstName("Anna");
        // session closed

        System.out.println(anna.get(0).getPhoneList());
    }

    // не закрывает сессию до конца метода
    @Test
    @Transactional
    public void lazyLoadingTransactional() {
        List<Person> anna = personRepository.findByFirstName("Anna");
        System.out.println(anna.get(0).getPhoneList());
    }
}
