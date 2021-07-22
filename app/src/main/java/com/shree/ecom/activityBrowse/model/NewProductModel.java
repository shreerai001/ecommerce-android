package com.shree.ecom.activityBrowse.model;

import com.shree.ecom.activityBrowse.contract.AllProductContract;
import com.shree.ecom.activityBrowse.contract.NewProductContract;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsEntity;
import com.shree.ecom.activityBrowse.model.repositories.newProduct.NewProductRepository;

import io.reactivex.Observable;

public class NewProductModel implements NewProductContract.Model {
    private NewProductRepository newProductRepository;

    public NewProductModel(NewProductRepository newProductRepository) {
        this.newProductRepository = newProductRepository;
    }

    @Override
    public Observable<NewProductsEntity> getProductsEntity() {
        return newProductRepository.getNewProduct();
    }


//    @Override
//    public Observable<AllEquipmentProductEntity> getAllEquipmentList() {
//        return equipmentRepository.getEquipment();
//    }
}
