package com.example.engineeringfashion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    private Intent intent;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);
        firebaseAuth=firebaseAuth.getInstance();
        iv.animate().alpha(0f).setDuration(3000);
     // intent =new Intent(   MainActivity.this,com.example.engineeringfashion.Main2Activity.class);
        FirebaseUser currentuser = firebaseAuth.getCurrentUser();//this line of code is used to store the info of current user
        if (currentuser == null) {
            intent = new Intent(MainActivity.this, com.example.engineeringfashion.Main2Activity.class);


        } if (currentuser!=null){
            intent = new Intent(MainActivity.this, main.class);


        }
        Thread timwer=new Thread(){
            public void run(){
                try {
                    sleep(3000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timwer.start();
    }

    @Override
    protected void onStart() {//onstart() is come into play when the activity just started.
        super.onStart();

    }

}
