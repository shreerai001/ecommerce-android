package com.shree.ecom.activitySellRegister.model.dto;

import android.net.Uri;

import java.io.File;

import okhttp3.MultipartBody;

public class RegisterSellerEntity {
    private int id;
    private String name;
    private String primaryEmail;
    private String panNumber;
    private String phone;
    private String address;
    private File panImage;
    private File companyImage;
    private File signatureImage;
    private Uri panUri;
    private Uri companyImageUri;
    private Uri signatureImageUri;

    public Uri getCompanyImageUri() {
        return companyImageUri;
    }

    public void setCompanyImageUri(Uri companyImageUri) {
        this.companyImageUri = companyImageUri;
    }

    public Uri getSignatureImageUri() {
        return signatureImageUri;
    }

    public void setSignatureImageUri(Uri signatureImageUri) {
        this.signatureImageUri = signatureImageUri;
    }

    public Uri getPanUri() {
        return panUri;
    }

    public void setPanUri(Uri panUri) {
        this.panUri = panUri;
    }

    public RegisterSellerEntity(String name, String primaryEmail, String panNumber, String phone, String address, MultipartBody.Part pan_image, MultipartBody.Part company_image, MultipartBody.Part signature_image) {
    }

//    public RegisterSellerEntity(String name, String primaryEmail, String panNumber, String phone, String address, Uri panUri, Uri companyImageUri, Uri signatureImageUri) {
//        this.name = name;
//        this.primaryEmail = primaryEmail;
//        this.panNumber = panNumber;
//        this.phone = phone;
//        this.address = address;
//        this.panUri = panUri;
//        this.companyImageUri = companyImageUri;
//        this.signatureImageUri = signatureImageUri;
//    }

        public RegisterSellerEntity(String name, String primaryEmail, String panNumber, String phone, String address, File panImage, File companyImage, File signatureImage) {
        this.name = name;
        this.primaryEmail = primaryEmail;
        this.panNumber = panNumber;
        this.phone = phone;
        this.address = address;
        this.panImage = panImage;
        this.companyImage = companyImage;
        this.signatureImage = signatureImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public File getPanImage() {
        return panImage;
    }

    public void setPanImage(File panImage) {
        this.panImage = panImage;
    }

    public File getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(File companyImage) {
        this.companyImage = companyImage;
    }

    public File getSignatureImage() {
        return signatureImage;
    }

    public void setSignatureImage(File signatureImage) {
        this.signatureImage = signatureImage;
    }

}
