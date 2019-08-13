package com.example.engineeringfashion;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class gridlayout_adapter extends BaseAdapter {
    public gridlayout_adapter(List<Dealoftheday_model> dealoftheday_modelList) {
        this.dealoftheday_modelList = dealoftheday_modelList;
    }

    List<Dealoftheday_model> dealoftheday_modelList;
    @Override

    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;
        if (convertView==null){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dealoftheday_recycleview_layout,null);
            view.setBackgroundColor(Color.parseColor("#000000"));
            ImageView imageView=view.findViewById(R.id.dealoftheday_image);
            TextView name=view.findViewById(R.id.daeloftheday_productname);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(parent.getContext(),Productdetail.class);
                    parent.getContext().startActivity(intent);
                }
            });

            TextView discription=view.findViewById(R.id.dealoftheday_description);
            TextView price=view.findViewById(R.id.dealoftheday_price);
            imageView.setImageResource(dealoftheday_modelList.get(position).getProductimage());
            name.setText(dealoftheday_modelList.get(position).getProductname());
            discription.setText(dealoftheday_modelList.get(position).getProductdiscription());
            price.setText(dealoftheday_modelList.get(position).getProductprice());
        }
        else{
view=convertView;
        }
        return view;
    }
}
