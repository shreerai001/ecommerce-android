package com.shree.ecom.activityWhishlist.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activityWhishlist.model.dto.WishlistDataEntity;
import com.shree.ecom.activityWhishlist.service.Cancel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyWishlistAdapter extends RecyclerView.Adapter<MyWishlistAdapter.ViewHolder> {
    private List<WishlistDataEntity> wishlistEntityList;
    private Context context;
    private Cancel cancel;

    public MyWishlistAdapter(List<WishlistDataEntity> wishlistEntityList, Context context, Cancel cancel) {
        this.wishlistEntityList = wishlistEntityList;
        this.context = context;
        this.cancel = cancel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_my_wishlist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Picasso.with(context).load(wishlistEntityList.get(i).getProduct_image()).into(viewHolder.productImage_v);
        viewHolder.date_v.setText(wishlistEntityList.get(i).getDate());
        viewHolder.price_v.setText(wishlistEntityList.get(i).getProduct_price());
        viewHolder.name_v.setText(wishlistEntityList.get(i).getProduct_name());
        viewHolder.productImage_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), CancelWishlistActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("price", wishlistEntityList.get(i).getProduct_price());
                intent.putExtra("pic", wishlistEntityList.get(i).getProduct_image());
                intent.putExtra("id", String.valueOf(wishlistEntityList.get(i).getId()));
                context.startActivity(intent);
            }
        });
        viewHolder.cancelWishlist_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel.cancelWishList(String.valueOf(wishlistEntityList.get(i).getProduct_id()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return wishlistEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.order_product_image)
        ImageView productImage_v;

        @BindView(R.id.order_status)
        TextView orderStatus_v;

        @BindView(R.id.order_date)
        TextView date_v;

        @BindView(R.id.price)
        TextView price_v;

        @BindView(R.id.discount_on_order)
        TextView name_v;

        @BindView(R.id.order_relative)
        RelativeLayout orderRelativeLayout_v;

        @BindView(R.id.cancelWishlist)
        Button cancelWishlist_v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
