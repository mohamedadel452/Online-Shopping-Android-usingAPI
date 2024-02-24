package com.example.finalproject_intern.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.finalproject_intern.R;
import com.example.finalproject_intern.repo.remotedata.productModel.ProductModel;
import com.example.finalproject_intern.ui.adapters.CatagoriescastomAdapter;
import com.example.finalproject_intern.ui.adapters.ChartAdapter;
import com.example.finalproject_intern.viewmodels.CatagoresViewmodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView back;
    Intent intent;
    RecyclerView recyclerView;
    SearchView searchView;
    TextView  NoProductYet;
    static ArrayList<ProductModel> cardofRVS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);



        back=findViewById(R.id.arrow_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Chart.this,Home.class));
            }
        });
        searchView=findViewById(R.id.search);
        recyclerView=findViewById(R.id.rec1);

         cardofRVS =new ArrayList<>();
         ChartAdapter adapterForRV=new ChartAdapter(cardofRVS,this);
         Intent intent=getIntent();
//         Bundle bundle = getIntent().getExtras();
          String productname=intent.getStringExtra("name");
          String productdes=intent.getStringExtra("des");
          double productprice=intent.getDoubleExtra("price",0);
          String productimage=intent.getStringExtra("image");
          ProductModel productModel=new ProductModel(productname, productprice, productdes, productimage);
          if(productprice!=0.0) {
              cardofRVS.add(productModel);
          }
         RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
         recyclerView.setAdapter(adapterForRV);
         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setHasFixedSize(true);

































        bottomNavigationView =findViewById(R.id.bottombar);
        bottomNavigationView.setSelectedItemId(R.id.cart);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.cart:{
                        return true;

                    }
                    case R.id.home:{
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;}
                    case R.id.profile:{
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;}
                    case R.id.navigation:{
                        startActivity(new Intent(getApplicationContext(),Notivigation.class));
                        overridePendingTransition(0,0);
                        return true;}
                }
                return false;
            }
        });
    }
}