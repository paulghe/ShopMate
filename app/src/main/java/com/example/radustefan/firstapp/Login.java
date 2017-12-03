package com.example.radustefan.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.SubmitLogin);

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

        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
                   Login();
                }
                return false;
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }

    void Login(){
        String uname = username.getText().toString();
        String pass = password.getText().toString();

        final AppDatabase db = AppDatabase.getDatabaseInstance(getApplicationContext());

        int result =db.userDao().verifyUser(uname,pass);
        Log.d("TestDB", String.valueOf(result));
        // TODO : CHECK ACCOUNT
        if (db.userDao().verifyUser(uname,pass) != 0){
            startActivity(new Intent(Login.this, mainPage.class));
        }else {
            Toast.makeText(getApplicationContext(), "Invalid username or password.", Toast.LENGTH_LONG).show();
        }
    }

}
