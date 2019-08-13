package com.example.engineeringfashion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ProductdetailAdadpter extends FragmentPagerAdapter {
    private int totaltab;

    public ProductdetailAdadpter(FragmentManager fm, int totaltab) {
        super(fm);
        this.totaltab = totaltab;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                Product_Description product_description = new Product_Description();
                return product_description;
            case 1:
                Product_Specification product_specification = new Product_Specification();
                return product_specification;
            case 2:
                Product_Description product_description1 = new Product_Description();
                return product_description1;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totaltab;
    }
}
