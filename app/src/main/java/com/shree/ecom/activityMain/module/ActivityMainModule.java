package com.shree.ecom.activityMain.module;

import android.content.Context;

import com.shree.ecom.activityMain.ActivityMainApiService;
import com.shree.ecom.activityMain.contract.ActivityMainContract;
import com.shree.ecom.activityMain.model.ActivityModel;
import com.shree.ecom.activityMain.model.repositories.ActivityMainRepository;
import com.shree.ecom.activityMain.model.repositories.ActivityMainRepositoryIMPL;
import com.shree.ecom.activityMain.presenter.ActivityMainPresenter;
import com.shree.ecom.activityProfile.services.ProfileApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityMainModule {
    @Provides
    public ActivityMainContract.Presenter providePresenter(Context context, ProfileApiService profileApiService, ActivityMainContract.Model model) {
        return new ActivityMainPresenter(context, profileApiService, model);
    }

    @Provides
    public ActivityMainContract.Model provideModel(Context context, ActivityMainRepository activityMainRepository) {
        return new ActivityModel(context, activityMainRepository);
    }

    @Singleton
    @Provides
    public ActivityMainRepository provideRepository(ActivityMainApiService activityMainApiService) {
        return new ActivityMainRepositoryIMPL(activityMainApiService);
    }
}
