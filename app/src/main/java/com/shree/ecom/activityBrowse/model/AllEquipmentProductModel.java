package com.shree.ecom.activityBrowse.model;

import com.shree.ecom.activityBrowse.contract.AllProductContract;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.model.repositories.all.AllEquipmentProductRepository;

import io.reactivex.Observable;

public class AllEquipmentProductModel implements AllProductContract.Model {
    private AllEquipmentProductRepository equipmentRepository;

    public AllEquipmentProductModel(AllEquipmentProductRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Observable<AllEquipmentProductEntity> getAllEquipmentList() {
        return equipmentRepository.getEquipment();
    }

    @Override
    public boolean addAllProductToCart(AllEquipmentProductEntity allEquipmentProductEntity) {
        return equipmentRepository.addAllEquipmentToCard(allEquipmentProductEntity);
    }

}
