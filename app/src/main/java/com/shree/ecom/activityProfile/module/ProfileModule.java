package com.shree.ecom.activityProfile.module;

import android.content.Context;

import com.shree.ecom.activityProfile.contract.ProfileContract;
import com.shree.ecom.activityProfile.model.repositories.ProfileRepositories;
import com.shree.ecom.activityProfile.model.repositories.ProfileRepositoryIMPL;
import com.shree.ecom.activityProfile.presenter.ProfilePresenter;
import com.shree.ecom.activityProfile.services.ProfileApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileModule {

    @Provides
    public ProfileContract.Presenter providePresenter(ProfileRepositories profileModel, Context context) {
        return new ProfilePresenter(profileModel, context);
    }

    @Provides
    @Singleton
    public ProfileRepositories provideRepository(Context context, ProfileApiService profileApiService) {
        return new ProfileRepositoryIMPL(context, profileApiService);
    }
}
