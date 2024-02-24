package com.example.finalproject_intern.repo.remotedata.productModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;

public class ProductsResponse {
        List<CatagoresModel> products;

        public ProductsResponse(List<CatagoresModel> products) {
                this.products = products;
        }
        public ProductsResponse() {

        }

        public List<CatagoresModel> getcatagory() {
                return products;
        }

        public void setProducts(List<CatagoresModel> products) {
                this.products = products;
        }
}
