package com.updog.greencap.updogschoolalpha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {

    private ImageButton panel1; // image one on the main menu 
    private ImageButton panel2;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main_menu);

        panel1 = (ImageButton)findViewById(R.id.imageButton);
        panel2 = (ImageButton)findViewById(R.id.imageButton2);

        panel1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // do smth, or go somewhere
            }
        });

    }
}
