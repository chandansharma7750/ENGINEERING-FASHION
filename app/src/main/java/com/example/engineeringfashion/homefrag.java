package com.example.engineeringfashion;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
public class homefrag extends Fragment {


    public homefrag() {
        // Required empty public constructor
    }

    private RecyclerView category;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<items> itemsList;
   private RecyclerView categoryrecycleview;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_homefrag, container, false);

        category = view.findViewById(R.id.recycleview);
        category.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        category.setLayoutManager(layoutManager);
        itemsList = new ArrayList<items>();
        itemsList.add(new items("adasdas", "home"));
        itemsList.add(new items("adasdas", "Shoes"));
        itemsList.add(new items("adasdas", "Mobile"));
        itemsList.add(new items("adasdas", "Earphone"));
        itemsList.add(new items("adasdas", "Laptop"));
        itemsList.add(new items("adasdas", "Jeans"));
        itemsList.add(new items("adasdas", "Shirts"));
        itemsList.add(new items("adasdas", "T-shirt"));

        adapter = new Categoryadapter(getActivity(), itemsList);
        category.setAdapter(adapter);
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
        categoryrecycleview = view.findViewById(R.id.homepagerecycleview);
        LinearLayoutManager testinglayoutmanager = new LinearLayoutManager(getContext());
        categoryrecycleview.setLayoutManager(testinglayoutmanager);
        testinglayoutmanager.setOrientation(LinearLayoutManager.VERTICAL);

List<Homepagemodel> homepagemodelList=new ArrayList<>();
homepagemodelList.add(new Homepagemodel(0,slider_moderList));

        homepagemodelList.add(new Homepagemodel(1,R.drawable.e,"#000000"));
        homepagemodelList.add(new Homepagemodel(2,"Deal of the day",dealoftheday_modelArrayList));
        homepagemodelList.add(new Homepagemodel(1,R.drawable.b,"#000000"));
        homepagemodelList.add(new Homepagemodel(3,"Trending",dealoftheday_modelArrayList));

        homepagemodelList.add(new Homepagemodel(0,slider_moderList));
        Homepageadapter adapter = new Homepageadapter(homepagemodelList);
        categoryrecycleview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ////////////Recycle view testing

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
