package com.shree.ecom.home.slideshow;

import com.shree.ecom.home.slideshow.model.dto.SlideShowEntity;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SlideShowApiService {
    @GET("slideshows")
    Call<SlideShowEntity> getSlideShow();
}
