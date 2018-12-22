package com.example.bavlyadel.isityours;

public class question {
    private String content;
    private answer[] answers;

    public question(String content, answer[] answers) {
        this.content = content;
        this.answers = answers;
    }

    public question() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(answer[] answers) {
        this.answers = answers;
    }
}
