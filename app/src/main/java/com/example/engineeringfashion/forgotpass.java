package com.example.engineeringfashion;


import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import javax.annotation.Nullable;


/**
 * A simple {@link Fragment} subclass.
 */
public class forgotpass extends Fragment {
 EditText recoveryid;
 TextView textView3,goback;
 Button submit;
 ProgressBar forgotprogressbar;
 FirebaseAuth firebaseAuth;
 FrameLayout parent;

    public forgotpass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_forgotpass, container, false);
        recoveryid=view.findViewById(R.id.recoryid);
        textView3=view.findViewById(R.id.textView3);
        submit=view.findViewById(R.id.submit);
        goback=view.findViewById(R.id.goback);
        parent=getActivity().findViewById(R.id.Register_framelayout);
        forgotprogressbar=view.findViewById(R.id.forgotprogressBar);
        firebaseAuth=firebaseAuth.getInstance();
        return view;

    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        recoveryid.addTextChangedListener(new TextWatcher() {
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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit.setEnabled(false);
                firebaseAuth.sendPasswordResetEmail(recoveryid.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            textView3.setText("Email has send successfully");
                            textView3.setTextColor(Color.GREEN);

                            Toast.makeText(getActivity(),"email sent successfully",Toast.LENGTH_LONG).show();


                        }
                        else{

                            textView3.setText(task.getException().getMessage());
                            textView3.setTextColor(Color.RED);

                            forgotprogressbar.setVisibility(View.INVISIBLE);
                        }
                    }
                });

            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setfragment(new loginfrag());
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
    private  void checkinput(){
        if (!TextUtils.isEmpty(recoveryid.getText())){
           submit.setAlpha(1f);
           submit.setEnabled(true);
        }
        else{
            submit.setAlpha(0.3f);
            submit.setEnabled(false);
        }
    }
    private void setfragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getFragmentManager().beginTransaction();
        //fragmentTransaction.setCustomAnimations(R.anim.signuptologin,R.anim.logintosignup);
        fragmentTransaction.replace(parent.getId(),fragment);
        fragmentTransaction.commit();

    }
}

