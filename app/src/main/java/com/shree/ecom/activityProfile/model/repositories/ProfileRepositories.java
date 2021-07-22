package com.shree.ecom.activityProfile.model.repositories;

import com.shree.ecom.activityProfile.model.dto.ProfileEntity;
import com.shree.ecom.activityProfile.model.dto.ShippingEntity;

import io.reactivex.Observable;

public interface ProfileRepositories {
    Observable<ProfileEntity> getProfileDetail();

    Observable<ProfileEntity> getProfileDetailFromNetwork();

    Observable<ProfileEntity> getProfileDetailFromCache();

    Observable<ShippingEntity> getShippingDetail();

    Observable<ShippingEntity> getShippingDetailFromNetwork();

    Observable<ShippingEntity> getShippingDetailFromCahce();
}
