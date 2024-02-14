package com.naeemkhan.universityportal;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

public class AdminProblemAdapter extends FirebaseRecyclerAdapter<AdminProblemModel, AdminProblemAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */


    public AdminProblemAdapter(@NonNull FirebaseRecyclerOptions<AdminProblemModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdminProblemAdapter.myViewHolder holder,  final int position, @NonNull AdminProblemModel model) {

        holder.id.setText(model.getId());
        holder.prb1.setText(model.getPrb1());
        holder.prb2.setText(model.getPrb2());
        holder.spn1.setText(model.getSpinner1());
        holder.spn2.setText(model.getSpinner2());



        //holder.text.setText(model.getText());






        holder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.prb1.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Deleted data can't be undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference("Problem")
                                .child(getRef(holder.getAdapterPosition()).getKey()).removeValue();

                    }
                });


                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.prb1.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.show();
            }
        });





    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item5, parent, false);
        return new myViewHolder(view);
    }




    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView id,prb1,prb2,spn1,spn2;



        Button deletebtn;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.Tevi1);
            prb1 = itemView.findViewById(R.id.Tevi2);
            prb2 = itemView.findViewById(R.id.Tevi3);
            spn1 = itemView.findViewById(R.id.Tevi4);
            spn2 = itemView.findViewById(R.id.Tevi5);


            deletebtn = itemView.findViewById(R.id.btn2);
        }
    }
}


