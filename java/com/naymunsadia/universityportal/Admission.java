package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admission extends AppCompatActivity {

    Button admissionButton,scholarshipAdmission,tuitionFees,howToApply,academicPrograms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        admissionButton = findViewById(R.id.admissionButton);
        scholarshipAdmission = findViewById(R.id.scholarshipAdmission);
        tuitionFees = findViewById(R.id.tuitionFees);
        howToApply = findViewById(R.id.howToApply);
        academicPrograms = findViewById(R.id.academicPrograms);




        admissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admission.this,AdmissionAndRegistrationPolicies.class);
                startActivity(intent);
            }
        });

        scholarshipAdmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admission.this,ScholarshipAndAid.class);
                startActivity(intent);
            }
        });

        tuitionFees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admission.this,TuitionFees.class);
                startActivity(intent);
            }
        });

        howToApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admission.this,HowToApply.class);
                startActivity(intent);
            }
        });

        academicPrograms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admission.this,AcademicPrograms.class);
                startActivity(intent);
            }
        });




    }
}