package com.example.engineeringfashion;

public class Dealoftheday_model {
    private int productimage;
    private String productname;
    private String productdiscription;
    private String productprice;

    public Dealoftheday_model(int productimage, String productname, String productdiscription, String productprice) {
        this.productimage = productimage;
        this.productname = productname;
        this.productdiscription = productdiscription;
        this.productprice = productprice;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdiscription() {
        return productdiscription;
    }

    public void setProductdiscription(String productdiscription) {
        this.productdiscription = productdiscription;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
