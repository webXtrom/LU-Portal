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

public class AdminNoticeAdapter extends FirebaseRecyclerAdapter<AdminNoticeModel, AdminNoticeAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */


    public AdminNoticeAdapter(@NonNull FirebaseRecyclerOptions<AdminNoticeModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdminNoticeAdapter.myViewHolder holder,  final int position, @NonNull AdminNoticeModel model) {

        holder.text.setText(model.getText());

        Glide.with(holder.img.getContext()).load(model.getImage()).apply(new RequestOptions().override(Target.SIZE_ORIGINAL)).into(holder.img);


        holder.editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.updatenotice_popup)).setExpanded(true, 800).create();


                //dialogPlus.show();

                View view1 = dialogPlus.getHolderView();

                EditText text = view1.findViewById(R.id.ettext);
                EditText image = view1.findViewById(R.id.etimage);

                Button updatebtn = view1.findViewById(R.id.updatebtn);


                text.setText(model.getText());
                image.setText(model.getImage());

                dialogPlus.show();


                updatebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String, Object> map = new HashMap<>();
                        map.put("Text",text.getText().toString());
                        map.put("image",image.getText().toString());

                        FirebaseDatabase.getInstance().getReference("Notice")
                                .child(getRef(holder.getAdapterPosition()).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.text.getContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })

                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(holder.text.getContext(), "Error while updating", Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.text.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Deleted data can't be undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference("Notice")
                                .child(getRef(holder.getAdapterPosition()).getKey()).removeValue();

                    }
                });


                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.text.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.show();
            }
        });





    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3, parent, false);
        return new myViewHolder(view);
    }




    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView img;

        Button editbtn,deletebtn;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.Textview1);
            img = itemView.findViewById(R.id.imageView1);

            editbtn = itemView.findViewById(R.id.btn1);
            deletebtn = itemView.findViewById(R.id.btn2);
        }
    }
}
