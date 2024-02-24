package com.example.finalproject_intern.viewmodels;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.finalproject_intern.repo.remotedata.productModel.ProductModel;
import com.example.finalproject_intern.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModle extends ViewModel {

    private MutableLiveData<List<ProductModel>> productList;
    public MutableLiveData<List<ProductModel>> getproduct(Context ctx) {

        if (productList == null) {
            productList = new MutableLiveData<>();
            loadproduct(ctx);
        }
        return productList;

    }


    private MutableLiveData<List<ProductModel>> productListelectronics;
    public MutableLiveData<List<ProductModel>> getelectronics(Context ctx) {

        if (productListelectronics == null) {
            productListelectronics = new MutableLiveData<>();
            loadelectronics(ctx);
        }
        return productListelectronics;

    }


    private MutableLiveData<List<ProductModel>> productList_mens;
    public MutableLiveData<List<ProductModel>> getmensproduct(Context ctx) {

        if (productList_mens == null) {
            productList_mens = new MutableLiveData<>();
            loadmens(ctx);
        }
        return productList_mens;

    }



    private MutableLiveData<List<ProductModel>> productList_women;
    public MutableLiveData<List<ProductModel>> getwomenproduct(Context ctx) {

        if (productList_women == null) {
            productList_women = new MutableLiveData<>();
            loadwomen(ctx);
        }
        return productList_women;

    }


    private MutableLiveData<List<ProductModel>> productList_jewelery;
    public MutableLiveData<List<ProductModel>> getjeweleryproduct(Context ctx) {

        if (productList_jewelery == null) {
            productList_jewelery = new MutableLiveData<>();
            loadjewelery(ctx);
        }
        return productList_jewelery;

    }

    private void loadproduct(Context ctx) {
        ProgressDialog progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("on fetching");
        progressDialog.setMessage("loading your data");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
//        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                progressDialog.dismiss();//dismiss dialog
//            }
//        });
        progressDialog.setCancelable(false);
        progressDialog.show();
        Call<List<ProductModel>> call = RetrofitClient.getInstance().getMyApi().getproduct();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ctx, "" + response.code(), Toast.LENGTH_SHORT).show();
                } else {
                    productList.setValue(response.body());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Toast.makeText(ctx, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
    private void loadmens (Context ctx){
        ProgressDialog progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("on fetching");
        progressDialog.setMessage("loading your data");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
//        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                progressDialog.dismiss();//dismiss dialog
//            }
//        });
        progressDialog.setCancelable(false);
        progressDialog.show();
        Call<List<ProductModel>> call = RetrofitClient.getInstance().getMyApi().getmens();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ctx, "" + response.code(), Toast.LENGTH_SHORT).show();
                } else {
                    productList_mens.setValue(response.body());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Toast.makeText(ctx, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void loadelectronics (Context ctx){
        ProgressDialog progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("on fetching");
        progressDialog.setMessage("loading your data");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
//        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                progressDialog.dismiss();//dismiss dialog
//            }
//        });
        progressDialog.setCancelable(false);
        progressDialog.show();
        Call<List<ProductModel>> call = RetrofitClient.getInstance().getMyApi().getelctrons();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ctx, "" + response.code(), Toast.LENGTH_SHORT).show();
                } else {
                    productListelectronics.setValue(response.body());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Toast.makeText(ctx, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void loadwomen (Context ctx){
        ProgressDialog progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("on fetching");
        progressDialog.setMessage("loading your data");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
//        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                progressDialog.dismiss();//dismiss dialog
//            }
//        });
        progressDialog.setCancelable(false);
        progressDialog.show();
        Call<List<ProductModel>> call = RetrofitClient.getInstance().getMyApi().getwomen();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ctx, "" + response.code(), Toast.LENGTH_SHORT).show();
                } else {
                    productList_women.setValue(response.body());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Toast.makeText(ctx, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void loadjewelery (Context ctx){
        ProgressDialog progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("on fetching");
        progressDialog.setMessage("loading your data");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
//        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                progressDialog.dismiss();//dismiss dialog
//            }
//        });
        progressDialog.setCancelable(false);
        progressDialog.show();
        Call<List<ProductModel>> call = RetrofitClient.getInstance().getMyApi().getjewelery();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ctx, "" + response.code(), Toast.LENGTH_SHORT).show();
                } else {
                    productList_jewelery.setValue(response.body());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Toast.makeText(ctx, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}