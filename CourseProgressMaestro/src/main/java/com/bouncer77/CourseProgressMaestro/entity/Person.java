package com.bouncer77.CourseProgressMaestro.entity;

import javax.persistence.*;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 26.08.2020
 */

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;
    private String address;

    /*@OneToOne(cascade = CascadeType.ALL) // Если удалить Person удалиться и паспорт
    @JoinColumn(name = "passport_id") // название колонки в таблице Person (FK)
    private Passport passport;*/

    public Person() {
    }

    public Person(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }*/

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                //", passport=" + passport +
                '}';
    }
}
