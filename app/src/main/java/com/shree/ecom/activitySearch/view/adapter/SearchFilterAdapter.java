package com.shree.ecom.activitySearch.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activitySearch.model.dto.SearchFilterEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFilterAdapter extends RecyclerView.Adapter<SearchFilterAdapter.ViewHolder> {

    private List<SearchFilterEntity> searchFilterEntityList;
    private Context context;

    public SearchFilterAdapter(List<SearchFilterEntity> searchFilterEntityList, Context context) {
        this.searchFilterEntityList = searchFilterEntityList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_search_filter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.searchFilterNameV.setText(searchFilterEntityList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return searchFilterEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.brand_name)
        TextView searchFilterNameV;

        @BindView(R.id.filter_checkbox)
        CheckBox filterCheckbox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
