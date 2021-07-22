package com.shree.ecom.activitySellRegister.view;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activitySellRegister.contract.RegisterSellerContract;
import com.shree.ecom.activitySellRegister.model.dto.RegisterSellerEntity;
import com.shree.ecom.utils.di.App;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterSellerActivity extends AppCompatActivity implements RegisterSellerContract.View {

    private static final int PERMISSION_REQUEST_EXTERNAL_STORAGE = 101;
    @Inject
    RegisterSellerContract.Presenter presenter;

    @BindView(R.id.ed_cname)
    EditText editTextCompanyName_v;

    @BindView(R.id.ed_pan_number)
    EditText editTextPanNumber_v;

    @BindView(R.id.ed_phone_number)
    EditText ediTextPhoneNumber_v;

    @BindView(R.id.ed_email)
    EditText editTextEmail_v;

    @BindView(R.id.ed_address)
    EditText editTextAddress_v;

    @BindView(R.id.txt_pan_register)
    TextView textViewPanRegistration_v;

    @BindView(R.id.txt_company_registration)
    TextView textViewCompanyRegistration_v;

    @BindView(R.id.txt_signature)
    TextView textViewSignature_v;

    @BindView(R.id.sell_register_relative)
    RelativeLayout relativeLayoutSeller_v;

    @BindView(R.id.icon_file_pan)
    ImageView panImageView_v;

    @BindView(R.id.icon_file_company)
    ImageView companyImageView_v;

    @BindView(R.id.icon_file_signature)
    ImageView signatureImageView_v;

    @BindView(R.id.btn_continue)
    Button continueBottom_v;
    private final int GALLERY_REQUEST_CODE_PAN_NUMBER = 1;
    private final int GALLERY_REQUEST_CODE_SIGNATURE_NUMBER = 2;
    private final int GALLERY_REQUEST_CODE_COMPANY_NUMBER = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_seller);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
    }

    @OnClick(R.id.btn_continue)
    void onButtonClick() {
        RegisterSellerEntity registerSellerEntity = new RegisterSellerEntity(editTextCompanyName_v.getText().toString(),
                editTextEmail_v.getText().toString(),
                editTextPanNumber_v.getText().toString(),
                ediTextPhoneNumber_v.getText().toString(),
                editTextAddress_v.getText().toString(),
                getFile(companyPan),
                getFile(companyImg),
                getFile(companySignaure));
        presenter.regiseterSeller(registerSellerEntity);
    }

    @OnClick({R.id.icon_file_pan, R.id.txt_pan_register})
    void onClick() {
        pickFromGallery(1);
    }

    @OnClick({R.id.icon_file_company, R.id.txt_company_registration})
    void onClick2() {
        pickFromGallery(2);
    }

    @OnClick({R.id.icon_file_signature, R.id.txt_signature})
    void onClick3() {
        pickFromGallery(3);
    }


    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayoutSeller_v, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void progressOn(boolean progressState) {

    }

    @Override
    public void stop() {

    }


    public void pickFromGallery(int i) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            switch (i) {
                case 1:
                    startActivityForResult(intent, GALLERY_REQUEST_CODE_PAN_NUMBER);
                    break;
                case 2:
                    startActivityForResult(intent, GALLERY_REQUEST_CODE_COMPANY_NUMBER);
                    break;
                case 3:
                    startActivityForResult(intent, GALLERY_REQUEST_CODE_SIGNATURE_NUMBER);
                    break;
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }


    }

    private Uri companyImg, companyPan, companySignaure;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        InputStream imageSteam = null;
//        Bitmap bmp = null;
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case GALLERY_REQUEST_CODE_COMPANY_NUMBER:
                    companyImg = data.getData();
                    textViewCompanyRegistration_v.setText(data.getData().getPath());
                    break;
                case GALLERY_REQUEST_CODE_PAN_NUMBER:
                    textViewPanRegistration_v.setText(data.getData().getPath());
                    companyPan = data.getData();
                    break;
                case GALLERY_REQUEST_CODE_SIGNATURE_NUMBER:
                    textViewSignature_v.setText(data.getData().getPath());
                    companySignaure = data.getData();
                    break;
            }
//        try {
//            imageSteam.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor == null) return null;
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String s = cursor.getString(column_index);
        cursor.close();
        return s;
    }

    public File getFile(Uri uri) {
        File file = new File(getPath(uri));
        return file;
    }
}
