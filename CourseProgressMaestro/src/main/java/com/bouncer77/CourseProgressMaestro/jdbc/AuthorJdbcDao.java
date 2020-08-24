package com.bouncer77.CourseProgressMaestro.jdbc;

import com.bouncer77.CourseProgressMaestro.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 24.08.2020
 */

@Repository
public class AuthorJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Author> findAll() {
        List<Author> authorList = jdbcTemplate.query("select * from jpa.author",
                new BeanPropertyRowMapper<>(Author.class));

        return authorList;
    }

    public int insert(Author author) {
        // возвращает 1, если вставлена одна строка
        return jdbcTemplate.update("insert into jpa.author" +
                "(id, first_name, last_name, second_name)" +
                "values (?,?,?,?)",
                new Object[] {
                        author.getId(), author.getFirstName(),
                        author.getLastName(), author.getSecondName()
                });

    }
}
