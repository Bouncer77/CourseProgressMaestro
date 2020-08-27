package com.bouncer77.CourseProgressMaestro.entity;

import jdk.internal.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.util.List;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 26.08.2020
 */

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    // Если удаляется Person, то удаляются и все телефоны

    // fetch = FetchType.LAZY - по умолчанию, !не загружает вложенные коллекции в экземпляр класса Person
    // Uni-directional (однонаправленная аннотация)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<Phone> phoneList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    // Bi-directional (двунаправленная)
    // mappedBy - значение точно соответствует значению переменной в переменной person в Address
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addressList;

    public Person() { }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public List<Address> getAddress() {
        return addressList;
    }

    public void setAddress(List<Address> addressList) {

        for (Address a : addressList) {
            a.setPerson(this);
        }
        this.addressList = addressList;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                //", addresses='" + addressList + '\'' +
                ", passport=" + passport +
                '}';
    }
}
