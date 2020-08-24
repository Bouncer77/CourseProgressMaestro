package com.bouncer77.CourseProgressMaestro.entity;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 24.08.2020
 */

public class Author {

    private int id;
    private String first_name;
    private String last_name;
    private String second_name;

    public Author() {
    }

    public Author(int id, String first_name, String last_name, String second_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.second_name = second_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @Override
    public String toString() {
        return "\nAuthor{" +
                "id = " + id +
                ", first_name = " + first_name +
                ", last_name = " + last_name +
                ", second_name = " + second_name +
                "}";
    }
}
