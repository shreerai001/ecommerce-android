package com.shree.ecom.similarProducts.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activityProductDetail.view.ProductDetailActivity;
import com.shree.ecom.similarProducts.model.dto.SimilarProductsEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimilarProductsAdapter extends RecyclerView.Adapter<SimilarProductsAdapter.ViewHolder> {
    private List<SimilarProductsEntity> similarProductsEntityList;
    private Context context;

    public SimilarProductsAdapter(List<SimilarProductsEntity> similarProductsEntityList, Context context) {
        this.similarProductsEntityList = similarProductsEntityList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_similar_products, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Picasso.with(context).load(similarProductsEntityList.get(i).getImg()).into(viewHolder.similarProduct_v);
        viewHolder.product_name.setText(similarProductsEntityList.get(i).getName());
        viewHolder.sales_prices.setText(similarProductsEntityList.get(i).getSale_price() + "");
        viewHolder.total_prices.setText(similarProductsEntityList.get(i).getPrice() + "");

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), ProductDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name", similarProductsEntityList.get(i).getName());
                intent.putExtra("pic", similarProductsEntityList.get(i).getImg());
                intent.putExtra("id", String.valueOf(similarProductsEntityList.get(i).getId()));
                intent.putExtra("price", similarProductsEntityList.get(i).getPrice());
                intent.putExtra("sellPrice", similarProductsEntityList.get(i).getSale_price());
                intent.putExtra("condition", similarProductsEntityList.get(i).getCondition());
                intent.putExtra("maufactureCompany", similarProductsEntityList.get(i).getManufacture_company());
                intent.putExtra("tax", similarProductsEntityList.get(i).getTax());
                intent.putExtra("stockqty", similarProductsEntityList.get(i).getStock_qty());
                intent.putExtra("updateAt", similarProductsEntityList.get(i).getUpdated_at());
                intent.putExtra("model", similarProductsEntityList.get(i).getModel());
                intent.putExtra("description", similarProductsEntityList.get(i).getDescription());
                intent.putExtra("company", similarProductsEntityList.get(i).getManufacture_company());
                intent.putExtra("cyear", similarProductsEntityList.get(i).getManufacture_year());
                intent.putExtra("location", similarProductsEntityList.get(i).getLocation());
                intent.putExtra("created", similarProductsEntityList.get(i).getCreated_at());
                intent.putExtra("updated", similarProductsEntityList.get(i).getUpdated_at());
                intent.putExtra("slug", similarProductsEntityList.get(i).getSlug());
                context.startActivity(intent);
            }
        });
        viewHolder.total_prices.setPaintFlags(viewHolder.total_prices.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        if (similarProductsEntityList == null) {
            return 0;
        } else {

            return similarProductsEntityList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.similar_product_image)
        ImageView similarProduct_v;

        @BindView(R.id.p_name)
        TextView product_name;
        @BindView(R.id.sales_price)
        TextView sales_prices;

        @BindView(R.id.total_price)
        TextView total_prices;

        @BindView(R.id.linearlayout)
        LinearLayout linearLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
