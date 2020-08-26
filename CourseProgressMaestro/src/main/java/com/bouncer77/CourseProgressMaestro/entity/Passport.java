package com.bouncer77.CourseProgressMaestro.entity;

import javax.persistence.*;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 26.08.2020
 */

@Entity
public class Passport {

    // strategy = GenerationType.IDENTITY генерировать уникальные идентификаторы для сущности, а не вообще для всех
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // nullable = false // мы не можем сохранить паспорт без его владельца
    @Column(unique = true, nullable = false)
    private String number;


    // Чтобы не удалить Person после удаления паспорта
        // Перечисляем все каскады, кроме Remove
    /*@OneToOne(mappedBy = "passport", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH
    })*/
    // имя соответствует полю из Person
    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Person person;

    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

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
