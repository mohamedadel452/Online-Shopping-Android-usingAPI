package com.example.finalproject_intern.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.finalproject_intern.R;
import com.example.finalproject_intern.ui.adapters.CatagoriescastomAdapter;
import com.example.finalproject_intern.viewmodels.CatagoresViewmodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Catagoryes extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView arrow_back;
    Intent intent;
    RecyclerView recyclerView;
    CatagoresViewmodel catagoresViewmodel;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagoryes);
        intent=new Intent(this,Home.class);
        searchView=findViewById(R.id.search);
         arrow_back=findViewById(R.id.arrow_back);
         arrow_back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(intent);
             }
         });


         recyclerView=findViewById(R.id.rec1);
        ArrayList<CardofRV> cardofRVS=new ArrayList<>();
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        cardofRVS.add(new CardofRV("jewelery","4 Products"));
        cardofRVS.add(new CardofRV("men's clothing","4 Products"));
        cardofRVS.add(new CardofRV("Electronics","6 Products"));
        cardofRVS.add(new CardofRV( "women's clothing","6 Products"));
        CatagoriescastomAdapter adapterForRV=new CatagoriescastomAdapter(cardofRVS,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapterForRV);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//////                @Override
//////                public boolean onQueryTextSubmit(String query) {
//////                    return false;
//////                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    CatagoriescastomAdapter.getFilter().filter(newText);
////                    new Handler().postDelayed(new Runnable() {
////                        @Override
////                        public void run() {
////                            textView.setText("Founded "+productCAstomadapteer.getItemCount());
////                        }
////                    }, 1000);
//
//                    return false;
//                }
//            });


















//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        catagoresViewmodel = new ViewModelProvider(this).get(CatagoresViewmodel.class);
//        catagoresViewmodel.getcatagory(this).observe(this, catagoryModels -> {
//            CatagoriescastomAdapter    catagoriescastomAdapter = new  CatagoriescastomAdapter(Catagoryes.this,catagoryModels);
//            recyclerView.setAdapter(catagoriescastomAdapter);
//            recyclerView.setLayoutManager(linearLayoutManager);
////            textView.setText("Founded "+productCAstomadapteer.getItemCount());
//
//
////            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////                @Override
////                public boolean onQueryTextSubmit(String query) {
////                    return false;
////                }
////
////                @Override
////                public boolean onQueryTextChange(String newText) {
////                    CatagoriescastomAdapter.getFilter().filter(newText);
//////                    new Handler().postDelayed(new Runnable() {
//////                        @Override
//////                        public void run() {
//////                            textView.setText("Founded "+productCAstomadapteer.getItemCount());
//////                        }
//////                    }, 1000);
////
////                    return false;
////                }
////            });
//
//        });
















        bottomNavigationView =findViewById(R.id.bottombar);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.cart:{

                        startActivity(new Intent(getApplicationContext(),Chart.class));
                        overridePendingTransition(0,0);
                        return true;}
                    case R.id.home:{
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