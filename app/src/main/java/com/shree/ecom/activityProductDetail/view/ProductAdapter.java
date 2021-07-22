package com.shree.ecom.activityProductDetail.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationDataDto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductRecommendationDataDto> productRecommendationDataDtoList = new ArrayList<>();
    private Context context;

    public ProductAdapter(List<ProductRecommendationDataDto> productRecommendationDataDtoList, Context context) {
        this.productRecommendationDataDtoList = productRecommendationDataDtoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_latest, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Picasso.with(context).load(productRecommendationDataDtoList.get(i).getSimilarProducts().get(i).getImg());
    }

    @Override
    public int getItemCount() {
        return productRecommendationDataDtoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.product_recommendation_name)
        TextView productRecommendation;

        @BindView(R.id.product_recommendation_image)
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
