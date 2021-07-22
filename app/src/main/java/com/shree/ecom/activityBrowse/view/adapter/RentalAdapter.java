package com.shree.ecom.activityBrowse.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalCartDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalDataDto;
import com.shree.ecom.activityBrowse.view.activity.RentalEquipmentActivity;
import com.shree.ecom.activityProductDetail.view.ProductDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RentalAdapter extends RecyclerView.Adapter<RentalAdapter.ViewHolder> {
    private List<RentalDataDto> rentalDataDtoList;
    private Context context_dco;
    private RentalEquipmentActivity rentalEquipmentActivity;

    public RentalAdapter(List<RentalDataDto> rentalDataDtoList, Context context_dco, RentalEquipmentActivity rentalEquipmentActivity) {
        this.rentalDataDtoList = rentalDataDtoList;
        this.context_dco = context_dco;
        this.rentalEquipmentActivity = rentalEquipmentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_browse_equipment, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.equipmentDescription_v.setText(rentalDataDtoList.get(i).getName());
        viewHolder.equipmentModel_v.setText(rentalDataDtoList.get(i).getModel());
        viewHolder.equipmentName_v.setText(rentalDataDtoList.get(i).getName());
        Picasso.with(context_dco).load(rentalDataDtoList.get(i).getImg()).into(viewHolder.equipmentImage_v);
        viewHolder.viewButton_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context_dco.getApplicationContext(), ProductDetailActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("name", rentalDataDtoList.get(i).getName());
                intent.putExtra("day_price", rentalDataDtoList.get(i).getDay_price());
                intent.putExtra("hour_price", rentalDataDtoList.get(i).getHour_price());
                intent.putExtra("month_price", rentalDataDtoList.get(i).getMonth_price());
                intent.putExtra("pic", rentalDataDtoList.get(i).getImg());
                intent.putExtra("description", rentalDataDtoList.get(i).getCondition());
                intent.putExtra("company", rentalDataDtoList.get(i).getManufacture_company());
                intent.putExtra("cyear", rentalDataDtoList.get(i).getManufacture_year());
                intent.putExtra("location", rentalDataDtoList.get(i).getLocation());
                intent.putExtra("updated", rentalDataDtoList.get(i).getUpdated_at());
                intent.putExtra("created", rentalDataDtoList.get(i).getCreated_at());
                intent.putExtra("slug", rentalDataDtoList.get(i).getSlug());
                intent.putExtra("name", rentalDataDtoList.get(i).getName());

                intent.putExtra("id", String.valueOf(rentalDataDtoList.get(i).getId()));
                context_dco.startActivity(intent);
            }
        });
        viewHolder.addToCartButton_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * adding rental equipment on cart
                 **/
                RentalCartDto rentalCartDto = new RentalCartDto(
                        rentalDataDtoList.get(i).getId(),
                        rentalDataDtoList.get(i).getManufacture_company(),
                        rentalDataDtoList.get(i).getName(),
                        rentalDataDtoList.get(i).getUser_id(),
                        rentalDataDtoList.get(i).getModel(),
                        rentalDataDtoList.get(i).getBrand_id(),
                        rentalDataDtoList.get(i).getImg()
                );
                rentalEquipmentActivity.addRentalCart(rentalCartDto);
            }
        });
        /**
         * adding rental equipment to wishlist
         */
        viewHolder.wishlistImageView_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rentalEquipmentActivity.addToWishlist(String.valueOf(rentalDataDtoList.get(i).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (rentalDataDtoList == null) {
            return 0;
        } else {
            return rentalDataDtoList.size();
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

        @BindView(R.id.view)
        Button viewButton_v;

        @BindView(R.id.rentNow)
        Button addToCartButton_v;

        @BindView(R.id.wishlist_icon)
        ImageView wishlistImageView_v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
