package com.example.bavlyadel.isityours;

public class answer {
    private String content;
    private boolean is_right;


    public answer(String content, boolean is_right) {
        this.content = content;
        this.is_right = is_right;
        }

    public answer() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIs_right() {
        return is_right;
    }

    public void setIs_right(boolean is_right) {
        this.is_right = is_right;
    }
}
