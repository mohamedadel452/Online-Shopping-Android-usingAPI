package com.example.finalproject_intern.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.finalproject_intern.R;
import com.example.finalproject_intern.ui.adapters.ElctronesAdpter;
import com.example.finalproject_intern.ui.adapters.JwelareAdapter;
import com.example.finalproject_intern.ui.adapters.MensAdapter;
import com.example.finalproject_intern.ui.adapters.ProductCAstomadapter;

import com.example.finalproject_intern.ui.adapters.WomenAdapter;
import com.example.finalproject_intern.viewmodels.ViewModle;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {
    TextView viewall1,viewall2,viewall4,viewall3;
    ImageView categories,man;
    RecyclerView myRecycler;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    ViewModle productViewModel,productViewModel2,productViewModel3,productViewModel4;
    SearchView searchView;
    ProgressDialog progressDialog;
    ProductCAstomadapter productCAstomadapteer,productCAstomadapteerall;
    ElctronesAdpter elctronesAdpter;
    MensAdapter mensAdapter;
    WomenAdapter womenAdapter;
    JwelareAdapter jwelareAdapter;
    BottomNavigationView bottomNavigationView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intent=new Intent(this,Catagoryes.class);
        categories=findViewById(R.id.categories);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        searchView=findViewById(R.id.search);
        myRecycler = findViewById(R.id.rec1);
        recyclerView1=findViewById(R.id.rec2);
        recyclerView2=findViewById(R.id.rec3);
        recyclerView3=findViewById(R.id.rec4);
//        textView = findViewById(R.id.numb);


        man=findViewById(R.id.man);
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Profile.class));
            }
        });

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,SearchActivity.class));
            }
        });

        viewall1=findViewById(R.id.viewall1);
        viewall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Alljewlaryactivity.class));
            }
        });

        viewall2=findViewById(R.id.viewall2);
        viewall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Allmenproduct.class));
            }
        });
        viewall3=findViewById(R.id.viewall3);
        viewall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Allelctronecproduct.class));
            }
        });



        viewall4=findViewById(R.id.viewall4);
        viewall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Allwomenproduct.class));
            }
        });





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
                       return true;
                   }
                   case R.id.navigation:{

                       startActivity(new Intent(getApplicationContext(),Notivigation.class));
                       overridePendingTransition(0,0);
                       return true;}
               }
               return false;
           }
       });








        productViewModel = new ViewModelProvider(this).get(ViewModle.class);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(Home.this,LinearLayoutManager.HORIZONTAL,false);
//        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
//        RecyclerView.LayoutManager layoutManager3=new LinearLayoutManager(Home.this,LinearLayoutManager.HORIZONTAL,false);
//        RecyclerView.LayoutManager layoutManager4=new LinearLayoutManager(Home.this,LinearLayoutManager.HORIZONTAL,false);
          productViewModel.getjeweleryproduct(this).observe(this, ProductModels -> {
            jwelareAdapter = new JwelareAdapter(Home.this,ProductModels);
            myRecycler.setAdapter(jwelareAdapter);
            myRecycler.setLayoutManager(layoutManager1);
//




//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    productCAstomadapteer.getFilter().filter(newText);
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

        });







            RecyclerView.LayoutManager layoutManager2=new LinearLayoutManager(Home.this,LinearLayoutManager.HORIZONTAL,false);
            productViewModel2 = new ViewModelProvider(this).get(ViewModle.class);
            productViewModel2.getmensproduct(this).observe(this, ProductModels -> {
            mensAdapter = new MensAdapter(Home.this,ProductModels);
            recyclerView1.setAdapter(mensAdapter);
            recyclerView1.setLayoutManager(layoutManager2);
            recyclerView1.setHasFixedSize(true);



//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    productCAstomadapteer.getFilter().filter(newText);
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

        });








        RecyclerView.LayoutManager layoutManager3=new LinearLayoutManager(Home.this,LinearLayoutManager.HORIZONTAL,false);
        productViewModel3 = new ViewModelProvider(this).get(ViewModle.class);
        productViewModel3.getelectronics(this).observe(this, ProductModels -> {
            elctronesAdpter = new ElctronesAdpter(Home.this,ProductModels);
            recyclerView2.setAdapter(elctronesAdpter);
            recyclerView2.setLayoutManager(layoutManager3);
            recyclerView2.setHasFixedSize(true);



//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    productCAstomadapteer.getFilter().filter(newText);
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

        });






        RecyclerView.LayoutManager layoutManager4=new LinearLayoutManager(Home.this,LinearLayoutManager.HORIZONTAL,false);
        productViewModel3 = new ViewModelProvider(this).get(ViewModle.class);
        productViewModel3.getwomenproduct(this).observe(this, ProductModels -> {
            womenAdapter = new WomenAdapter(Home.this,ProductModels);
            recyclerView3.setAdapter(womenAdapter);
            recyclerView3.setLayoutManager(layoutManager4);
            recyclerView3.setHasFixedSize(true);

        });


    }







    }





