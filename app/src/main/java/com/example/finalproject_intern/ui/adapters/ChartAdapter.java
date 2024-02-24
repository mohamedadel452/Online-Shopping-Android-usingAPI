package com.example.finalproject_intern.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.finalproject_intern.R;
import com.example.finalproject_intern.repo.remotedata.productModel.ProductModel;
import com.example.finalproject_intern.ui.Allelctronecproduct;
import com.example.finalproject_intern.ui.Alljewlaryactivity;
import com.example.finalproject_intern.ui.Allmenproduct;
import com.example.finalproject_intern.ui.Allwomenproduct;
import com.example.finalproject_intern.ui.CardofRV;

import java.util.ArrayList;

public class ChartAdapter  extends RecyclerView.Adapter<ChartAdapter.Myviewholder>{



    ArrayList<ProductModel> crads=new ArrayList<>();
    Context ctx;
    public ChartAdapter(ArrayList<ProductModel> cardofRVS, Context ctx) {

        this.crads=cardofRVS;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public ChartAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardofproduct,null,false);
        ChartAdapter.Myviewholder myviewholder =new ChartAdapter.Myviewholder(view);
        return myviewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull ChartAdapter.Myviewholder holder, int position) {
        ProductModel card =crads.get(position);
        holder.productname.setText(card.getTitle());
        holder.productdescreption.setText(card.getDescription());
        holder.productprice.setText("$"+card.getPrice());
        Glide.with(ctx)
                .load(card.getImage())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .fallback(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.productimge);

    }

    @Override
    public int getItemCount() {
        return crads.size();
    }

    class Myviewholder extends RecyclerView.ViewHolder{
        ImageView productimge;
        TextView productname,productdescreption,productprice;

        public ImageView getProductimge() {
            return productimge;
        }

        public void setProductimge(ImageView productimge) {
            this.productimge = productimge;
        }

        public TextView getProductname() {
            return productname;
        }

        public void setProductname(TextView productname) {
            this.productname = productname;
        }



        public TextView getProductdescreption() {
            return productdescreption;
        }

        public void setProductdescreption(TextView productdescreption) {
            this.productdescreption = productdescreption;
        }

        public TextView getProductprice() {
            return productprice;
        }

        public void setProductprice(TextView productprice) {
            this.productprice = productprice;
        }

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            this.productimge = itemView.findViewById(R.id.productImg);;
            this.productname = itemView.findViewById(R.id.descreption);;
            this.productdescreption = itemView.findViewById(R.id.descreption);
            this.productprice = itemView.findViewById(R.id.price);;
        }


    }
}
