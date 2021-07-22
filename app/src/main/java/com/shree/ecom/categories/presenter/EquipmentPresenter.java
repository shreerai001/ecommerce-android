package com.shree.ecom.categories.presenter;

import com.shree.ecom.categories.contract.EquipmentContract;
import com.shree.ecom.categories.model.dto.equipment.EquipmentDto;
import com.shree.ecom.categories.model.dto.equipment.EquipmentEntity;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class EquipmentPresenter implements EquipmentContract.Presenter {

    private EquipmentContract.Model model;
    private EquipmentContract.View view;
    private Disposable disposable;

    public EquipmentPresenter(EquipmentContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(EquipmentContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        disposable = model.getEquipmentData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<EquipmentEntity>() {
                    @Override
                    public void onNext(EquipmentEntity equipmentEntity) {
                        if (view != null) {
                            List<EquipmentDto> equipmentDtoList = new ArrayList<>();
                            for (int i = 0; i < equipmentEntity.getData().size(); i++) {
                                equipmentDtoList.add(equipmentEntity.getData().get(i));
                            }
                            view.updateData(equipmentDtoList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void rxUnsuscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
