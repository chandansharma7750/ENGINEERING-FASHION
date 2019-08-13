package com.example.engineeringfashion;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {
    List<Cartitemmodel> cartitemmodelList;

    public CartAdapter(List<Cartitemmodel> cartitemmodelList) {
        this.cartitemmodelList = cartitemmodelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartitemmodelList.get(position).getType()) {
            case 0:
                return Cartitemmodel.CART_ITEM;
            case 1:
                return Cartitemmodel.TOTAL_PRICE;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case Cartitemmodel.CART_ITEM:
                View cartitemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout, viewGroup, false);
                return new CartitemViewholder(cartitemview);
            case Cartitemmodel.TOTAL_PRICE:
                View totalpriceview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout, viewGroup, false);
                return new TotalitemDetailsViewHolder(totalpriceview);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (cartitemmodelList.get(i).getType()) {
            case Cartitemmodel.CART_ITEM:
                int resource = cartitemmodelList.get(i).getProductimage();
                String title = cartitemmodelList.get(i).getProductTitle();
                int freecoupenno = cartitemmodelList.get(i).getFreecoupen();
                String productprice = cartitemmodelList.get(i).getProductPrice();
                String cuttedprice = cartitemmodelList.get(i).getCuttedprice();
                int offerapplied = cartitemmodelList.get(i).getOfferaplied();
                ((CartitemViewholder) viewHolder).setitemsdetails(resource, title, freecoupenno, productprice, cuttedprice, offerapplied);


                break;
            case Cartitemmodel.TOTAL_PRICE:
                String totalampount = cartitemmodelList.get(i).getTotalamount();
                String totalitems = cartitemmodelList.get(i).getTotalitems();
                String deliverycharge = cartitemmodelList.get(i).getDeliveryprice();
                String totalitemprice = cartitemmodelList.get(i).getTotalitemPrice();
                String savemoney = cartitemmodelList.get(i).getSavedmoney();
                ((TotalitemDetailsViewHolder) viewHolder).settotalitemdata(totalampount, totalitems, deliverycharge, totalitemprice, savemoney);


                break;
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return cartitemmodelList.size();
    }

public     class CartitemViewholder extends RecyclerView.ViewHolder {

        private ImageView productimage;
        private TextView producttitle;
        private TextView freecoupen;
        private ImageView freecounpenicon;
        private TextView productPrice;
        private TextView cuttedProductPrice;
        private TextView productquntity;
        private TextView offerapplied;
        private TextView coupenapplied;


        public CartitemViewholder(@NonNull View itemView) {
            super(itemView);
            productimage = itemView.findViewById(R.id.product_image);
            producttitle = itemView.findViewById(R.id.product_title);
            freecoupen = itemView.findViewById(R.id.tv_free_coupen);
            freecounpenicon = itemView.findViewById(R.id.free_coupen_icon);
            offerapplied = itemView.findViewById(R.id.offer_applied);
            productPrice = itemView.findViewById(R.id.product_price);
            cuttedProductPrice = itemView.findViewById(R.id.cutted_price);
            productquntity = itemView.findViewById(R.id.product_quantity);
            coupenapplied = itemView.findViewById(R.id.coupen_applied);
        }

        private void setitemsdetails(int resource, String title, int freecoupenno, String productprice, String cuttedprice, int offerappliedno) {
            productimage.setImageResource(resource);
            producttitle.setText(title);
//            productPrice.setText(productprice);
            if (freecoupenno > 0) {
                freecounpenicon.setVisibility(View.VISIBLE);
                freecoupen.setVisibility(View.VISIBLE);
                if (freecoupenno == 1) {
                    freecoupen.setText("Free " + freecoupenno + " coupen");
                } else {
                    freecoupen.setText("Free " + freecoupenno + " coupens");
                }

            } else {
                freecoupen.setVisibility(View.INVISIBLE);
                freecounpenicon.setVisibility(View.INVISIBLE);
            }

            cuttedProductPrice.setText(cuttedprice);
            if (offerappliedno > 0) {
                offerapplied.setVisibility(View.VISIBLE);
                offerapplied.setText(offerappliedno + " offers applied");

            } else {
                offerapplied.setVisibility(View.INVISIBLE);
            }


        }
    }

    class TotalitemDetailsViewHolder extends RecyclerView.ViewHolder {
        private TextView total_items;
        private TextView total_items_price;
        private TextView deliverycharge;
        private TextView totalamount;
        private TextView savedmoney;

        public TotalitemDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            total_items = itemView.findViewById(R.id.total_items);
            total_items_price = itemView.findViewById(R.id.total_items_prices);
            deliverycharge = itemView.findViewById(R.id.delivery_charge);
            totalamount = itemView.findViewById(R.id.total_price);
            savedmoney = itemView.findViewById(R.id.saved_amount);
        }

        public void settotalitemdata(String totalamountt, String totalitem, String deliverycharges, String totalitemprice, String savemoney) {
            totalamount.setText(totalamountt);
            total_items.setText(totalitem);
            deliverycharge.setText(deliverycharges);
            total_items_price.setText(totalitemprice);
            savedmoney.setText(savemoney);
        }


    }
}
