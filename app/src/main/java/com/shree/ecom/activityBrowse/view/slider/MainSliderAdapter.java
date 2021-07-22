package com.shree.ecom.activityBrowse.view.slider;

import android.util.Log;

import com.shree.ecom.activityBrowse.model.dto.used.UsedProductImgsDto;

import java.util.List;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainSliderAdapter extends SliderAdapter {

    List<UsedProductImgsDto> usedProductImgsDtos;

    @Override
    public int getItemCount() {
        if (usedProductImgsDtos == null) {
            return 0;
        } else {
            return usedProductImgsDtos.size();
        }
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        Log.d("Image", "" + usedProductImgsDtos.get(position).getLargeUrl());
        imageSlideViewHolder.bindImageSlide(usedProductImgsDtos.get(position).getLargeUrl());



    }

    public void setImgLoad(List<UsedProductImgsDto> usedProductImgsDtos) {
        this.usedProductImgsDtos = usedProductImgsDtos;
    }
}
