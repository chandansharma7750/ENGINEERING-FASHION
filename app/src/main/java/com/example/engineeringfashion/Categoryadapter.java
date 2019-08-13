package com.example.engineeringfashion;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Categoryadapter extends RecyclerView.Adapter<Categoryadapter.ViewHolder> {
    private ArrayList<items> itemsList;

    public Categoryadapter(Context context,ArrayList<items> itemsList) {
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public Categoryadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categary_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Categoryadapter.ViewHolder viewHolder, int position) {

String iron=itemsList.get(position).getCategoryiconlinkl();
String name=itemsList.get(position).getCategoryname();
viewHolder.setCategory(name,position);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
       private ImageView categaryiron;
       private TextView  categaryname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categaryiron=itemView.findViewById(R.id.category_icon);
            categaryname=itemView.findViewById(R.id.categary_name);
        }
        private  void setCategaryiron(){

        }
        private  void setCategory(final String name, final int position){
            categaryname.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position != 0) {
                        Intent category = new Intent(itemView.getContext(), CategoryActivity.class);
                        category.putExtra("categoryname", name);
                        itemView.getContext().startActivity(category);
                    }
                }
            });
        }
    }
}
