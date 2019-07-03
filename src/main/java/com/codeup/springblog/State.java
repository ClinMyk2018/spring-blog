package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name = "states")
public class State {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private double tax;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
