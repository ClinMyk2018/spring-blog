package com.codeup.springblog;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name= "posts")
public class Post {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT unsigned NOT NULL AUTO_INCREMENT")
    private int id;

    private String title;
    private String body;

    public Post() {
    }

    public Post(String title) {
        this.title = title;
    }

    public Post(String body, String title) {
        this.title = title;
        this.body = body;
    }

    public Post(int id, String body, String title) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
