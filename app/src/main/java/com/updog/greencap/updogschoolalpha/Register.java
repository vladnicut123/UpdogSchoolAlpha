package com.updog.greencap.updogschoolalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import java.util.Date;

public class Register extends AppCompatActivity{

    private EditText fName;
    private EditText sName;
    private EditText userName;
    private Date DOB; //date of birth
    private MultiAutoCompleteTextView sex;
    private EditText email;
    private EditText password;
    private EditText passwordAgn;
    private Button register;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fName = (EditText)findViewById(R.id.FNameTxt);
        sName = (EditText)findViewById(R.id.SNameTxt);
        userName = (EditText)findViewById(R.id.UNameTxt);
        //DOB = (Date)findViewById(R.id.DOBTxt);
        sex = (MultiAutoCompleteTextView)findViewById(R.id.SexChoice);
        email = (EditText)findViewById(R.id.emailTxt);
        password = (EditText)findViewById(R.id.PWord1Txt);
        passwordAgn = (EditText)findViewById(R.id.PWord2Txt);
        register = (Button)findViewById(R.id.RegisterButton);

        //if(processInfo(userName, password, passwordAgn)){
//
        //}


    }

    private boolean processInfo(String Uname, String pw1, String pw2){         // make a check from a database
        if(Uname == "Admin"){
            //check databse for existing user names

            // multiple checks (if else)
        } else if(pw1 == pw2){
            Intent intent = new Intent(Register.this, LogIn.class);
        } else {
            return true;
        }
        return false;
    }
}
