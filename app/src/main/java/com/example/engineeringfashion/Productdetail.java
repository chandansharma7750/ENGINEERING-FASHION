package com.example.engineeringfashion;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Productdetail extends AppCompatActivity {
    private ViewPager productimgeviewpager;
    private TabLayout productimageindicator;
    private FloatingActionButton addtowishlist;
    private static boolean alreadyaddedtowishlist = false;
    private ViewPager productDetailViewpager;
    private TabLayout productDetailtabLayout;
    /////////// Rating layout

    LinearLayout ratinglayoutcontainer;
    ///////////rating layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);///this will show back button
        getSupportActionBar().setTitle(null);
        productimageindicator = findViewById(R.id.productimageindicator);
        productimgeviewpager = findViewById(R.id.productimageviewpager);
        productDetailtabLayout = findViewById(R.id.productdetailtablayout);
        productDetailViewpager = findViewById(R.id.productdetail_viewpager);
        addtowishlist = findViewById(R.id.addtowishlist);
        List<Integer> productimage = new ArrayList<>();
        productimage.add(R.drawable.poco);
        productimage.add(R.drawable.ic_menu_manage);
        productimage.add(R.drawable.poco);
        productimage.add(R.drawable.ic_menu_share);
        ProductimagelayoutAdapter productimagelayoutAdapter = new ProductimagelayoutAdapter(productimage);
        productimgeviewpager.setAdapter(productimagelayoutAdapter);
        productimageindicator.setupWithViewPager(productimgeviewpager, true);

        addtowishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alreadyaddedtowishlist) {
                    alreadyaddedtowishlist = false;
                    //     addtowishlist.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("9e9e9e")));
                    addtowishlist.setSupportImageTintList(getResources().getColorStateList(R.color.gray));

                } else {
                    alreadyaddedtowishlist = true;
                    addtowishlist.setSupportImageTintList(getResources().getColorStateList(R.color.red));

                }
            }
        });
        productDetailViewpager.setAdapter(new ProductdetailAdadpter(getSupportFragmentManager(), productDetailtabLayout.getTabCount()));
        productDetailViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailtabLayout));
        productDetailtabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ///////rating
        ratinglayoutcontainer = findViewById(R.id.rate_now_container);
        for (int x = 0; x < ratinglayoutcontainer.getChildCount(); x++) {
            final int starposition = x;
            ratinglayoutcontainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    setrating(starposition);
                }
            });
        }

        /////////rating
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setrating(int starposition) {
    for (int x=0;x<ratinglayoutcontainer.getChildCount();x++){
        ImageView startbtn=(ImageView) ratinglayoutcontainer.getChildAt(x);
        startbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
        if (x<=starposition){
            startbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
        }
    }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.searchandcart, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        } else if (id == android.R.id.home) {
            finish();
            return true;

        } else if (id == R.id.action_cart) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
