package com.example.finalproject_intern.repo.remotedata.productModel;

public class CatagoresModel {

    public class Rating{
        public double rate;
        public int count;
    }

        public String category;
        public String image;
        public Rating rating;

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
}
