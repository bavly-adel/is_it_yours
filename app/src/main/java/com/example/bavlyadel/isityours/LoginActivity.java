package com.example.bavlyadel.isityours;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText emailTxt;
    private EditText passTxt;
    private Button regBtn;
    private ProgressBar loginprogress;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTxt = (EditText) findViewById(R.id.reg_name);
        passTxt = (EditText) findViewById(R.id.reg_pass);
        regBtn = (Button) findViewById(R.id.reg_btn);
        loginprogress = (ProgressBar) findViewById(R.id.login_progress);

        mAuth = FirebaseAuth.getInstance();

    }



    public void login(View view) {
        String email = emailTxt.getText().toString();
        String pass = passTxt.getText().toString();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)){
            loginprogress.setVisibility(View.VISIBLE);

            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){

                        sendToMain();


                    }else {

                        String errormsg = task.getException().getMessage();
                        Toast.makeText(LoginActivity.this,"Error "+errormsg,Toast.LENGTH_LONG).show();

                    }
                    loginprogress.setVisibility(View.INVISIBLE);



                }
            });

        }else {
            Toast.makeText(LoginActivity.this,"You should enter your Email and Password !",Toast.LENGTH_LONG).show();

        }

    }



    @Override
    protected void onStart() {

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser !=null){
            sendToMain();
        }

        super.onStart();
    }

    private void sendToMain(){
        Intent goMain = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(goMain);
        finish();
    }


    public void signUp(View view) {
        Intent goRegister = new Intent(LoginActivity.this,RegisterationActivity.class);
        startActivity(goRegister);
        finish();
    }
}
