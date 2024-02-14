package com.naeemkhan.universityportal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.Toast;

import java.util.ArrayList;

public class COURSEProgramCSE extends AppCompatActivity {


    RecyclerView recyclerView;
    ViewHolder2 viewHolder2;
    ArrayList<Model2> list;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseprogcse);


        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Program");

        list = new ArrayList<>();

        viewHolder2 = new ViewHolder2(this, list);

        recyclerView.setAdapter(viewHolder2);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot db: snapshot.getChildren()){
                    Model2 model2 = db.getValue(Model2.class);
                    list.add(model2);
                }

                viewHolder2.notifyDataSetChanged();
                Toast.makeText(COURSEProgramCSE.this, "Successful", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(COURSEProgramCSE.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });




    }


}

