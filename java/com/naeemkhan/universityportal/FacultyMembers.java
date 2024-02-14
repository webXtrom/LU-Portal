package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacultyMembers extends AppCompatActivity {

    Button departmentOfCse,departmentOfBba,departmentOfEnglish,departmentOfEee,departmentOfCivilEngineering,
            departmentOfArchitecture,departmentOfLaw,departmentOfIslamicStudies,departmentOfPublicHealth,departmentOfTHM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_members);

        departmentOfCse = findViewById(R.id.departmentOfCse);
        /*departmentOfBba = findViewById(R.id.departmentOfBba);
        departmentOfEnglish = findViewById(R.id.departmentOfEnglish);
        departmentOfEee = findViewById(R.id.departmentOfEee);
        departmentOfCivilEngineering = findViewById(R.id.departmentOfCivilEngineering);
        departmentOfArchitecture = findViewById(R.id.departmentOfArchitecture);
        departmentOfLaw = findViewById(R.id.departmentOfLaw);
        departmentOfIslamicStudies = findViewById(R.id.departmentOfIslamicStudies);
        departmentOfPublicHealth = findViewById(R.id.departmentOfPublicHealth);
        departmentOfTHM = findViewById(R.id.departmentOfTHM);*/


        departmentOfCse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfCSE.class);
                startActivity(intent);
            }
        });

     /*   departmentOfBba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfBBA.class);
                startActivity(intent);
            }
        });

        departmentOfEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfEnglish.class);
                startActivity(intent);
            }
        });

        departmentOfEee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfEEE.class);
                startActivity(intent);
            }
        });

        departmentOfCivilEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfCivilEngineering.class);
                startActivity(intent);
            }
        });

        departmentOfArchitecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfArchitecture.class);
                startActivity(intent);
            }
        });

        departmentOfLaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfLaw.class);
                startActivity(intent);
            }
        });

        departmentOfIslamicStudies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfIslamicStudies.class);
                startActivity(intent);
            }
        });

        departmentOfPublicHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfPublicHealth.class);
                startActivity(intent);
            }
        });

        departmentOfTHM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyMembers.this,DepartmentOfTHM.class);
                startActivity(intent);
            }
        });

*/




    }
}