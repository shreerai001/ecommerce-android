package com.shree.ecom.activityBrowse.model.repositories.newProduct;

import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsEntity;

import io.reactivex.Observable;

public interface NewProductRepository {
    Observable<NewProductsEntity> getNewProduct();

    Observable<NewProductsEntity> getNewProductFromCache();

    Observable<NewProductsEntity> getNewProductFromNetwork();
}
