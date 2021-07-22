package com.shree.ecom.activitySellRegister.service;

import com.shree.ecom.activitySellRegister.model.dto.RegisterSellResponseDto;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RegisterSellApiService {
    @POST("sell-with-us")
    @Multipart
    Observable<BaseResponseEntity> registerSeller(@Header("Authorization") String auth,
                                                  @Part("name") RequestBody name,
                                                  @Part("primary_email") RequestBody primaryEmail,
                                                  @Part("pan_number") RequestBody panNumber,
                                                  @Part("phone") RequestBody phone,
                                                  @Part("address") RequestBody address,
                                                  @Part MultipartBody.Part pan_image,
                                                  @Part MultipartBody.Part company_image,
                                                  @Part MultipartBody.Part signature_image);

}
