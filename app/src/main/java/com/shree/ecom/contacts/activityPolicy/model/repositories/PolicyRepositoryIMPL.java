package com.shree.ecom.contacts.activityPolicy.model.repositories;

import com.shree.ecom.contacts.activityPolicy.model.dto.PolicyEntity;
import com.shree.ecom.contacts.activityPolicy.services.PolicyApiService;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by shree on 16,May,2019
 */
public class PolicyRepositoryIMPL implements PolicyRepository {

    private PolicyApiService policyApiService;
    List<PolicyEntity> policyEntityList;
    private long timeStamp;

    public PolicyRepositoryIMPL(PolicyApiService policyApiService) {
        this.policyApiService = policyApiService;
        this.timeStamp = System.currentTimeMillis();
        policyEntityList = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<PolicyEntity> getPolicy() {
        return getPolicyFromCache().switchIfEmpty(getPolicyFromNetwork());
    }

    @Override
    public Observable<PolicyEntity> getPolicyFromNetwork() {
        return policyApiService.getPolicy();
    }

    @Override
    public Observable<PolicyEntity> getPolicyFromCache() {
        if (isUpToDate()) {
            return Observable.fromIterable(policyEntityList);
        } else {
            timeStamp = System.currentTimeMillis();
            policyEntityList.clear();
            return Observable.empty();
        }
    }
}
