package com.example.bavlyadel.isityours;

public class comment {
    private String content ;
    private User user ;

    public comment(String content, User user) {
        this.content = content;
        this.user = user;
    }

    public comment() {
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
