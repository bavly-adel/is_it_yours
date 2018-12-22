package com.example.bavlyadel.isityours;

public class post {
    private String title;
    private String image_url;
    private String content;

    public post(String title, String image_url, String content, comment[] comments) {
        this.title = title;
        this.image_url = image_url;
        this.content = content;
        this.comments = comments;
    }

    public post() {
    }

    public comment[] getComments() {
        return comments;
    }

    public void setComments(comment[] comments) {
        this.comments = comments;
    }

    private comment[] comments;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
