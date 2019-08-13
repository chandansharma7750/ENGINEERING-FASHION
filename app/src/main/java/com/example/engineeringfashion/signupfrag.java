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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class signupfrag extends Fragment {


    public signupfrag() {
        // Required empty public constructor
    }
private EditText email2,pass2,confirmpass,name;
    private Button signup;
    private ImageButton closee;
private TextView textView1;
private FirebaseAuth firebaseAuth;

String emailcheck="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    private FrameLayout parentframelayout;
    ProgressBar signupprogressBar;
    FirebaseFirestore firebaseFirestore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_signupfrag, container, false);
        textView1=view.findViewById(R.id.haveaccount);
        parentframelayout=getActivity().findViewById(R.id.Register_framelayout);
        email2=view.findViewById(R.id.email2);
        pass2=view.findViewById(R.id.pass2);
        confirmpass=view.findViewById(R.id.confirmpass);
        signup=view.findViewById(R.id.signup);
        name=view.findViewById(R.id.name);
        firebaseAuth=firebaseAuth.getInstance();
        signupprogressBar=view.findViewById(R.id.singupprogressBar);
        firebaseFirestore=firebaseFirestore.getInstance();
       closee=view.findViewById(R.id.closee);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setfragment(new loginfrag());

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
checkemailandpass();
            }
        });
        closee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),main.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        email2.addTextChangedListener(new TextWatcher() {
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
        pass2.addTextChangedListener(new TextWatcher() {
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
        name.addTextChangedListener(new TextWatcher() {
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
        confirmpass.addTextChangedListener(new TextWatcher() {
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
    }
    private void checkinput()
    {
        if (!TextUtils.isEmpty(email2.getText()))
        {
            if(!TextUtils.isEmpty(name.getText())){
                if (!TextUtils.isEmpty(pass2.getText())&&pass2.length()>=8){
                    if (!TextUtils.isEmpty(confirmpass.getText())){
                        signup.setEnabled(true);
                        signup.setAlpha(1);

                    }
                    else{
                        signup.setEnabled(false);
                        signup.setAlpha(0.3f);

                    }
                }
                else{
                    signup.setEnabled(false);
                    signup.setAlpha(0.3f);


                }

            }
            else{
                signup.setEnabled(false);
                signup.setAlpha(0.3f);

            }
        }
        else{
            signup.setEnabled(false);
            signup.setAlpha(0.3f);

        }
    }
    private  void checkemailandpass()
    {
        if(email2.getText().toString().matches(emailcheck)){
            if(pass2.getText().toString().equals(confirmpass.getText().toString())){
                signupprogressBar.setVisibility(View.VISIBLE);
                signup.setEnabled(false);
firebaseAuth.createUserWithEmailAndPassword(email2.getText().toString(),pass2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            Map<Object,String> userdata=new HashMap<>();
            userdata.put("name",name.getText().toString());
            firebaseFirestore.collection("USERDATA").add(userdata).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                @Override
                public void onComplete(@NonNull Task<DocumentReference> task) {
                    if (task.isSuccessful()){
                        Intent intent=new Intent(getActivity(),main.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                    else{
                        signupprogressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(getActivity(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        signup.setEnabled(true);
                    }
                }
            });


        }else{
            signupprogressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(getActivity(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
            signup.setEnabled(true);
        }
    }
});
            }
            else{
                confirmpass.setError("Please enter same password");

            }
        }
        else{
email2.setError("Please enter Valid Email");
        }

    }

    private void setfragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getActivity().getFragmentManager().beginTransaction();
       // fragmentTransaction.setCustomAnimations(R.anim.logintosignup, R.anim.signuptologin);
        fragmentTransaction.replace(parentframelayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
