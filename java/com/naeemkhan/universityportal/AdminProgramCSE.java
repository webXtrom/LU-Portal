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

public class AdminProgramCSE extends AppCompatActivity {


    RecyclerView recyclerView;

    AdminProgramAdapter adminProgramAdapter;


    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_program_cse);

        recyclerView = findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AdminProgramModel> options = new FirebaseRecyclerOptions.Builder<AdminProgramModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Program"), AdminProgramModel.class).build();

        adminProgramAdapter = new AdminProgramAdapter(options);
        recyclerView.setAdapter(adminProgramAdapter);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdminProgramSave.class));
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        adminProgramAdapter.startListening();
    }


}




