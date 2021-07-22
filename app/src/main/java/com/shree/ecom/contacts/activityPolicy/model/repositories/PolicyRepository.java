package com.shree.ecom.contacts.activityPolicy.model.repositories;

import com.shree.ecom.contacts.activityPolicy.model.dto.PolicyEntity;

import io.reactivex.Observable;

/**
 * Created by shree on 16,May,2019
 */
public interface PolicyRepository {
    Observable<PolicyEntity> getPolicy();

    Observable<PolicyEntity> getPolicyFromNetwork();

    Observable<PolicyEntity> getPolicyFromCache();
}
