package com.naeemkhan.universityportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.naeemkhan.universityportal.AdminProblemAdapter;

public class AdminProblem extends AppCompatActivity {


    RecyclerView recyclerView;

    AdminProblemAdapter adminProblemAdapter;


    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_problem);

        recyclerView = findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AdminProblemModel> options = new FirebaseRecyclerOptions.Builder<AdminProblemModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Problem"), AdminProblemModel.class).build();

        adminProblemAdapter = new AdminProblemAdapter(options);
        recyclerView.setAdapter(adminProblemAdapter);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdminProblemSave.class));
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        adminProblemAdapter.startListening();
    }


}




