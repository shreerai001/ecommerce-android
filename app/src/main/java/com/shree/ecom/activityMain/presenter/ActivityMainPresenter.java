package com.shree.ecom.activityMain.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.shree.ecom.activityMain.contract.ActivityMainContract;
import com.shree.ecom.activityProfile.model.dto.ProfileEntity;
import com.shree.ecom.activityProfile.model.repositories.ProfileRepositoryIMPL;
import com.shree.ecom.activityProfile.services.ProfileApiService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * ProfileRepositoryIMPL is inherited to display profile detail's on NavBar using saveProfileDetail()
 */
public class ActivityMainPresenter extends ProfileRepositoryIMPL implements ActivityMainContract.Presenter {
    private ActivityMainContract.Model model;

    private ActivityMainContract.View view;
    private Disposable disposable;

    public ActivityMainPresenter(Context context, ProfileApiService profileApiService, ActivityMainContract.Model model) {
        super(context, profileApiService);
        this.model = model;
    }

    @Override
    public boolean checkedLogged() {
        return model.checkedLogged();
    }


    @Override
    public void saveProfileDetail() {
        if (checkedLogged()) {
            disposable = super.getProfileDetail()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(new DisposableObserver<ProfileEntity>() {
                        @Override
                        public void onNext(ProfileEntity profileEntity) {
                            view.loadProfileIfLogged(profileEntity.getData());
                        }

                        @Override
                        public void onError(Throwable e) {
                            view.displayMessage(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                        }
                    });
        }
    }

    @Override
    public void setView(ActivityMainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void rxUnsuscribe() {

    }
}
