package com.example.bavlyadel.isityours;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by bavlyadel on 12/22/18.
 */

public class UserClass {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;


    DatabaseReference userData;



    public UserClass(String name, String email, String phone, String password) {
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


    public void create(){
        userData = FirebaseDatabase.getInstance().getReference("Users");
        this.id=userData.push().getKey();
        userData.setValue(this);
    }



}
