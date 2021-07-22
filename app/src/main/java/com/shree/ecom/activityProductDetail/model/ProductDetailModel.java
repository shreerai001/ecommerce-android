package com.shree.ecom.activityProductDetail.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import com.shree.ecom.activityProductDetail.contract.ProductDetailContract;
import com.shree.ecom.activityProductDetail.model.dto.ProductDetailEntity;
import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationEntity;
import com.shree.ecom.activityProductDetail.repositories.ProductDetailRepository;
import com.shree.ecom.utils.values.DbHelper;
import com.shree.ecom.utils.values.TableName;

import io.reactivex.Observable;

public class ProductDetailModel implements ProductDetailContract.Model {

    private ProductDetailRepository productDetailRepository;
    private Context context;

    public ProductDetailModel(ProductDetailRepository productDetailRepository, Context context) {
        this.productDetailRepository = productDetailRepository;
        this.context = context;
    }

    @Override
    public Observable<ProductRecommendationEntity> getProductRecommendation() {
        return productDetailRepository.getProductRecommendation();
    }

    @Override
    public boolean addProductToCart(ProductDetailEntity productDetailEntity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("company", productDetailEntity.getManufacture_company());
        contentValues.put("product_id", productDetailEntity.getId());
        contentValues.put("product_name", productDetailEntity.getName());
        contentValues.put("user_id", productDetailEntity.getUser_id());
        contentValues.put("model", productDetailEntity.getModel());
        contentValues.put("brand_id", productDetailEntity.getBrand_id());
        contentValues.put("image", productDetailEntity.getImg());
        contentValues.put("tax", productDetailEntity.getTax());
        contentValues.put("category_id", productDetailEntity.getCategory_id());
        contentValues.put("year", productDetailEntity.getManufacture_year());
        contentValues.put("sale_price", productDetailEntity.getSale_price());
        contentValues.put("price", productDetailEntity.getPrice());
        contentValues.put("running_hour", productDetailEntity.getRunning_hour());
        contentValues.put("description", productDetailEntity.getDescription());
        contentValues.put("status", productDetailEntity.getStatus());
        contentValues.put("updated_at", productDetailEntity.getUpdated_at());
        contentValues.put("location", productDetailEntity.getLocation());
        DbHelper rentalDbHelper = new DbHelper(context);
        return rentalDbHelper.insertCartInfo(contentValues);
    }
}
