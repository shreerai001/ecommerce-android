package com.shree.ecom.activityBrowse.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductDataDto;
import com.shree.ecom.activityBrowse.view.activity.UsedEquipmentActivity;
import com.shree.ecom.activityProductDetail.view.ProductDetailActivity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsedEquipmentAdapter extends RecyclerView.Adapter<UsedEquipmentAdapter.ViewHolder> {

    private List<UsedProductDataDto> usedProductDataDtos;
    // private List<UsedProductImgsDto> usedProductImgsDtos;
    private Context context_dco;
    private UsedEquipmentActivity usedEquipmentActivity;

    public UsedEquipmentAdapter(List<UsedProductDataDto> usedProductDataDtos, Context context_dco, UsedEquipmentActivity usedEquipmentActivity) {
        this.usedProductDataDtos = usedProductDataDtos;
        this.context_dco = context_dco;
        this.usedEquipmentActivity = usedEquipmentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_browse_equipment_all_product, viewGroup, false);
        return new UsedEquipmentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        viewHolder.equipmentDescription_v.setText(usedProductDataDtos.get(i).getName());
        viewHolder.equipmentModel_v.setText(usedProductDataDtos.get(i).getModel());
        viewHolder.equipmentName_v.setText(usedProductDataDtos.get(i).getName());
        viewHolder.price_v.setText(context_dco.getResources().getString(R.string.Rs) + " " + usedProductDataDtos.get(i).getPrice());
        Picasso.with(context_dco).load(usedProductDataDtos.get(i).getImg()).into(viewHolder.equipmentImage_v);

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context_dco.getApplicationContext(), ProductDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name", usedProductDataDtos.get(i).getName());
                intent.putExtra("pic", usedProductDataDtos.get(i).getImg());

                // products detail
                intent.putExtra("description", usedProductDataDtos.get(i).getDescription());
                intent.putExtra("company", usedProductDataDtos.get(i).getManufacture_company());
                intent.putExtra("cyear", usedProductDataDtos.get(i).getManufacture_year());
                intent.putExtra("location", usedProductDataDtos.get(i).getLocation());
                intent.putExtra("updated", usedProductDataDtos.get(i).getUpdated_at());
                intent.putExtra("created", usedProductDataDtos.get(i).getCreated_at());
                intent.putExtra("slug", usedProductDataDtos.get(i).getSlug());
                intent.putExtra("stuckqty", usedProductDataDtos.get(i).getStock_qty());
                intent.putExtra("stuck", usedProductDataDtos.get(i).getStock());
                intent.putExtra("name", usedProductDataDtos.get(i).getName());

                Bundle args = new Bundle();
                args.putSerializable("Images", (Serializable) usedProductDataDtos.get(viewHolder.getAdapterPosition()).getImgs());
                intent.putExtra("Images", args);

                intent.putExtra("id", String.valueOf(usedProductDataDtos.get(i).getId()));
                context_dco.startActivity(intent);
            }
        });
        viewHolder.wishlistIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usedEquipmentActivity.addToWishlist(String.valueOf(usedProductDataDtos.get(i).getId()));
            }
        });

    }


    @Override
    public int getItemCount() {
        if (usedProductDataDtos == null) {
            return 0;
        } else {
            return usedProductDataDtos.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.equipment_image)
        ImageView equipmentImage_v;

        @BindView(R.id.equipment_name)
        TextView equipmentName_v;

        @BindView(R.id.equipment_model)
        TextView equipmentModel_v;

        @BindView(R.id.equipment_description)
        TextView equipmentDescription_v;

        @BindView(R.id.relative_cardAll)
        RelativeLayout relativeLayout;

        @BindView(R.id.price)
        TextView price_v;

        @BindView(R.id.wishlist_icon)
        ImageView wishlistIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
