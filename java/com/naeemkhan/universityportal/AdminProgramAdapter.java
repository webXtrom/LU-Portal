package com.naeemkhan.universityportal;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AdminProgramAdapter extends FirebaseRecyclerAdapter<AdminProgramModel, AdminProgramAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */


    public AdminProgramAdapter(@NonNull FirebaseRecyclerOptions<AdminProgramModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdminProgramAdapter.myViewHolder holder,  final int position, @NonNull AdminProgramModel model) {

        holder.typesofCourses.setText(model.getTypesofCourses());
        holder.noofcourses.setText(model.getNoofCourses());
        holder.credithours.setText(model.getCreditHours());

        //holder.text.setText(model.getText());

        holder.editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.typesofCourses.getContext())
                        .setContentHolder(new ViewHolder(R.layout.updateprogram_popup)).setExpanded(true, 800).create();


                //dialogPlus.show();

                View view1 = dialogPlus.getHolderView();

                EditText typesofCourses = view1.findViewById(R.id.text1);
                EditText noofcourses = view1.findViewById(R.id.text2);
                EditText creditHours = view1.findViewById(R.id.text3);



                Button updatebtn = view1.findViewById(R.id.updatebtn1);

                typesofCourses.setText(model.getTypesofCourses());
                noofcourses.setText(model.getNoofCourses());
                creditHours.setText((model.getCreditHours()));




                dialogPlus.show();


                updatebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String, Object> map = new HashMap<>();
                        map.put("typesofCourses",typesofCourses.getText().toString());
                        map.put("NoofCourses",noofcourses.getText().toString());
                        map.put("creditHours",creditHours.getText().toString());


                        FirebaseDatabase.getInstance().getReference("Program")
                                .child(getRef(holder.getAdapterPosition()).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.typesofCourses.getContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })

                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(holder.typesofCourses.getContext(), "Error while updating", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });



            }
        });


        holder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.typesofCourses.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Deleted data can't be undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference("Program")
                                .child(getRef(holder.getAdapterPosition()).getKey()).removeValue();

                    }
                });


                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.typesofCourses.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.show();
            }
        });





    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item4, parent, false);
        return new myViewHolder(view);
    }




    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView typesofCourses,noofcourses,credithours;


        Button editbtn,deletebtn;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            typesofCourses = itemView.findViewById(R.id.Textview1);
            noofcourses = itemView.findViewById(R.id.Textview2);
            credithours = itemView.findViewById(R.id.Textview3);

            editbtn = itemView.findViewById(R.id.btn1);
            deletebtn = itemView.findViewById(R.id.btn2);
        }
    }
}

