package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Birthday implements Serializable {
    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public Birthday(int id, String name, String surname, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Birthday{" + "id=" + id + ", name='" + name + '\'' + ", dateOfBirth=" + new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) + '}';
    }
}
