package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminStudent extends AppCompatActivity {

    Button program,problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student);


        program = findViewById(R.id.btn1);
        problem = findViewById(R.id.btn2);

       program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminStudent.this,adminProgram.class);
                startActivity(intent);
            }
        });

        problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminStudent.this,AdminProblem.class);
                startActivity(intent);
            }
        });
    }
}