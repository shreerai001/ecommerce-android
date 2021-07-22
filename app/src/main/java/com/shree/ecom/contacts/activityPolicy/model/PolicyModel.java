package com.shree.ecom.contacts.activityPolicy.model;

import com.shree.ecom.contacts.activityPolicy.contract.PolicyContract;
import com.shree.ecom.contacts.activityPolicy.model.dto.PolicyEntity;
import com.shree.ecom.contacts.activityPolicy.model.repositories.PolicyRepository;

import io.reactivex.Observable;

/**
 * Created by shree on 16,May,2019
 */
public class PolicyModel implements PolicyContract.Model {

    private PolicyRepository policyRepository;

    public PolicyModel(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public Observable<PolicyEntity> getPolicy() {
        return policyRepository.getPolicy();
    }
}
