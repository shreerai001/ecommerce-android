package com.shree.ecom.activityBrowse.view.slider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductImgsDto;

import java.util.List;

import ss.com.bannerslider.Slider;

public class ImageSliderActivity extends AppCompatActivity {

    private Slider slider;

    MainSliderAdapter mainSliderAdapter = new MainSliderAdapter();
    List<UsedProductImgsDto> usedProductImgsDtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);

        slider = findViewById(R.id.banner_slider);
        Intent intent = getIntent();

        Bundle args = intent.getBundleExtra("Images");
        usedProductImgsDtos = (List<UsedProductImgsDto>) args.getSerializable("Images");


        ImageLoading imageLoading = new ImageLoading(this);
        slider.init(imageLoading);
        mainSliderAdapter = new MainSliderAdapter();
        slider.setAdapter(mainSliderAdapter);
        //slider.setInterval(0);
        // slider.setSelectedSlide(1);
        mainSliderAdapter.setImgLoad(usedProductImgsDtos);



    }
}
