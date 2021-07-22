package com.shree.ecom.activitySearch.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activitySearch.model.dto.SearchDataDto;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<SearchDataDto> searchDataDtoList;
    private Context context_dco;

    public SearchAdapter(List<SearchDataDto> searchDataDtoList, Context context_dco) {
        this.searchDataDtoList = searchDataDtoList;
        this.context_dco = context_dco;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_search, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.equipmentName_v.setText(searchDataDtoList.get(i).getName());
        viewHolder.equipmentModel_v.setText(searchDataDtoList.get(i).getModel());
        viewHolder.equipmentDescription_v.setText(searchDataDtoList.get(i).getDescription());
        viewHolder.equipmentPrice_v.setText(searchDataDtoList.get(i).getPrice());
        Picasso.with(context_dco).load(searchDataDtoList.get(i).getImg()).into(viewHolder.equipmentImage_v);
    }

    @Override
    public int getItemCount() {

        return searchDataDtoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.search_image)
        ImageView equipmentImage_v;

        @BindView(R.id.search_item_name)
        TextView equipmentName_v;

        @BindView(R.id.search_item_model)
        TextView equipmentModel_v;

        @BindView(R.id.search_item_description)
        TextView equipmentDescription_v;

        @BindView(R.id.wishlist_icon)
        ImageView wishlistImageView_v;

        @BindView(R.id.search_item_price)
        TextView equipmentPrice_v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
