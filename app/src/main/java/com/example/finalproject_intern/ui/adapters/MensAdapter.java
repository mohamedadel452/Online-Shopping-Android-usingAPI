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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.finalproject_intern.R;
import com.example.finalproject_intern.repo.remotedata.productModel.ProductModel;
import com.example.finalproject_intern.ui.productelctronesactivety;
import com.example.finalproject_intern.ui.productmenactivety;

import java.util.ArrayList;
import java.util.List;

public class MensAdapter extends RecyclerView.Adapter<ProductCAstomadapter.MyViewHolder> implements Filterable {



    Context ctx;
    List<ProductModel> prodList;
    List<ProductModel> prodListsearch;

    public MensAdapter(Context ctx, List<ProductModel> heroList) {
        this.ctx = ctx;
        this.prodList = heroList;
        prodListsearch=new ArrayList<>(prodList);
    }

    @NonNull
    @Override
    public ProductCAstomadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View recyclerView = inflater.inflate(R.layout.cardofproduct,parent,false);

        ProductCAstomadapter.MyViewHolder viewHolder = new ProductCAstomadapter.MyViewHolder(recyclerView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCAstomadapter.MyViewHolder holder, int position) {

        holder.prodname.setText(prodList.get(position).getTitle());
        holder.descreption.setText(prodList.get(position).getCategory());
        holder.price.setText("$"+prodList.get(position).getPrice());
        Glide.with(ctx)
                .load(prodList.get(position).image)
//                .load( "https://api.lorem.space/image/furniture?w=640&h=480&r=9470")
                .transition(withCrossFade(new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()))
                .into(holder.prodImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ctx, productmenactivety.class);
                int i = holder.getAdapterPosition();
                intent.putExtra("pos",holder.getAdapterPosition());


                ctx.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return prodList.size();
    }

    @Override
    public Filter getFilter() {

        return exambelfilter;
    }
    private Filter exambelfilter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ProductModel> filterList=new ArrayList<>();

            if(constraint==null||constraint.length()==0){
                filterList.addAll(prodListsearch);
            }
            else{
                String filterpattern = constraint.toString().toLowerCase().trim();

                for(ProductModel productModel:prodListsearch){
                    if(productModel.getTitle().toLowerCase().contains(filterpattern)){
                        filterList.add(productModel);
                    }
                }

            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filterList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            prodList.clear();
            prodList.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView prodname,descreption,price;
        public ImageView prodImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.prodname = itemView.findViewById(R.id.producttitle);
            this.descreption = itemView.findViewById(R.id.descreption);
            this.prodImage = itemView.findViewById(R.id.productImg);
            this.price = itemView.findViewById(R.id.price);
        }
    }
}
