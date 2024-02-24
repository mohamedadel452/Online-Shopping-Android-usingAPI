package com.example.finalproject_intern.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.finalproject_intern.R;
import com.example.finalproject_intern.repo.remotedata.productModel.ProductModel;
import com.example.finalproject_intern.viewmodels.ViewModle;

import java.io.Serializable;
import java.util.ArrayList;

public class productelctronesactivety extends AppCompatActivity {
    ImageView back,productimage;
    TextView productname,productcatagory,productdescreption,price;
    Button addtochart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productelctronesactivety);

      addtochart=findViewById(R.id.addtochart);

        productimage=findViewById(R.id.proImage);
        productname=findViewById(R.id.product_title);
        productcatagory=findViewById(R.id.productcatagory);
        productdescreption=findViewById(R.id.descriptionView);
        price=findViewById(R.id.priceView);
        back=findViewById(R.id.arrow_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(productelctronesactivety.this,Allelctronecproduct.class));
            }
        });

        ViewModle productViewModel;
        Intent intent = getIntent();
        int position = intent.getIntExtra("pos",0);
        productViewModel = new ViewModelProvider(this).get( ViewModle.class);
        productViewModel.getelectronics(this).observe(this,productModels -> {
            productname.setText(productModels.get(position).getTitle());
            productdescreption.setText(productModels.get(position).getDescription());
            price.setText("$"+productModels.get(position).getPrice());
            productcatagory.setText(productModels.get(position).getCategory());
            Glide.with(this)
                    .load(productModels.get(position).getImage())
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .fallback(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(productimage);

            addtochart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Chart.cardofRVS =new ArrayList<>();
                    Chart.cardofRVS.add(new ProductModel(productModels.get(position)));
                    Intent intent1=new Intent(productelctronesactivety.this,Chart.class);
                    intent1.putExtra("price",  productModels.get(position).getPrice());
                    intent1.putExtra("name",productModels.get(position).getTitle());
                    intent1.putExtra("des",  productModels.get(position).getTitle());
                    intent1.putExtra("image", productModels.get(position).getImage());
                    startActivity(intent1);
                }
            });
        });
    }
}