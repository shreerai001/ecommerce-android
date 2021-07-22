package com.shree.ecom.activityMyCart;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.utils.values.CartEntity;
import com.shree.ecom.activityWhishlist.view.CancelWishlistActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {
    private List<CartEntity> cartEntityList;
    private Context context;
    private BaseCart baseCart;

    public MyCartAdapter(List<CartEntity> cartEntityList, Context context, BaseCart baseCart) {
        this.cartEntityList = cartEntityList;
        this.context = context;
        this.baseCart = baseCart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_my_wishlist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.name_v.setText(cartEntityList.get(i).getProductName());
        Picasso.with(context).load(cartEntityList.get(i).getImage()).into(viewHolder.productImage_v);
        viewHolder.date_v.setText(cartEntityList.get(i).getCompany());
        viewHolder.name_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), CancelWishlistActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id", String.valueOf(cartEntityList.get(i).getId()));
                context.startActivity(intent);
            }
        });
        viewHolder.removeFromCart_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseCart.deleteFromCart(Integer.parseInt(cartEntityList.get(i).getProductId()));
                Toast.makeText(context, "Product removed from cart", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartEntityList.size();
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
        Button removeFromCart_v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
