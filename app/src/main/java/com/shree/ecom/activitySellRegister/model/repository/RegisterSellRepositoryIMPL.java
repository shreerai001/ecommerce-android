package com.shree.ecom.activitySellRegister.model.repository;

import android.content.Context;
import android.net.Uri;

import com.shree.ecom.activitySellRegister.model.dto.RegisterSellResponseDto;
import com.shree.ecom.activitySellRegister.model.dto.RegisterSellerEntity;
import com.shree.ecom.activitySellRegister.service.RegisterSellApiService;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.BaseResponseEntity;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RegisterSellRepositoryIMPL extends BaseRepositoryIMPL implements RegisterSellRepository {
    private RegisterSellApiService registerSellApiService;
    private Context context;

    public RegisterSellRepositoryIMPL(Context context, RegisterSellApiService registerSellApiService) {
        super(context);
        this.context = context;
        this.registerSellApiService = registerSellApiService;
    }

    @Override
    public Observable<BaseResponseEntity> registerSeller(RegisterSellerEntity registerSellerEntity) {
        return registerSellApiService.registerSeller(accessToken(context),
                RequestBody.create(MediaType.parse("text/plain"), registerSellerEntity.getName()),
                RequestBody.create(MediaType.parse("text/plain"), registerSellerEntity.getPrimaryEmail()),
                RequestBody.create(MediaType.parse("text/plain"), registerSellerEntity.getPanNumber()),
                RequestBody.create(MediaType.parse("text/plain"), registerSellerEntity.getPhone()),
                RequestBody.create(MediaType.parse("text/plain"), registerSellerEntity.getAddress()),
                convertToPartPan(registerSellerEntity.getPanImage()),
                convertToPartCompany(registerSellerEntity.getCompanyImage()),
                convertToPartSignature(registerSellerEntity.getSignatureImage()));
    }

    @Override
    public MultipartBody.Part convertToMultiPart(String name, File file) {
//        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
//        return MultipartBody.Part.createFormData(name, file.getName(), requestFile);
        return null;
    }

//    public RequestBody convertToRequestBody(Uri uri) {
//        File file = new File(uri.getPath());
//        RequestBody image = RequestBody.create(MediaType.parse("image/*"), file);
//        return image;
//    }

    public MultipartBody.Part convertToPartPan(File file) {
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("pan_image", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
        return filePart;
    }

    public MultipartBody.Part convertToPartCompany(File file) {
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("company_image", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
        return filePart;
    }

    public MultipartBody.Part convertToPartSignature(File file) {
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("signature_image", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
        return filePart;
    }
}
