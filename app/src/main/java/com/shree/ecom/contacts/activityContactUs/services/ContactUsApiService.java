package com.shree.ecom.contacts.activityContactUs.services;

import com.shree.ecom.contacts.activityContactUs.model.dto.ContactUsResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by shree on 16,May,2019
 */
public interface ContactUsApiService {

    @FormUrlEncoded
    @POST("contact")
    Observable<ContactUsResponseEntity> sendQuery(@Field("name") String name,
                                                  @Field("email") String email,
                                                  @Field("subject") String subject,
                                                  @Field("message") String message);
}
