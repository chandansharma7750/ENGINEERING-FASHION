package com.example.engineeringfashion;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ProductimagelayoutAdapter extends PagerAdapter{
    List<Integer> productimages;

    public ProductimagelayoutAdapter(List<Integer> productimages) {
        this.productimages = productimages;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView productimage=new ImageView(container.getContext());
        productimage.setImageResource(productimages.get(position));
        container.addView(productimage,0);
        return productimage;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }

    @Override
    public int getCount() {
        return productimages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }
}
