package com.example.engineeringfashion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
private RecyclerView categoryrecycleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);///this will show back button
        String title = getIntent().getStringExtra("categoryname");
        getSupportActionBar().setTitle(title);
//        categoryrecycleview.findViewById(R.id.categoryrecycleview);

///////

        List<Slider_moder> slider_moderList = new ArrayList<Slider_moder>();


        slider_moderList.add(new Slider_moder(R.drawable.e));
        slider_moderList.add(new Slider_moder(R.drawable.f));


        slider_moderList.add(new Slider_moder(R.drawable.a));
        slider_moderList.add(new Slider_moder(R.drawable.b));
        slider_moderList.add(new Slider_moder(R.drawable.c));
        slider_moderList.add(new Slider_moder(R.drawable.d));
        slider_moderList.add(new Slider_moder(R.drawable.e));
        slider_moderList.add(new Slider_moder(R.drawable.f));

        slider_moderList.add(new Slider_moder(R.drawable.a));
        slider_moderList.add(new Slider_moder(R.drawable.b));


        ///////
////////ad

        List<Dealoftheday_model> dealoftheday_modelArrayList = new ArrayList<>();
        dealoftheday_modelArrayList.add(new Dealoftheday_model(R.drawable.poco, "POCO F1", "SD 845", "199999/-"));

        dealoftheday_modelArrayList.add(new Dealoftheday_model(R.drawable.poco, "POCO F1", "SD 845", "199999/-"));
        dealoftheday_modelArrayList.add(new Dealoftheday_model(R.drawable.poco, "POCO F1", "SD 845", "199999/-"));
        dealoftheday_modelArrayList.add(new Dealoftheday_model(R.drawable.poco, "POCO F1", "SD 845", "199999/-"));
        dealoftheday_modelArrayList.add(new Dealoftheday_model(R.drawable.poco, "POCO F1", "SD 845", "199999/-"));
        dealoftheday_modelArrayList.add(new Dealoftheday_model(R.drawable.poco, "POCO F1", "SD 845", "199999/-"));

        ////////////Recycle view testing
        categoryrecycleview= findViewById(R.id.categoryrecycleview);
        LinearLayoutManager testinglayoutmanager = new LinearLayoutManager(this);
        testinglayoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryrecycleview.setLayoutManager(testinglayoutmanager);
        List<Homepagemodel> homepagemodelList=new ArrayList<>();
        homepagemodelList.add(new Homepagemodel(0,slider_moderList));

       // homepagemodelList.add(new Homepagemodel(1,R.drawable.e,"#000000"));
        homepagemodelList.add(new Homepagemodel(2,"Deal of the day",dealoftheday_modelArrayList));
        homepagemodelList.add(new Homepagemodel(1,R.drawable.b,"#000000"));
        homepagemodelList.add(new Homepagemodel(3,"Trending",dealoftheday_modelArrayList));

        homepagemodelList.add(new Homepagemodel(0,slider_moderList));
        Homepageadapter adapter = new Homepageadapter(homepagemodelList);
        categoryrecycleview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.searchicon, menu);
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
        }
        else if (id==android.R.id.home){
            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
