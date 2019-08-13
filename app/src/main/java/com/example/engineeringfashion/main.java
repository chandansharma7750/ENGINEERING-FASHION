package com.example.engineeringfashion;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FrameLayout frameLayoutmain;
    private static final int HOME_FRAG = 0;
    private static final int CART_FRAG = 1;
    private static int currentfrag;
    NavigationView navigationView;
    private TextView tootbartitle_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tootbartitle_tv=findViewById(R.id.tootbar_tv_title);

        getSupportActionBar().setDisplayShowTitleEnabled(false);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        frameLayoutmain = findViewById(R.id.main_framelayout);
        setfragment(new homefrag(), 0);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentfrag == HOME_FRAG) {
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        } else if (id == R.id.action_cart) {
            mycart();
            return true;
        } else if (id == R.id.action_bell) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void mycart() {
        tootbartitle_tv.setText("MY CART");
        invalidateOptionsMenu();//this menu will re run oncreateoptionmenu and then we can delete the icon from the troolbar
        setfragment(new my_cart(), CART_FRAG);
        navigationView.getMenu().getItem(1).setChecked(true);

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.enginneringfashion) {
            invalidateOptionsMenu();
            tootbartitle_tv.setText("ENGINEERING FASHION");
            setfragment(new homefrag(), HOME_FRAG);

        } else if (id == R.id.myaccount) {

            // Handle the camera action
        } else if (id == R.id.mycart) {
            mycart();

        } else if (id == R.id.myorder) {

        } else if (id == R.id.myaccount) {

        } else if (id == R.id.creater) {

        } else if (id == R.id.singout) {

        }


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setfragment(Fragment fragment, int fragmentno) {
        currentfrag = fragmentno;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayoutmain.getId(), fragment);
        fragmentTransaction.commit();

    }
}
