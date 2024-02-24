package com.example.finalproject_intern.viewmodels;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.finalproject_intern.repo.remotedata.productModel.CatagoresModel;
import com.example.finalproject_intern.repo.remotedata.productModel.ProductModel;

import com.example.finalproject_intern.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatagoresViewmodel extends ViewModel {
    private MutableLiveData<List<String>> productList;


    public MutableLiveData<List<String>>getcatagory(Context ctx){

        if(productList == null){
            productList = new MutableLiveData<>();
            loadproduct(ctx);
        }



        return productList;

    }

    private void loadproduct(Context ctx){
        ProgressDialog progressDialog=new ProgressDialog(ctx);
        progressDialog.setTitle("on fetching");
        progressDialog.setMessage("loading your data");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.dismiss();//dismiss dialog
            }
        });
        progressDialog.setCancelable(false);
        progressDialog.show();

        Call<List<String>> call = RetrofitClient.getInstance().getMyApi().getcatagory();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(ctx, ""+response.code(), Toast.LENGTH_SHORT).show();
                    Log.e("errorName", ""+response.code());

                }else {
                    List<String> productsResponse = response.body();
                    assert productsResponse != null;

                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(ctx, ""+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("errorName", ""+t.getMessage());

            }
        });

    }


}
