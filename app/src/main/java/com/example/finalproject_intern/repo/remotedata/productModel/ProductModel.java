package com.example.finalproject_intern.repo.remotedata.productModel;

import java.util.ArrayList;

public class ProductModel {
    public class Rating{
        public double rate;
        public int count;
    }

    public ProductModel(ProductModel productModel){
        this.title = productModel.title;
        this.price = productModel.getPrice();
        this.description = productModel.getDescription();
        this.category =productModel.getCategory();
        this.image = productModel.getImage();
    }

    public ProductModel( String title, double price, String description, String image) {

        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;

    }

    public int id;
        public String title;
        public double price;
        public String description;
        public String category;
        public String image;
        public Rating rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    //    public class Category{
//        public int id;
//        public String name;
//        public String image;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getImage() {
//            return image;
//        }
//
//        public void setImage(String image) {
//            this.image = image;
//        }
//    }
//
//
//        public int id;
//        public String title;
//        public int price;
//        public String description;
//        public Category category;
//        public ArrayList<String> images;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public int getPrice() {
//            return price;
//        }
//
//        public void setPrice(int price) {
//            this.price = price;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public Category getCategory() {
//            return category;
//        }
//
//        public void setCategory(Category category) {
//            this.category = category;
//        }
//
//        public ArrayList<String> getImages() {
//            return images;
//        }
//
//        public void setImages(ArrayList<String> images) {
//            this.images = images;
//        }





























//    public int id;
//    public String title;
//    public String description;
//    public int price;
//    public double discountPercentage;
//    public double rating;
//    public int stock;
//    public String brand;
//    public String category;
//    public String thumbnail;
//    public ArrayList<String> images;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public double getDiscountPercentage() {
//        return discountPercentage;
//    }
//
//    public void setDiscountPercentage(double discountPercentage) {
//        this.discountPercentage = discountPercentage;
//    }
//
//    public double getRating() {
//        return rating;
//    }
//
//    public void setRating(double rating) {
//        this.rating = rating;
//    }
//
//    public int getStock() {
//        return stock;
//    }
//
//    public void setStock(int stock) {
//        this.stock = stock;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public String getThumbnail() {
//        return thumbnail;
//    }
//
//    public void setThumbnail(String thumbnail) {
//        this.thumbnail = thumbnail;
//    }
//
//    public ArrayList<String> getImages() {
//        return images;
//    }
//
//    public void setImages(ArrayList<String> images) {
//        this.images = images;
//    }
}
