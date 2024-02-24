package com.example.finalproject_intern.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.finalproject_intern.R;
import com.example.finalproject_intern.ui.adapters.JwelareAdapter;
import com.example.finalproject_intern.ui.adapters.MensAdapter;
import com.example.finalproject_intern.viewmodels.ViewModle;

public class Alljewlaryactivity extends AppCompatActivity {
    TextView textView;
    RecyclerView myRecycler;
    ViewModle productViewModel;
    SearchView searchView;
    ProgressDialog progressDialog;
    JwelareAdapter productCAstomadapteer;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alljewlaryactivity);

        back=findViewById(R.id.arrow_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alljewlaryactivity.this,Home.class));
            }
        });

        searchView=findViewById(R.id.search_bar);
        myRecycler = findViewById(R.id.rec1);
        textView = findViewById(R.id.numb);



        productViewModel = new ViewModelProvider(this).get(ViewModle.class);
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        productViewModel.getjeweleryproduct(this).observe(this, heroModels -> {
            productCAstomadapteer = new JwelareAdapter(Alljewlaryactivity.this,heroModels);
            myRecycler.setAdapter(productCAstomadapteer);
            myRecycler.setLayoutManager(staggeredGridLayoutManager);
            textView.setText("Founded "+productCAstomadapteer.getItemCount());

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    productCAstomadapteer.getFilter().filter(newText);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("Founded "+productCAstomadapteer.getItemCount());
                        }
                    }, 1000);

                    return false;
                }
            });

        });
    }
}