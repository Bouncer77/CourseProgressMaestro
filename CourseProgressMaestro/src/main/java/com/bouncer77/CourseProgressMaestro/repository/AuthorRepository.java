package com.bouncer77.CourseProgressMaestro.repository;

import com.bouncer77.CourseProgressMaestro.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 24.08.2020
 */

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByFirstName(String firstName);

    @Query("select a from Author a order by a.firstName")
    List<Author> findAllOrderedByFirstName();
}
