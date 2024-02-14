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

public class problem extends AppCompatActivity {

    EditText etid;
    EditText etprb1;
    EditText etprb2;
    Spinner spinnerprb1, spinnerprb2;
    Button submitbtn;


    DatabaseReference dbref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);

        etid = findViewById(R.id.tvid);
        etprb1 = findViewById(R.id.tv1);
        etprb2 = findViewById(R.id.tv2);
        spinnerprb1 = findViewById(R.id.problem1);
        spinnerprb2 = findViewById(R.id.problem2);
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
        String id = etid.getText().toString();
        String prb1 = etprb1.getText().toString();
        String prb2 = etprb2.getText().toString();
        String spinner1 = spinnerprb1.getSelectedItem().toString();
        String spinner2 = spinnerprb2.getSelectedItem().toString();


        Problems problems = new Problems(id,prb1,prb2,spinner1,spinner2);

        dbref.push().setValue(problems);
        Toast.makeText(problem.this, "Data Inserted", Toast.LENGTH_SHORT).show();
    }
}
