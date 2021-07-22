package com.shree.ecom.home.view.adapter;

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
import com.shree.ecom.activityProductDetail.view.ProductDetailActivity;
import com.shree.ecom.home.model.dto.FeaturedProductDto;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * this adapter adapts view for product on home view
 */
public class HomeFeaturedAdapter extends RecyclerView.Adapter<HomeFeaturedAdapter.ViewHolder> {


    private List<FeaturedProductDto> homeLatestDtoArrayList;
    private Context context_dco;

    public HomeFeaturedAdapter(List<FeaturedProductDto> productsArrayList, Context context_dco) {
        this.homeLatestDtoArrayList = productsArrayList;
        this.context_dco = context_dco;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_featured, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Picasso.with(context_dco).load(homeLatestDtoArrayList.get(i).getImage()).into(viewHolder.menuIcon_v);
        viewHolder.menuIconName_v.setText(homeLatestDtoArrayList.get(i).getName());
        viewHolder.menuIconPrice_v.setText(homeLatestDtoArrayList.get(i).getDescription());
        viewHolder.rel_feature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context_dco.getApplicationContext(), ProductDetailActivity.class);
                intent.putExtra("name", homeLatestDtoArrayList.get(i).getName());
                intent.putExtra("description", homeLatestDtoArrayList.get(i).getDescription());
                intent.putExtra("company", homeLatestDtoArrayList.get(i).getManufacture_company());
                intent.putExtra("cyear", homeLatestDtoArrayList.get(i).getManufacture_year());
                intent.putExtra("location", homeLatestDtoArrayList.get(i).getLocation());
                intent.putExtra("created", homeLatestDtoArrayList.get(i).getCreated_at());
                intent.putExtra("updated", homeLatestDtoArrayList.get(i).getUpdated_at());
                intent.putExtra("slug", homeLatestDtoArrayList.get(i).getSlug());
                intent.putExtra("name", homeLatestDtoArrayList.get(i).getName());
                intent.putExtra("pic", homeLatestDtoArrayList.get(i).getImage());
                intent.putExtra("id", String.valueOf(homeLatestDtoArrayList.get(i).getId()));

                context_dco.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeLatestDtoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon_name)
        TextView menuIconName_v;

        @BindView(R.id.icon)
        ImageView menuIcon_v;

        @BindView(R.id.rel_card_feature)
        RelativeLayout rel_feature;

        @BindView(R.id.icon_price)
        TextView menuIconPrice_v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
