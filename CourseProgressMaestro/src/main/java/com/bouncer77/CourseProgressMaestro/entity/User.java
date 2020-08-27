package com.bouncer77.CourseProgressMaestro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;
    private String password;
    private String email;
    private String lastname;
    private String firstname;
    private String secondname;
    private String phone;
    //private LocalDate birtday;
    //private LocalDateTime registrationDateTime;
    private String role; // Student, Teacher, Admin

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        // this.login = email.substring(0, email.lastIndexOf('@'));
    }


}
