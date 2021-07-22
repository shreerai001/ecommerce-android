package com.shree.ecom.activityBrowse.model;

import com.shree.ecom.activityBrowse.contract.NewProductContract;
import com.shree.ecom.activityBrowse.contract.UsedProductContract;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsEntity;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductEntity;
import com.shree.ecom.activityBrowse.model.repositories.newProduct.NewProductRepository;
import com.shree.ecom.activityBrowse.model.repositories.used.UsedPoductRepository;

import io.reactivex.Observable;

public class UsedProductModel implements UsedProductContract.Model {
    private UsedPoductRepository usedPoductRepository;

    public UsedProductModel(UsedPoductRepository usedPoductRepository) {
        this.usedPoductRepository = usedPoductRepository;
    }

    @Override
    public Observable<UsedProductEntity> getProductsEntity() {
        return usedPoductRepository.getUsedProduct();
    }



}
