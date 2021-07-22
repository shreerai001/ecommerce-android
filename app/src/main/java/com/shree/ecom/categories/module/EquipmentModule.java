package com.shree.ecom.categories.module;

import com.shree.ecom.categories.contract.EquipmentContract;
import com.shree.ecom.categories.model.EquipmentModel;
import com.shree.ecom.categories.presenter.EquipmentPresenter;
import com.shree.ecom.categories.model.repository.equipment.EquipmentRepository;
import com.shree.ecom.categories.model.repository.equipment.EquipmentRepositoryIMPL;
import com.shree.ecom.categories.services.EquipmentApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class EquipmentModule {
    @Provides
    public EquipmentContract.Model provideModel(EquipmentRepository equipmentRepository) {
        return new EquipmentModel(equipmentRepository);
    }

    @Provides
    public EquipmentContract.Presenter providePresenter(EquipmentContract.Model model) {
        return new EquipmentPresenter(model);
    }


    @Singleton
    @Provides
    public EquipmentRepository provideRepository(EquipmentApiService equipmentApiService) {
        return new EquipmentRepositoryIMPL(equipmentApiService);
    }
}
