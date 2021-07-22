package com.shree.ecom.activityBrowse.model.rental.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RentalDbHelper extends SQLiteOpenHelper {

    private static final String name = "shree_rai";
    private static final int version = 1;
    private final String create_rental_cart_table = "CREATE TABLE if not exists `rental_cart`" +
            " ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "`rental_product_id` INTEGER NOT NULL," +
            " `company` TEXT, " +
            "`product_name` TEXT, " +
            "`user_id` INTEGER, " +
            "`model` TEXT, " +
            "`brand_id` INTEGER )";

    public RentalDbHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(create_rental_cart_table);
    }

    public void insertCartInfo(ContentValues contentValues) {
        getWritableDatabase().insert("rental_cart", "", contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
