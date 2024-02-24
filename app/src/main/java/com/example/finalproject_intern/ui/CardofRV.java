package com.example.finalproject_intern.ui;

public class CardofRV {
    public static String getTital;
    private int image;
    private String tital;
    private String  descrip;

    public CardofRV( String tital, String descrip) {

        this.tital = tital;
        this.descrip = descrip;}

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTital() {
        return tital;
    }

    public void setTital(String tital) {
        this.tital = tital;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
