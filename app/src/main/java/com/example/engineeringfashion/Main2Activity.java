package com.example.engineeringfashion;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;



public class Main2Activity extends AppCompatActivity {
FrameLayout frameLayout;
public static boolean forgot1=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        frameLayout=findViewById(R.id.Register_framelayout);
        setfragment();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if(forgot1){
                forgot1=false;
                setfragment();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @SuppressLint("ResourceType")
    private void setfragment() {

        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();//fragment transaction is used to add replace or remove a fragment.
        //whereas fragment maneger is use to manage diffrent fragment
        fragmentTransaction.replace(frameLayout.getId(),new loginfrag());
        fragmentTransaction.commit();
    }

}
