package com.example.engineeringfashion;

import java.util.List;

public class Homepagemodel {
    private  int type;
    public static final int Banner_slider=0;
    public static final int stripad=1;
    public static final int dealoftheday=2;
    public static final int gridlayout=3;
    ////////banner slider
    List<Slider_moder> slider_moderList;

    public Homepagemodel(int type, List<Slider_moder> slider_moderList) {
        this.type = type;
        this.slider_moderList = slider_moderList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Slider_moder> getSlider_moderList() {
        return slider_moderList;
    }

    public void setSlider_moderList(List<Slider_moder> slider_moderList) {
        this.slider_moderList = slider_moderList;
    }
////////banner slider

    /////stripad
    private int resource;
    private String backgroundcolor;

    public Homepagemodel(int type, int resource, String backgroundcolor) {
        this.type = type;
        this.resource = resource;
        this.backgroundcolor = backgroundcolor;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }
    //////stripad
///////deal of the day
    private String title;
    private List<Dealoftheday_model> dealoftheday_modelList;

    public Homepagemodel(int type, String title, List<Dealoftheday_model> dealoftheday_modelList) {
        this.type = type;
        this.title = title;
        this.dealoftheday_modelList = dealoftheday_modelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Dealoftheday_model> getDealoftheday_modelList() {
        return dealoftheday_modelList;
    }

    public void setDealoftheday_modelList(List<Dealoftheday_model> dealoftheday_modelList) {
        this.dealoftheday_modelList = dealoftheday_modelList;
    }
    //////dealofthe day

}

