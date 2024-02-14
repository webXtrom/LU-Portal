package com.naeemkhan.universityportal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.myViewHolder> {

    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {
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

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)

    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name,email,number,type;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(CircleImageView) itemView.findViewById(R.id.img);
            name=(TextView)itemView.findViewById(R.id.name);
            email=(TextView)itemView.findViewById(R.id.email);
            number=(TextView)itemView.findViewById(R.id.number);
            type=(TextView)itemView.findViewById(R.id.type);
        }
    }

}
