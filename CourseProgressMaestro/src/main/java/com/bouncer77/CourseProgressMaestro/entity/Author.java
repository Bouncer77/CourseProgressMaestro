package com.bouncer77.CourseProgressMaestro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 24.08.2020
 */

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;
    private String secondName;

    public Author() {
    }

    public Author(String firstName, String lastName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String second_name) {
        this.secondName = second_name;
    }

    @Override
    public String toString() {
        return "\nAuthor{" +
                "id = " + id +
                ", first_name = " + firstName +
                ", last_name = " + lastName +
                ", second_name = " + secondName +
                "}";
    }
}
