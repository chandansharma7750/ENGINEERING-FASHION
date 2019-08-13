package com.example.engineeringfashion;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class Slider_adapter extends PagerAdapter {
  private   List<Slider_moder> slidermoderList;

    public Slider_adapter(List<Slider_moder> slider_moderList) {
        this.slidermoderList = slider_moderList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {//this method is same as View holder in the normal adapder....used to create page for given position
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.slider_layout,container,false);
        ImageView banner=view.findViewById(R.id.ab);
        banner.setImageResource(slidermoderList.get(position).getBanner());
        container.addView(view,0);
        return view ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return slidermoderList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
