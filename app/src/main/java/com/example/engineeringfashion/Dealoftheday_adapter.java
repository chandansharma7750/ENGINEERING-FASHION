package com.example.engineeringfashion;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Dealoftheday_adapter extends RecyclerView.Adapter<Dealoftheday_adapter.ViewHolder> {
    public Dealoftheday_adapter(List<Dealoftheday_model> dealoftheday_modelList) {
        this.dealoftheday_modelList = dealoftheday_modelList;
    }

    private List<Dealoftheday_model> dealoftheday_modelList;
    @NonNull
    @Override
    public Dealoftheday_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dealoftheday_recycleview_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dealoftheday_adapter.ViewHolder viewHolder, int i) {
int image=dealoftheday_modelList.get(i).getProductimage();
String name=dealoftheday_modelList.get(i).getProductname();
String price=dealoftheday_modelList.get(i).getProductprice();
String discription=dealoftheday_modelList.get(i).getProductdiscription();

viewHolder.setProductimage(image);
viewHolder.setProductname(name);
        viewHolder.setProductdiscription(discription);
viewHolder.setProductprice(price);
    }

    @Override
    public int getItemCount() {

        if (dealoftheday_modelList.size() > 8) {
            return 8;
        }
        else{
            return dealoftheday_modelList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productimage1;
        TextView productname;
        TextView Productdiscription;
        TextView productprice;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

           productimage1 =itemView.findViewById(R.id.dealoftheday_image);
            productprice =itemView.findViewById(R.id.dealoftheday_price);
            Productdiscription =itemView.findViewById(R.id.dealoftheday_description);
            productname =itemView.findViewById(R.id.daeloftheday_productname);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(),Productdetail.class);
                    itemView.getContext().startActivity(intent);

                }
            });

        }
        private  void setProductimage(int name){
            productimage1.setImageResource(name);
        }
        private  void setProductprice(String price){
            productprice.setText(price);
        }
        private  void setProductdiscription(String discription){
            Productdiscription.setText(discription);
        }
        private  void setProductname(String name){
            productname.setText(name);
        }
    }
}
