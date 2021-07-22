package com.shree.ecom.contacts.activityPolicy.services;

import com.shree.ecom.contacts.activityPolicy.model.dto.PolicyEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by shree on 16,May,2019
 */
public interface PolicyApiService {
    @GET("policies")
    Observable<PolicyEntity> getPolicy();
}
