package com.shree.ecom.activitySellRegister.model.repository;

import com.shree.ecom.activitySellRegister.model.dto.RegisterSellResponseDto;
import com.shree.ecom.activitySellRegister.model.dto.RegisterSellerEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MultipartBody;

public interface RegisterSellRepository {
    Observable<BaseResponseEntity> registerSeller(RegisterSellerEntity registerSellerEntity);

    MultipartBody.Part convertToMultiPart(String name,File file);
}
