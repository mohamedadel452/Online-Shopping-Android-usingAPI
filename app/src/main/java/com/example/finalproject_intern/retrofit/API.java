package com.example.finalproject_intern.retrofit;

import com.example.finalproject_intern.repo.remotedata.productModel.CatagoresModel;
import com.example.finalproject_intern.repo.remotedata.productModel.ProductModel;
import com.example.finalproject_intern.repo.remotedata.productModel.ProductsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = " https://fakestoreapi.com/";
    @GET("products")
    Call<List<ProductModel>> getproduct();

    @GET("products/category/men's clothing")
    Call<List<ProductModel>> getmens();

    @GET("products/category/electronics")
    Call<List<ProductModel>> getelctrons();


    @GET("products/category/women's clothing")
    Call<List<ProductModel>> getwomen();

    @GET("products/category/jewelery")
    Call<List<ProductModel>> getjewelery();

    @GET("products/categories")
    Call<List<String>> getcatagory();



}
