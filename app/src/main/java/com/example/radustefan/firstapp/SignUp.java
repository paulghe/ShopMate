package com.example.radustefan.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText username, password, email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        submit = (Button) findViewById(R.id.Submit);


        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("username")) {
                    username.setText("");
                }
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals("password")) {
                    password.setText("");
                }
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("@email")){
                    email.setText("");
                }
            }
        });

        email.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && i == KeyEvent.KEYCODE_ENTER){
                    signUpAction();
                }
                return false;
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpAction();
            }
        });
    }

    void signUpAction(){
        String uname = username.getText().toString();
        String pass = password.getText().toString();
        String mail = email.getText().toString();

        // TODO : ADD AND CHECK
        if (!uname.isEmpty() && !pass.isEmpty() && !mail.isEmpty()){
            startActivity(new Intent(SignUp.this, Login.class));
        }
    }

}
