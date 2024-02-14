package com.naeemkhan.universityportal;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewHolder2 extends RecyclerView.Adapter<ViewHolder2.MyViewHolder> {

    Context context;
    ArrayList<Model2> list;

    public ViewHolder2(Context context, ArrayList<Model2> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Model2 model2 = list.get(position);
        holder.typesofCourses.setText(model2.getTypesofCourses().toString());
        holder.NoofCourses.setText(model2.getNoofCourses().toString());
        holder.creditHours.setText(model2.getCreditHours().toString());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView typesofCourses,NoofCourses,creditHours;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            typesofCourses = itemView.findViewById(R.id.Textview1);
            NoofCourses = itemView.findViewById(R.id.Textview2);
            creditHours = itemView.findViewById(R.id.Textview3);

        }
    }

}





