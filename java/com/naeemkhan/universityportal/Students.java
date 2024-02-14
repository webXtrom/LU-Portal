package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Students extends AppCompatActivity {
private Button ranklist,problem,tuitionFeesAndPaymentSystem;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);




        ranklist=findViewById(R.id.ranklist);
        problem=findViewById(R.id.problem);
        tuitionFeesAndPaymentSystem = findViewById(R.id.tuitionFeesAndPaymentSystem);


        tuitionFeesAndPaymentSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Students.this,TuitionFeesAndPaymentSystem.class);
                startActivity(intent);
            }
        });



        ranklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to next page (aboutus)
                Intent myintent = new Intent(Students.this, ProgramCse.class);
                startActivity(myintent);
            }
        });


        problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to next page (aboutus)
                Intent myintent = new Intent(Students.this, problem.class);
                startActivity(myintent);
            }
        });
    }
}