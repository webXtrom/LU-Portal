package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgramCse extends AppCompatActivity {

    Button cseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_cse);


        cseButton = findViewById(R.id.prgcsebtn);



        cseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myintent = new Intent(ProgramCse.this,COURSEProgramCSE.class);
                startActivity(myintent);
            }
        });



    }
}
