package com.bouncer77.CourseProgressMaestro.repository;

import com.bouncer77.CourseProgressMaestro.entity.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void findByFirstName() {

        List<Author> authorList = authorRepository.findByFirstName("Anna");

        assertThat(authorList).hasSize(1);
        assertThat(authorList.get(0).getLastName()).isEqualTo("Andreeva");
    }

    @Test
    public void findAllOrderedByFirstName() {
        List<Author> authorList = authorRepository.findAllOrderedByFirstName();

        System.out.println(authorList);

        assertThat(authorList).hasSize(3);
        assertThat(authorList.get(2).getFirstName()).isEqualTo("Olesya");
        assertThat(authorList.get(1).getFirstName()).isEqualTo("Nick");
        assertThat(authorList.get(0).getFirstName()).isEqualTo("Anna");
    }
}