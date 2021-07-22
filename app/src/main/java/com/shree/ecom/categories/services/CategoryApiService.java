package com.shree.ecom.categories.services;

import com.shree.ecom.categories.model.dto.CategoryDto;
import com.shree.ecom.categories.model.dto.equipment.EquipmentEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CategoryApiService {

    @GET("categories")
    Observable<CategoryDto> getCategory();


}
