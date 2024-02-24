package com.example.finalproject_intern.ui.adapters;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_intern.R;
import com.example.finalproject_intern.repo.remotedata.productModel.CatagoresModel;
import com.example.finalproject_intern.ui.Allelctronecproduct;
import com.example.finalproject_intern.ui.Alljewlaryactivity;
import com.example.finalproject_intern.ui.Allmenproduct;
import com.example.finalproject_intern.ui.Allwomenproduct;
import com.example.finalproject_intern.ui.CardofRV;

import java.util.ArrayList;
import java.util.List;

public class CatagoriescastomAdapter extends RecyclerView.Adapter<CatagoriescastomAdapter.Myviewholder>  {
    ArrayList<CardofRV>crads=new ArrayList<>();

  Context ctx;
    public CatagoriescastomAdapter(ArrayList<CardofRV> cardofRVS, Context ctx) {

        this.crads=cardofRVS;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagorescell,null,false);
        Myviewholder myviewholder =new Myviewholder(view);
        return myviewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        CardofRV card =crads.get(position);
        holder.catagoryname.setText(card.getTital());
        holder.catagorycount.setText(card.getDescrip());
//        holder.imageView.setImageResource(card.getImage());
        int po= holder.getAdapterPosition();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(po==0){
                 Intent intent = new Intent(ctx, Alljewlaryactivity.class);
                 ctx.startActivity(intent);
             }
             else if(po==1){
                 Intent intent = new Intent(ctx, Allmenproduct.class);
                 ctx.startActivity(intent);
             }
             else if(po==2){
                 Intent intent = new Intent(ctx, Allelctronecproduct.class);
                 ctx.startActivity(intent);
             }
             else if (po==3){
                 Intent intent = new Intent(ctx, Allwomenproduct.class);
                 ctx.startActivity(intent);
             }
             else {
                 Toast.makeText(ctx, "there is an error ", Toast.LENGTH_SHORT).show();
             }


            }
        });

    }

    @Override
    public int getItemCount() {
        return crads.size();
    }




    class Myviewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView catagoryname;
        TextView catagorycount;

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getTital() {
            return catagoryname;
        }

        public void setTital(TextView tital) {
            this.catagoryname = tital;
        }

        public TextView getDescribtion() {
            return catagorycount;
        }

        public void setDescribtion(TextView describtion) {
            this.catagorycount = describtion;
        }

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            this.catagorycount=itemView.findViewById(R.id.catagorycount);
            this.catagoryname=itemView.findViewById(R.id.catagoryname);
        }
    }
}
