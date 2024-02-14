
package com.naeemkhan.universityportal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdminAdaptercse extends FirebaseRecyclerAdapter<MainModel, AdminAdaptercse.myViewHolder> {

    public AdminAdaptercse(@NonNull FirebaseRecyclerOptions<MainModel> options) {

        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdminAdaptercse.myViewHolder holder, final int position, @NonNull MainModel model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.number.setText(model.getNumber());
        holder.type.setText(model.getType());
        Glide.with(holder.img.getContext())
                .load(model.getSurl())
                .placeholder(R.drawable.ic_baseline_person_24)
                .circleCrop()
                .error(R.drawable.ic_baseline_person_24)
                .into(holder.img);

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.updatefacultycsepopup))
                        .setExpanded(true,1700)
                        .create();
//                dialogPlus.show();

                View view1 = dialogPlus.getHolderView();

                EditText name= view1.findViewById(R.id.textname);
                EditText email= view1.findViewById(R.id.textemail);
                EditText number= view1.findViewById(R.id.textnumber);
                EditText type= view1.findViewById(R.id.texttype);
                EditText surl= view1.findViewById(R.id.textimage);


                Button btnUpdate=view1.findViewById(R.id.btnupdate);


                name.setText(model.getName());
                email.setText(model.getEmail());
                number.setText(model.getNumber());
                type.setText(model.getType());
                surl.setText(model.getSurl());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("number",number.getText().toString());
                        map.put("type",type.getText().toString());
                        map.put("surl",surl.getText().toString());

                        FirebaseDatabase.getInstance().getReference("users")
                                .child(getRef(holder.getAdapterPosition()).getKey())
                                .updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(), "Data Update Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.name.getContext(), "Error While Updating", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Delete data can't be undo");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference("users").child(getRef(holder.getAdapterPosition()).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.name.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();


            }
        });




    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)

    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.admincsefaculty,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{


        CircleImageView img;
        TextView name,email,number,type;
        Button btnEdit,btnDelete;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);


            img=(CircleImageView) itemView.findViewById(R.id.img);
            name=(TextView)itemView.findViewById(R.id.name);
            email=(TextView)itemView.findViewById(R.id.email);
            number=(TextView)itemView.findViewById(R.id.number);
            type=(TextView)itemView.findViewById(R.id.type);

            btnEdit=(Button) itemView.findViewById(R.id.btnEdit);
            btnDelete=(Button) itemView.findViewById(R.id.btnDelete);
        }
    }

}
