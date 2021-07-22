package com.shree.ecom.contacts.activityContactUs.module;

import com.shree.ecom.contacts.activityContactUs.contract.ContactUsContract;
import com.shree.ecom.contacts.activityContactUs.model.ContactUsModel;
import com.shree.ecom.contacts.activityContactUs.presenter.ContactUsPresenter;
import com.shree.ecom.contacts.activityContactUs.model.repository.ContactUsRepository;
import com.shree.ecom.contacts.activityContactUs.model.repository.ContactUsRepositoryIMPL;
import com.shree.ecom.contacts.activityContactUs.services.ContactUsApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shree on 16,May,2019
 */
@Module
public class ContactUsModule {

    @Provides
    public ContactUsContract.Model provideModel(ContactUsRepository contactUsRepository) {
        return new ContactUsModel(contactUsRepository);
    }

    @Provides
    public ContactUsContract.Presenter providePresenter(ContactUsContract.Model model) {
        return new ContactUsPresenter(model);
    }

    @Singleton
    @Provides
    public ContactUsRepository provideRepository(ContactUsApiService contactUsApiService) {
        return new ContactUsRepositoryIMPL(contactUsApiService);
    }
}
