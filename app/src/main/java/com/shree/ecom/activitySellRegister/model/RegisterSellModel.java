package com.shree.ecom.activitySellRegister.model;

import com.shree.ecom.activitySellRegister.contract.RegisterSellerContract;
import com.shree.ecom.activitySellRegister.model.dto.RegisterSellResponseDto;
import com.shree.ecom.activitySellRegister.model.dto.RegisterSellerEntity;
import com.shree.ecom.activitySellRegister.model.repository.RegisterSellRepository;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class RegisterSellModel implements RegisterSellerContract.Model {

    private RegisterSellRepository registerSellRepository;

    public RegisterSellModel(RegisterSellRepository registerSellRepository) {
        this.registerSellRepository = registerSellRepository;
    }

    @Override
    public Observable<BaseResponseEntity> registerSeller(RegisterSellerEntity registerSellerEntity) {
        return registerSellRepository.registerSeller(registerSellerEntity);
    }
}
