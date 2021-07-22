package com.shree.ecom.categories.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.categories.model.dto.CategoryDto;
import com.shree.ecom.R;
import com.shree.ecom.categories.model.dto.Datum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<Datum> categoryDtoArrayList;
    private Context context_dco;

    public CategoryAdapter(List<Datum> categoryDtoArrayList, Context context_dco) {
        this.categoryDtoArrayList = categoryDtoArrayList;
        this.context_dco = context_dco;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_categories, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name_icon.setText(categoryDtoArrayList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return categoryDtoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon_categories)
        ImageView image_icon;

        @BindView(R.id.name_categories)
        TextView name_icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
