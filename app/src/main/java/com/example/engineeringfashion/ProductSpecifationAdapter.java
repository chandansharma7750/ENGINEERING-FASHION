package com.example.engineeringfashion;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ProductSpecifationAdapter extends RecyclerView.Adapter<ProductSpecifationAdapter.ViewHolder> {
    List<ProductSpecificationModel> productSpecificationModelList;

    public ProductSpecifationAdapter(List<ProductSpecificationModel> productSpecificationModelList) {
        this.productSpecificationModelList = productSpecificationModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (productSpecificationModelList.get(position).getType()){
            case 0:
                return ProductSpecificationModel.SPECIFICATION_TITLE;
            case 1:
                return ProductSpecificationModel.SPECIFICATION_BODY;
                default:
                    return -1;
        }
    }

    @NonNull
    @Override


    public ProductSpecifationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case ProductSpecificationModel.SPECIFICATION_TITLE:
                TextView title=new TextView(viewGroup.getContext());
                title.setTypeface(null, Typeface.BOLD);
                title.setTextColor(Color.parseColor("#ffffff"));
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(setdp(16,viewGroup.getContext()),setdp(16,viewGroup.getContext()),setdp(16,viewGroup.getContext()),setdp(8,viewGroup.getContext()));
                title.setLayoutParams(layoutParams);
                return new ViewHolder(title);

            case ProductSpecificationModel.SPECIFICATION_BODY:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.productspecificationlayout,viewGroup,false);
                return new ViewHolder(view);

            default:
                    return null;


        }

    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecifationAdapter.ViewHolder viewHolder, int i) {
        switch (productSpecificationModelList.get(i).getType()){
            case ProductSpecificationModel.SPECIFICATION_TITLE:
                String title=productSpecificationModelList.get(i).getTitle();
                viewHolder.setTitle(title);
                break;
                case ProductSpecificationModel.SPECIFICATION_BODY:
                    String name=productSpecificationModelList.get(i).getFeaturename();
                    String value=productSpecificationModelList.get(i).getFeaturevalue();
                    viewHolder.setproduct(name,value);
                    break;
                    default:
                        return;
        }


    }

    @Override
    public int getItemCount() {
        return productSpecificationModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView featurename;
        TextView featurevalues;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
        public void setTitle(String titles){
            title= (TextView) itemView;
            title.setText(titles);
        }
        public void setproduct(String name,String value){
            featurename=itemView.findViewById(R.id.feature_name);
            featurevalues=itemView.findViewById(R.id.feature_value);
            featurevalues.setText(value);
            featurename.setText(name);
        }


    }
    public int setdp(int dp, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }

}
