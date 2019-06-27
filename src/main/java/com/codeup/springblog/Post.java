package com.codeup.springblog;

import javax.annotation.processing.Generated;
import java.security.PrivateKey;

//@Entity
//@Table(name= "posts")
public class Post {

//    @Id
//    @GeneratedValue
    private int id;
    private String title;
    private String body;

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
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
