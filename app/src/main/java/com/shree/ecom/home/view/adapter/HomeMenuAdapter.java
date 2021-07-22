package com.shree.ecom.home.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shree.ecom.R;
import com.shree.ecom.home.model.dto.HomeMenuDto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * this adapter adapts view for product on home menu with four circle icon
 */
public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuAdapter.ViewHolder> {


    private List<HomeMenuDto> homeLatestDtoArrayList;
    private Context context_dco;

    public HomeMenuAdapter(List<HomeMenuDto> productsArrayList, Context context_dco) {
        this.homeLatestDtoArrayList = productsArrayList;
        this.context_dco = context_dco;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_menu, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       // Picasso.with(context_dco).load(homeLatestDtoArrayList.get(i).getImage()).into(viewHolder.menuIcon_v);
        viewHolder.btn_menu_item.setText(homeLatestDtoArrayList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        Log.i("product Size", "" + homeLatestDtoArrayList.size());
        return homeLatestDtoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

//        @BindView(R.id.menu_name)
//        TextView menuIconName_v;

//        @BindView(R.id.icon_image)
//        ImageView menuIcon_v;

       @BindView(R.id.menu_item)
        Button btn_menu_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
