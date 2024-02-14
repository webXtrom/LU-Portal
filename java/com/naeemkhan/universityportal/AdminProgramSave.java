package com.naeemkhan.universityportal;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AdminProgramSave extends AppCompatActivity {

    EditText typesofcourses, noofcourses, creditHours;

    Button addbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_program_save);


        typesofcourses = (EditText) findViewById(R.id.text1);
        noofcourses = (EditText) findViewById(R.id.text2);
        creditHours = (EditText) findViewById(R.id.text3);

        addbtn = (Button) findViewById(R.id.addbtn1);




        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                ClearAll();

            }
        });

    }

    int counter = 0;
    @Override
    public void onBackPressed() {

        counter++;
        if(counter == 2)
            super.onBackPressed();

    }



    private void insertData(){
        Map<String, Object> map = new HashMap<>();

        map.put("typesofCourses",typesofcourses.getText().toString());
        map.put("NoofCourses",noofcourses.getText().toString());
        map.put("creditHours",creditHours.getText().toString());


        FirebaseDatabase.getInstance().getReference("Program")
                .push().setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AdminProgramSave.this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AdminProgramSave.this, "Error while insertion.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void ClearAll() {
        typesofcourses.setText("");
        noofcourses.setText("");
        creditHours.setText("");

    }
}