package com.shree.ecom.contacts.activityPolicy.module;

import com.shree.ecom.contacts.activityPolicy.contract.PolicyContract;
import com.shree.ecom.contacts.activityPolicy.model.PolicyModel;
import com.shree.ecom.contacts.activityPolicy.presenter.PolicyPresenter;
import com.shree.ecom.contacts.activityPolicy.model.repositories.PolicyRepository;
import com.shree.ecom.contacts.activityPolicy.model.repositories.PolicyRepositoryIMPL;
import com.shree.ecom.contacts.activityPolicy.services.PolicyApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shree on 16,May,2019
 */
@Module
public class PolicyModule {

    @Provides
    public PolicyContract.Model providePolicyModel(PolicyRepository policyRepository) {
        return new PolicyModel(policyRepository);
    }

    @Provides
    public PolicyContract.Presenter providePolicyPresenter(PolicyContract.Model model) {
        return new PolicyPresenter(model);
    }

    @Singleton
    @Provides
    public PolicyRepository providePolicyRepository(PolicyApiService policyApiService) {
        return new PolicyRepositoryIMPL(policyApiService);
    }

}
