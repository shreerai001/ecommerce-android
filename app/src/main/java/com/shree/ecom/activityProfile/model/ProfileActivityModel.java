package com.shree.ecom.activityProfile.model;

import android.content.ContentValues;
import android.content.Context;

import com.shree.ecom.activityProfile.model.dto.ProfileDataDto;
import com.shree.ecom.activityProfile.model.dto.ProfileShippingDataDto;
import com.shree.ecom.utils.mvp.BaseRepository;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.DbHelper;

public class ProfileActivityModel extends BaseRepository {

    DbHelper dbHelper;

    public String getToken(Context context) {
        return super.accessToken(context);
    }

    @Override
    public boolean checkdLoggedIn() {
        return true;
    }

    public void insertProfileDetail(Context context, ProfileDataDto profileDataDto) {
        dbHelper = new DbHelper(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", profileDataDto.getFirst_name());
        contentValues.put("last_name", profileDataDto.getLast_name());
        contentValues.put("email", profileDataDto.getEmail());
        contentValues.put("phone", profileDataDto.getPhone());
        contentValues.put("image", profileDataDto.getImage());
        dbHelper.insertProfileInfo(contentValues);
    }

    public ProfileDataDto getProfileDetail(Context context) {
        dbHelper = new DbHelper(context);
        return dbHelper.getProfileInfo();
    }

    public void insertShippingDetail(Context context, ProfileShippingDataDto profileShippingDataDto) {
        dbHelper = new DbHelper(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("address1", profileShippingDataDto.getAddress1());
        contentValues.put("address2", profileShippingDataDto.getAddress2());
        contentValues.put("city", profileShippingDataDto.getCity());
        contentValues.put("country", profileShippingDataDto.getCountry());
        contentValues.put("email", profileShippingDataDto.getEmail());
        contentValues.put("user_id", profileShippingDataDto.getUser_id());
        contentValues.put("phone", profileShippingDataDto.getPhone());
        contentValues.put("state", profileShippingDataDto.getState());
        contentValues.put("postcode", profileShippingDataDto.getPostcode());
        contentValues.put("updated_at", profileShippingDataDto.getUpdated_at());
        contentValues.put("created_at", profileShippingDataDto.getCreated_at());
        dbHelper.insertShippingInfo(contentValues);
    }

    public ProfileShippingDataDto getShippingDetail(Context context) {
        dbHelper = new DbHelper(context);
        return dbHelper.getShippingDetail();
    }


}
