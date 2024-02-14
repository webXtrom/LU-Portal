package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminProgram extends AppCompatActivity {

    Button cseButton,eeeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_program);


        cseButton = findViewById(R.id.cseprogramButton1);
        eeeButton = findViewById(R.id.eeeButton1);


        cseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myintent = new Intent(adminProgram.this,AdminProgramCSE.class);
                startActivity(myintent);
            }
        });

        eeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to next page (aboutus)
                Intent myintent = new Intent(adminProgram.this, ProgramEEE.class);
                startActivity(myintent);
            }
        });

    }
}

