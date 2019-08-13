package com.example.engineeringfashion;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.engineeringfashion.Main2Activity.forgot1;

public class loginfrag extends Fragment {
private EditText email1,pass1;
TextView forgot;
Button login;
private TextView textView;
private FrameLayout parentfraamelayout,forgotpassword;
 private  FirebaseAuth firebaseAuth;
private  ImageButton close;
    String emailcheck="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    private ProgressBar loginprogressbar;
    public loginfrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_loginfrag, container, false);
        textView=view.findViewById(R.id.donothaveaccount);
        parentfraamelayout=getActivity().findViewById(R.id.Register_framelayout);
       // forgotpassword=getActivity().findViewById(R.id.forgotpass);
        email1=view.findViewById(R.id.email1);
        pass1=view.findViewById(R.id.pass1);
        login=view.findViewById(R.id.login);
        forgot=view.findViewById(R.id.forgotpass);
        firebaseAuth=firebaseAuth.getInstance();
        loginprogressbar=view.findViewById(R.id.loginprogressBar);
        close=view.findViewById(R.id.close);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setfragment(new signupfrag());
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgot1=true;
                FragmentTransaction fragmentTransaction=getActivity().getFragmentManager().beginTransaction();
                fragmentTransaction.replace(parentfraamelayout.getId(),new forgotpass());
                fragmentTransaction.commit();
            }
        });
        email1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              checkinput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        pass1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             checkinput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkemailandpassword();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),main.class);
                startActivity(intent);
                getActivity().finish();

            }
        });
    }
 private void checkinput(){
        if (!TextUtils.isEmpty(email1.getText())){
            if ((!TextUtils.isEmpty(pass1.getText()))){
                login.setEnabled(true);
                login.setAlpha(1);

            }
            else{
                login.setEnabled(false);
                login.setAlpha(0.3f);
            }

        }
        else{
            login.setEnabled(false);
            login.setAlpha(0.3f);
        }
 }
 private void checkemailandpassword(){
        if (email1.getText().toString().matches(emailcheck)){
            if (pass1.length()>=8){
                loginprogressbar.setVisibility(View.VISIBLE);
                login.setEnabled(false);
                login.setAlpha(0.3f);
                firebaseAuth.signInWithEmailAndPassword(email1.getText().toString(),pass1.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent=new Intent(getActivity(),main.class);
                            startActivity(intent);
                            getActivity().finish();

                        }
                        else{
                            Toast.makeText(getActivity(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            loginprogressbar.setVisibility(View.INVISIBLE);
                            login.setEnabled(true);
                            login.setAlpha(1);

                        }
                    }
                });
            }else{
Toast.makeText(getActivity(),"Wrong email or password",Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(getActivity(),"Wrong email or password",Toast.LENGTH_LONG).show();
        }
 }

    private void setfragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getFragmentManager().beginTransaction();
        //fragmentTransaction.setCustomAnimations(R.anim.signuptologin,R.anim.logintosignup);
         fragmentTransaction.replace(parentfraamelayout.getId(),fragment);
        fragmentTransaction.commit();

    }
/*private void setfragments(){
        FragmentTransaction fragmentTransaction=getActivity().getFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentfraamelayout.getId(),new forgotpassword());
        fragmentTransaction.commit();
}*/
}

