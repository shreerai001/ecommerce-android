package com.shree.ecom.activityMyOrders.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activityCancelOrders.CancelOrderActivity;
import com.shree.ecom.activityMyOrders.model.dto.MyOrdersDataEntity;
import com.shree.ecom.activityMyOrders.model.dto.OrderProductsEntity;
import com.shree.ecom.activityMyOrders.views.MyOrdersActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.ViewHolder> {
    private List<MyOrdersDataEntity> myOrdersDataEntityList;
    private Context context;
    private MyOrdersActivity myOrdersActivity;

    public MyOrdersAdapter(List<MyOrdersDataEntity> myOrdersDataEntityList, Context context, MyOrdersActivity myOrdersActivity) {
        this.myOrdersDataEntityList = myOrdersDataEntityList;
        this.context = context;
        this.myOrdersActivity = myOrdersActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_my_orders, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.orderDate_v.setText(myOrdersDataEntityList.get(i).getOrder_date());
        String image = null;
        for (OrderProductsEntity orderProductsEntity : myOrdersDataEntityList.get(i).getOrderProducts()) {
            viewHolder.orderPrice_v.setText(orderProductsEntity.getPrice());
            image = orderProductsEntity.getImg();
            Picasso.with(context).load(orderProductsEntity.getImg()).into(viewHolder.productImage_v);
        }
        viewHolder.orderStatus_v.setText(myOrdersDataEntityList.get(i).getOrder_status());
        final String finalImage = image;
        viewHolder.orderRelativeLayout_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), CancelOrderActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("month_price", viewHolder.orderPrice_v.getText().toString());
                intent.putExtra("pic", finalImage);
                intent.putExtra("id", String.valueOf(myOrdersDataEntityList.get(i).getId()));
                intent.putExtra("status", myOrdersDataEntityList.get(i).getOrder_status());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myOrdersDataEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.order_product_image)
        ImageView productImage_v;

        @BindView(R.id.order_status)
        TextView orderStatus_v;

        @BindView(R.id.order_date)
        TextView orderDate_v;

        @BindView(R.id.price)
        TextView orderPrice_v;

        @BindView(R.id.discount_on_order)
        TextView orderDiscount_v;

        @BindView(R.id.order_relative)
        RelativeLayout orderRelativeLayout_v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
