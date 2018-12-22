package com.example.bavlyadel.isityours;

public class foundPost extends post {
        private question[] questions;

    public foundPost(String title, String image_url, String content, comment[] comments, question[] questions) {
        super(title, image_url, content, comments);
        this.questions = questions;
    }

    public foundPost(question[] questions) {
        this.questions = questions;
    }

    public question[] getQuestions() {
        return questions;
    }

    public void setQuestions(question[] questions) {
        this.questions = questions;
    }
}
