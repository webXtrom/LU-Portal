package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AboutUs extends AppCompatActivity {

    Button founderChairmanVc,positionOfLu,administrationOfUv,boardOfTrustees,syndicateOfUniversity,
            academicCouncil,proctorialBody,officeOfTrustees;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        founderChairmanVc = findViewById(R.id.founderChairmanVc);
        positionOfLu = findViewById(R.id.positionOfLu);
        administrationOfUv = findViewById(R.id.administrationOfUv);
        boardOfTrustees = findViewById(R.id.boardOfTrustees);
        syndicateOfUniversity = findViewById(R.id.syndicateOfUniversity);
        academicCouncil = findViewById(R.id.academicCouncil);
        proctorialBody = findViewById(R.id.proctorialBody);
        officeOfTrustees = findViewById(R.id.officeOfTrustees);



        founderChairmanVc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this,FounderChairmanVc.class);
                startActivity(intent);
            }
        });

        positionOfLu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this,PositionOfUniversity.class);
                startActivity(intent);
            }
        });
        administrationOfUv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this,AdministrationOfUniversity.class);
                startActivity(intent);
            }
        });

        boardOfTrustees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this,BoardOfTrustees.class);
                startActivity(intent);
            }
        });

        syndicateOfUniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this,Syndicate.class);
                startActivity(intent);
            }
        });


        academicCouncil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this,AcademicCouncil.class);
                startActivity(intent);
            }
        });


        proctorialBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this,ProctorialBody.class);
                startActivity(intent);
            }
        });

        officeOfTrustees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this,OfficeOfTrustees.class);
                startActivity(intent);
            }
        });



    }
}