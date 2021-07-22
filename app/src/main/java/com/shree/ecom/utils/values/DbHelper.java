package com.shree.ecom.utils.values;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.shree.ecom.activityProfile.model.dto.ProfileDataDto;
import com.shree.ecom.activityProfile.model.dto.ProfileShippingDataDto;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String name = "shree_rai";
    private static final int version = 1;
    private final String create_rental_cart_table = "CREATE TABLE if not exists `cart`" +
            " ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "`company` TEXT," +
            "`product_id` TEXT UNIQUE," +
            "`product_name` TEXT," +
            "`user_id` TEXT ," +
            "`model` TEXT ," +
            "`brand_id` TEXT ," +
            "`image` TEXT ," +
            "`tax` TEXT ," +
            "`category_id` TEXT ," +
            " `year` TEXT, " +
            " `sale_price` TEXT, " +
            "`price` TEXT, " +
            "`running_hour` INTEGER, " +
            "`description` TEXT, " +
            "`status` TEXT, " +
            "`updated_at` TEXT, " +
            "`location` TEXT )";
    private final String create_personal_table = "CREATE TABLE if not exists `personal_detail`" +
            " ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "`first_name` TEXT," +
            " `last_name` TEXT, " +
            " `image` TEXT, " +
            "`phone` TEXT, " +
            "`email` TEXT )";

    private final String create_shipping_table = "CREATE TABLE if not exists `shipping_detail`" +
            " ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "`address1` TEXT," +
            " `address2` TEXT, " +
            " `city` TEXT, " +
            "`country` TEXT, " +
            "`user_id` TEXT, " +
            "`phone` TEXT, " +
            "`state` TEXT, " +
            "`postcode` TEXT, " +
            "`updated_at` TEXT, " +
            "`created_at` TEXT, " +
            "`email` TEXT )";

    private final String CHECK_CART_SIZE = "SELECT SUM(LENGTH(id)) FROM `cart`";

    private final String RETRIEVE_CART = "SELECT * FROM `cart`";

    private final String RETRIEVE_PERSONAL_DETAIL = " SELECT * FROM `personal_detail` ";

    private final String RETREIVE_SHIPPING_DETAIL = "SELECT * from `shipping_detail`";


    public DbHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(create_rental_cart_table);
        getWritableDatabase().execSQL(create_personal_table);
        getWritableDatabase().execSQL(create_shipping_table);
    }

    public void insertCartInfo(ContentValues contentValues, String tableName) {
        getWritableDatabase().insert(tableName, "", contentValues);
    }

    public boolean insertCartInfo(ContentValues contentValues) {
        try {
            getWritableDatabase().insertOrThrow("cart", "", contentValues);
            return true;
        } catch (SQLiteConstraintException e) {
            return false;
        }
    }

    public void insertProfileInfo(ContentValues contentValues) {
        getWritableDatabase().insert("personal_detail", "", contentValues);
    }

    public void insertShippingInfo(ContentValues contentValues) {
        getWritableDatabase().insert("shipping_detail", "", contentValues);
    }

    public ProfileDataDto getProfileInfo() {
        Cursor cursor = getWritableDatabase().rawQuery(RETRIEVE_PERSONAL_DETAIL, null);
        ProfileDataDto profileDataDto = new ProfileDataDto();
        while (cursor.moveToNext()) {
            profileDataDto.setId(cursor.getColumnIndex("id"));
            profileDataDto.setFirst_name(cursor.getString(cursor.getColumnIndex("first_name")));
            profileDataDto.setLast_name(cursor.getString(cursor.getColumnIndex("last_name")));
            profileDataDto.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            profileDataDto.setImage(cursor.getString(cursor.getColumnIndex("image")));
            profileDataDto.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
        }
        cursor.close();
        return profileDataDto;
    }

    public ProfileShippingDataDto getShippingDetail() {
        Cursor cursor = getWritableDatabase().rawQuery(RETREIVE_SHIPPING_DETAIL, null);
        ProfileShippingDataDto profileShippingDataDto = new ProfileShippingDataDto();
        while (cursor.moveToNext()) {
            profileShippingDataDto.setId(cursor.getInt(cursor.getColumnIndex("id")));
            profileShippingDataDto.setAddress1(cursor.getString(cursor.getColumnIndex("address1")));
            profileShippingDataDto.setAddress1(cursor.getString(cursor.getColumnIndex("address2")));
            profileShippingDataDto.setCity(cursor.getString(cursor.getColumnIndex("city")));
            profileShippingDataDto.setCountry(cursor.getString(cursor.getColumnIndex("country")));
            profileShippingDataDto.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
            profileShippingDataDto.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            profileShippingDataDto.setState(cursor.getString(cursor.getColumnIndex("state")));
            profileShippingDataDto.setPostcode(cursor.getString(cursor.getColumnIndex("postcode")));
            profileShippingDataDto.setUpdated_at(cursor.getString(cursor.getColumnIndex("updated_at")));
            profileShippingDataDto.setCreated_at(cursor.getString(cursor.getColumnIndex("created_at")));
            profileShippingDataDto.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        }
        cursor.close();
        return profileShippingDataDto;
    }

    public List<CartEntity> getCardInfo() {
        Cursor cursor = getWritableDatabase().rawQuery(RETRIEVE_CART, null);
        List<CartEntity> cartEntityList = new ArrayList<>();
        CartEntity cartEntity;
        while (cursor.moveToNext()) {
            cartEntity = new CartEntity();
            cartEntity.setId(cursor.getInt(cursor.getColumnIndex("id")));
            cartEntity.setProductId(cursor.getString(cursor.getColumnIndex("product_id")));
            cartEntity.setUserId(cursor.getInt(cursor.getColumnIndex("user_id")));
            cartEntity.setBrandId(cursor.getInt(cursor.getColumnIndex("brand_id")));
            cartEntity.setModel(cursor.getString(cursor.getColumnIndex("model")));
            cartEntity.setCompany(cursor.getString(cursor.getColumnIndex("company")));
            cartEntity.setProductName(cursor.getString(cursor.getColumnIndex("product_name")));
            cartEntity.setImage(cursor.getString(cursor.getColumnIndex("image")));
            cartEntity.setTax(cursor.getString(cursor.getColumnIndex("tax")));
            cartEntity.setCategoryId(cursor.getInt(cursor.getColumnIndex("category_id")));
            cartEntity.setYear(cursor.getString(cursor.getColumnIndex("year")));
            cartEntity.setSalePrice(cursor.getString(cursor.getColumnIndex("sale_price")));
            cartEntity.setPrice(cursor.getString(cursor.getColumnIndex("price")));
            cartEntity.setRunningHour(cursor.getString(cursor.getColumnIndex("running_hour")));
            cartEntity.setDescription(cursor.getString(cursor.getColumnIndex("description")));
            cartEntity.setStatus(cursor.getString(cursor.getColumnIndex("status")));
            cartEntity.setUpdateAt(cursor.getString(cursor.getColumnIndex("updated_at")));
            cartEntity.setLocation(cursor.getString(cursor.getColumnIndex("location")));
            cartEntityList.add(cartEntity);
        }
        cursor.close();
        return cartEntityList;
    }

    public List<CartEntity> getCardInfo(int id) {
        String SELECT_FROM_CART = "select * from `cart` where id=`" + id + "`";
        Cursor cursor = getWritableDatabase().rawQuery(SELECT_FROM_CART, null);
        List<CartEntity> cartEntityList = new ArrayList<>();
        CartEntity cartEntity = new CartEntity();
        while (cursor.moveToNext()) {
            cartEntity.setId(cursor.getInt(cursor.getColumnIndex("id")));
            cartEntity.setBrandId(cursor.getInt(cursor.getColumnIndex("brand_id")));
            cartEntity.setModel(cursor.getString(cursor.getColumnIndex("model")));
            cartEntity.setCompany(cursor.getString(cursor.getColumnIndex("company")));
            cartEntity.setProductName(cursor.getString(cursor.getColumnIndex("product_name")));
            cartEntity.setImage(cursor.getString(cursor.getColumnIndex("image")));
            cartEntity.setProductId(cursor.getString(cursor.getColumnIndex("product_id")));
            cartEntityList.add(cartEntity);
        }
        return cartEntityList;
    }

    public List<CartEntity> deleteItemFromCart(int id) {
        String DELTE_FROM_CART = "delete from `cart` where product_id=" + id;
        getWritableDatabase().execSQL(DELTE_FROM_CART);
        return getCardInfo();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
