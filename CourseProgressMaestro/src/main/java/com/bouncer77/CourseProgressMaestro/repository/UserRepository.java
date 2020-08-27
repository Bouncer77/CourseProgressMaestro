package com.bouncer77.CourseProgressMaestro.repository;

import com.bouncer77.CourseProgressMaestro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

    User findByEmail(String email);

    List<User> findByFirstName(String firstName);

    @Query("select u from User u order by u.firstName")
    List<User> findAllOrderedByFirstName();
}
