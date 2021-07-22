package com.shree.ecom.activityMyOrders.model;

import com.shree.ecom.activityMyOrders.contract.MyOrdersContract;
import com.shree.ecom.activityMyOrders.model.dto.MyOrdersEntity;
import com.shree.ecom.activityMyOrders.model.repositories.MyOrdersRepository;

import io.reactivex.Observable;

public class MyOrderModel implements MyOrdersContract.Model {
    private MyOrdersRepository myOrdersRepository;

    public MyOrderModel(MyOrdersRepository myOrdersRepository) {
        this.myOrdersRepository = myOrdersRepository;
    }

    @Override
    public Observable<MyOrdersEntity> getMyOrders() {
        return myOrdersRepository.getMyOrders();
    }
}
