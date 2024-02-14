package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.naeemkhan.universityportal.R;

public class AdminProblemSave extends AppCompatActivity {

    EditText id;
    EditText p1;
    EditText y2;
    Spinner s1, n1;
    Button submitbtn;


    DatabaseReference dbref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_problem_save);

        id = findViewById(R.id.tvid);
        p1 = findViewById(R.id.tv1);
        y2 = findViewById(R.id.tv2);
        s1 = findViewById(R.id.problem1);
        n1= findViewById(R.id.problem2);
        submitbtn = findViewById(R.id.btn1);

        dbref = FirebaseDatabase.getInstance().getReference("Problem");


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SubmitProblem();
            }
        });


    }

    private void SubmitProblem(){
        String etid = id.getText().toString();
        String prb1 = p1.getText().toString();
        String ety2 = y2.getText().toString();
        String etn1 = n1.getSelectedItem().toString();
        String ets1 = s1.getSelectedItem().toString();


        Problems problems = new Problems(etid,prb1,ety2,etn1,ets1);

        dbref.push().setValue(problems);
        Toast.makeText(AdminProblemSave.this, "Data Inserted", Toast.LENGTH_SHORT).show();
    }
}

