package com.example.bavlyadel.isityours;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterationActivity extends AppCompatActivity {

    private EditText nameTxt;
    private EditText phoneTxt;
    private EditText emailTxt;
    private EditText passTxt;
    private ProgressBar loginProgress;

    private String name;
    private String phone;
    private String email;
    private String pass;
    private String id;

    DatabaseReference userData;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        userData = FirebaseDatabase.getInstance().getReference("Users");
        mAuth = FirebaseAuth.getInstance();



        System.out.println("n nbbnnbbnbkjjj");
        nameTxt = (EditText) findViewById(R.id.reg_name);
        phoneTxt = (EditText) findViewById(R.id.reg_phone);
        emailTxt = (EditText) findViewById(R.id.reg_email);
        passTxt = (EditText) findViewById(R.id.reg_pass);
        loginProgress = (ProgressBar) findViewById(R.id.login_progress);
        loginProgress.setVisibility(View.INVISIBLE);

    }

    public void goLogin(View view) {
        Intent goLogin = new Intent(RegisterationActivity.this,LoginActivity.class);
        startActivity(goLogin);
        finish();
    }

    public void signup(View view) {

        name = nameTxt.getText().toString();
        pass= passTxt.getText().toString();
        email= emailTxt.getText().toString();
        phone= phoneTxt.getText().toString();

        addToAuth();


    }



    public void createUser(){
        User user = new User(id,name,phone,email,pass);
        userData.child(id).setValue(user);
        loginProgress.setVisibility(View.INVISIBLE);
        Toast.makeText(RegisterationActivity.this,name + " added successfully",Toast.LENGTH_LONG).show();
    }

    public void sendToMain(){
        Intent goMain = new Intent(RegisterationActivity.this,MainActivity.class);
        startActivity(goMain);
        finish();
    }

    public void addToAuth(){
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone)){
            loginProgress.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        FirebaseUser userID=mAuth.getCurrentUser();

                        id=userID.getUid();
                        createUser();
                        sendToMain();

                    }else {
                        String errorMsg = task.getException().getMessage();
                        loginProgress.setVisibility(View.INVISIBLE);
                        Toast.makeText(RegisterationActivity.this,"Error: "+errorMsg,Toast.LENGTH_LONG ).show();
                    }
                }

            });
        }else {
            Toast.makeText(RegisterationActivity.this,"You should fill all the fields !",Toast.LENGTH_LONG).show();

        }

    }
}
