package com.example.engineeringfashion;

public class Cartitemmodel {
    public static final int CART_ITEM=0;
    public static final int TOTAL_PRICE=1;
    private  int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    //////
    private int Productimage;
    private String productTitle;
    private int freecoupen;
    private String ProductPrice;
    private String cuttedprice;
    private int Productquntity;
    private int offeraplied;
    private int coupenapplied;



    public int getProductimage() {
        return Productimage;
    }

    public void setProductimage(int productimage) {
        Productimage = productimage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreecoupen() {
        return freecoupen;
    }

    public void setFreecoupen(int freecoupen) {
        this.freecoupen = freecoupen;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public String getCuttedprice() {
        return cuttedprice;
    }

    public void setCuttedprice(String cuttedprice) {
        this.cuttedprice = cuttedprice;
    }

    public int getProductquntity() {
        return Productquntity;
    }

    public void setProductquntity(int productquntity) {
        Productquntity = productquntity;
    }

    public int getOfferaplied() {
        return offeraplied;
    }

    public void setOfferaplied(int offeraplied) {
        this.offeraplied = offeraplied;
    }

    public int getCoupenapplied() {
        return coupenapplied;
    }

    public void setCoupenapplied(int coupenapplied) {
        this.coupenapplied = coupenapplied;
    }
    public Cartitemmodel(int type, int productimage, String productTitle, int freecoupen, String ProductPrice, String cuttedprice, int productquntity, int offeraplied, int coupenapplied) {
        this.type = type;
        this.Productimage = productimage;
        this.productTitle = productTitle;
        this.freecoupen = freecoupen;
        this.ProductPrice = ProductPrice;
        this.cuttedprice = cuttedprice;
        this.Productquntity = productquntity;
        this.offeraplied = offeraplied;
        this.coupenapplied = coupenapplied;
    }
    ////////
    //////totalprice
    private String totalitems;
    private String totalitemPrice;
    private String deliveryprice;
    private String Savedmoney;
    private String totalamount;

    public String getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(String totalitems) {
        this.totalitems = totalitems;
    }

    public String getTotalitemPrice() {
        return totalitemPrice;
    }

    public void setTotalitemPrice(String totalitemPrice) {
        this.totalitemPrice = totalitemPrice;
    }

    public String getDeliveryprice() {
        return deliveryprice;
    }

    public void setDeliveryprice(String deliveryprice) {
        this.deliveryprice = deliveryprice;
    }

    public String getSavedmoney() {
        return Savedmoney;
    }

    public void setSavedmoney(String savedmoney) {
        Savedmoney = savedmoney;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public Cartitemmodel(int type, String totalitems, String totalitemPrice, String deliveryprice, String savedmoney, String totalamount) {
        this.type = type;
        this.totalitems = totalitems;
        this.totalitemPrice = totalitemPrice;
        this.deliveryprice = deliveryprice;
        Savedmoney = savedmoney;
        this.totalamount = totalamount;
    }

    ////////tp
}
