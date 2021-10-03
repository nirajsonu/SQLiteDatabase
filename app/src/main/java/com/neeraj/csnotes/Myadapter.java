package com.neeraj.csnotes;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    Activity activity;
    Integer image[];
    String text[];

    public Myadapter(Activity activity,Integer image[],String text[])
    {
    this.activity=activity;
    this.image=image;
    this.text=text;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=activity.getLayoutInflater().inflate(R.layout.custom_layout,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.iv.setImageResource(image[position]);
//        holder.tv.setText(text[position]);
    }

    @Override
    public int getItemCount() {return image.length;}

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.image);
           // tv=itemView.findViewById(R.id.textView);
        }
    }
}
