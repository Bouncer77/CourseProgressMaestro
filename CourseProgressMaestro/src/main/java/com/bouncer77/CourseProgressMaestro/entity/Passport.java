package com.bouncer77.CourseProgressMaestro.entity;

import javax.persistence.*;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 26.08.2020
 */

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // nullable = false // мы не можем сохранить паспорт без его владельца
    @Column(unique = true, nullable = false)
    private String number;

    @OneToOne(mappedBy = "passport", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Person person;

    public Passport() {}

    public Passport(String number) { this.number = number; }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number +
                '}';
    }
}
