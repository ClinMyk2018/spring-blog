package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class dogs {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;

    @Column(columnDefinition = "char(2) NOT NULL" )
    private char resideState;

    public dogs() {
    }

    public dogs(String name, int age, char resideState) {
        this.name = name;
        this.age = age;
        this.resideState = resideState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getResideState() {
        return resideState;
    }

    public void setResideState(char resideState) {
        this.resideState = resideState;
    }
}
