package com.codeup.springblog.Model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 500)
    private String body;

    @OneToOne
    private Users user;

    //CONSTRUCTORS\\
    public Post() {
    }

    public Post(Users user_id) {
        this.user = user_id;
    }

    public Post(String title) {
        this.title = title;
    }

    public Post( String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, Users user_id) {
        this.title = title;
        this.body = body;
        this.user = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user_id) {
        this.user = user_id;
    }
}
