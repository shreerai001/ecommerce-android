package com.shree.ecom.home.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activityProductDetail.view.ProductDetailActivity;
import com.shree.ecom.home.model.dto.ProductsEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * this adapter adapts view for product on home view
 */
public class HomeLatestAdapter extends RecyclerView.Adapter<HomeLatestAdapter.ViewHolder> {


    private List<ProductsEntity> homeLatestDtoArrayList;
    private Context context_dco;

    public HomeLatestAdapter(List<ProductsEntity> productsArrayList, Context context_dco) {
        this.homeLatestDtoArrayList = productsArrayList;
        this.context_dco = context_dco;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_latest, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        Picasso.with(context_dco).load(homeLatestDtoArrayList.get(i).getImage()).into(viewHolder.menuIcon_v);
        viewHolder.menuIconName_v.setText(homeLatestDtoArrayList.get(i).getName());
        viewHolder.txt_sales_price.setText(context_dco.getResources().getString(R.string.Rs) + " " + homeLatestDtoArrayList.get(i).getSale_price());
        viewHolder.txt_total_price.setText(context_dco.getResources().getString(R.string.Rs) + " " + homeLatestDtoArrayList.get(i).getPrice());

        viewHolder.txt_total_price.setPaintFlags(viewHolder.txt_total_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        viewHolder.relativeLayoutLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context_dco.getApplicationContext(), ProductDetailActivity.class);

                intent.putExtra("description", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getDescription());
                intent.putExtra("company", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getManufacture_company());
                intent.putExtra("cyear", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getManufacture_year());
                intent.putExtra("location", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getLocation());
                intent.putExtra("updated", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getUpdated_at());
                intent.putExtra("created", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getCreated_at());
                intent.putExtra("slug", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getSlug());
                intent.putExtra("stuckqty", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getStock_qty());
                intent.putExtra("stuck", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getStock());
                intent.putExtra("name", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getName());
                intent.putExtra("pic", homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getImage());
                intent.putExtra("id", String.valueOf(homeLatestDtoArrayList.get(viewHolder.getAdapterPosition()).getId()));

                context_dco.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i("product Size", "" + homeLatestDtoArrayList.size());
        return homeLatestDtoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon_name)
        TextView menuIconName_v;

        @BindView(R.id.icon)
        ImageView menuIcon_v;

        @BindView(R.id.sales_price)
        TextView txt_sales_price;

        @BindView(R.id.total_price)
        TextView txt_total_price;

        @BindView(R.id.rel_latest)
        RelativeLayout relativeLayoutLatest;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
