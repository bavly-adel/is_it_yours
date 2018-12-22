package com.example.bavlyadel.isityours;


/**
 * Created by bavlyadel on 12/22/18.
 */

public class User {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;






    public User(String id,String name, String phone, String email,  String password) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }







}
