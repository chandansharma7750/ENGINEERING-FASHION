package com.example.engineeringfashion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class my_cart extends Fragment {


    public my_cart() {
        // Required empty public constructor
    }
private RecyclerView cartitemREcycleview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_cart, container, false);
        cartitemREcycleview=view.findViewById(R.id.cart_item_recycleview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartitemREcycleview.setLayoutManager(layoutManager);
        List<Cartitemmodel> cartitemmodelList =new ArrayList<>();
        cartitemmodelList.add(new Cartitemmodel(0,R.drawable.poco,"POCO F1",2,"Rs.19999/-","Rs.21000/-",2,2,1));
        cartitemmodelList.add(new Cartitemmodel(0,R.drawable.poco,"POCO F1",0,"Rs.19999/-","Rs.21000/-",2,2,1));
        cartitemmodelList.add(new Cartitemmodel(0,R.drawable.poco,"POCO F1",0,"Rs.19999/-","Rs.21000/-",0,0,1));
        cartitemmodelList.add(new Cartitemmodel(0,R.drawable.poco,"POCO F1",1,"Rs.19999/-","Rs.21000/-",0,0,1));
        cartitemmodelList.add(new Cartitemmodel(0,R.drawable.poco,"POCO F1",0,"Rs.19999/-","Rs.21000/-",2,2,0));
        cartitemmodelList.add(new Cartitemmodel(0,R.drawable.poco,"POCO F1",3,"Rs.19999/-","Rs.21000/-",2,2,0));
        cartitemmodelList.add( new Cartitemmodel(1,"2","250000/-","free","Rs.24000", "RS.250000"));
        CartAdapter cartAdapter=new CartAdapter(cartitemmodelList);
        cartitemREcycleview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        return view;

    }

}
