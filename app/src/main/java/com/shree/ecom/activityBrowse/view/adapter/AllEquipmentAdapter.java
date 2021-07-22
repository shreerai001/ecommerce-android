package com.shree.ecom.activityBrowse.view.adapter;

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
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductDto;
import com.shree.ecom.activityBrowse.view.activity.AllEquipmentProductActivity;
import com.shree.ecom.activityProductDetail.view.ProductDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllEquipmentAdapter extends RecyclerView.Adapter<AllEquipmentAdapter.ViewHolder> {

    private List<AllEquipmentProductDto> equipmentProductDtoList;
    private Context context_dco;
    private AllEquipmentProductActivity allEquipmentProductActivity;

    public AllEquipmentAdapter(List<AllEquipmentProductDto> equipmentProductDtoList, Context context_dco, AllEquipmentProductActivity allEquipmentProductActivity) {
        this.equipmentProductDtoList = equipmentProductDtoList;
        this.context_dco = context_dco;
        this.allEquipmentProductActivity = allEquipmentProductActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_browse_equipment_all_product, viewGroup, false);
        return new AllEquipmentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.equipmentDescription_v.setText(equipmentProductDtoList.get(i).getName());
        viewHolder.equipmentModel_v.setText(equipmentProductDtoList.get(i).getModel());
        viewHolder.equipmentName_v.setText(equipmentProductDtoList.get(i).getName());
        viewHolder.price_v.setText(context_dco.getResources().getString(R.string.Rs) + " " + equipmentProductDtoList.get(i).getPrice());
        Picasso.with(context_dco).load(equipmentProductDtoList.get(i).getImg()).into(viewHolder.equipmentImage_v);
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context_dco.getApplicationContext(), ProductDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name", equipmentProductDtoList.get(i).getName());
                intent.putExtra("pic", equipmentProductDtoList.get(i).getImg());
                intent.putExtra("id", String.valueOf(equipmentProductDtoList.get(i).getId()));
                intent.putExtra("sale_price", equipmentProductDtoList.get(i).getSale_price());
                intent.putExtra("model", equipmentProductDtoList.get(i).getModel());
                intent.putExtra("description", equipmentProductDtoList.get(i).getDescription());
                intent.putExtra("company", equipmentProductDtoList.get(i).getManufacture_company());
                intent.putExtra("cyear", equipmentProductDtoList.get(i).getManufacture_year());
                intent.putExtra("location", equipmentProductDtoList.get(i).getLocation());
                intent.putExtra("created", equipmentProductDtoList.get(i).getCreated_at());
                intent.putExtra("updated", equipmentProductDtoList.get(i).getUpdated_at());
                intent.putExtra("slug", equipmentProductDtoList.get(i).getSlug());
            //    intent.putExtra("pic", equipmentProductDtoList.get(i).getImage());
                context_dco.startActivity(intent);
            }
        });
        /**
         * adding all equipment to wishlist
         */
        viewHolder.wishlistIcon_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allEquipmentProductActivity.addToWishlist(String.valueOf(equipmentProductDtoList.get(i).getId()));
            }
        });

    }

    @Override
    public int getItemCount() {
        if (equipmentProductDtoList == null) {
            return 0;
        } else {
            return equipmentProductDtoList.size();
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
        ImageView wishlistIcon_v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
