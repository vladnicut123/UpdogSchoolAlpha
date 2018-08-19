package com.updog.greencap.updogschoolalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity{

    private EditText Uname;
    private EditText Pword;

    private Button LOGIN;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Uname = (EditText)findViewById(R.id.UserNameLogIN);
        Pword = (EditText)findViewById(R.id.PasswordLogIN);

        LOGIN = (Button)findViewById(R.id.LOGIN);

        //validateCredentials
    }

    private void validateCredentials(String userName, String password){         // make a check from a database
        if((userName == "name") && (password == "secret")){
            Intent intent = new Intent(LogIn.this, MainMenu.class);
        } else {
            // say wrong credentialls
        }
    }
}
