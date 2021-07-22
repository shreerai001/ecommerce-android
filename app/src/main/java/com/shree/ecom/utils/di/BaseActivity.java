package com.shree.ecom.utils.di;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.shree.ecom.Main2Activity;
import com.shree.ecom.R;
import com.shree.ecom.utils.values.networkUtils.NetworkEvent;
import com.shree.ecom.utils.values.networkUtils.NetworkState;

import io.reactivex.functions.Consumer;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        NetworkEvent.getInstance().register(this,
                new Consumer<NetworkState>() {
                    @Override
                    public void accept(NetworkState networkState) throws Exception {
                        switch (networkState) {
                            case NO_INTERNET:
                                BaseActivity.this.displayErrorDialog(BaseActivity.this.getString(R.string.generic_no_internet_title),
                                        BaseActivity.this.getString(R.string.generic_no_internet_desc));
                                break;

                            case NO_RESPONSE:
                                BaseActivity.this.displayErrorDialog(BaseActivity.this.getString(R.string.generic_http_error_title),
                                        BaseActivity.this.getString(R.string.generic_http_error_desc));
                                break;

                            case UNAUTHORISED:
                                //redirect to login screen - if session expired
                                Toast.makeText(BaseActivity.this.getApplicationContext(), R.string.error_login_expired, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(BaseActivity.this, Main2Activity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                BaseActivity.this.startActivity(intent);
                                break;
                        }
                    }
                });
    }


    @Override
    protected void onStop() {
        super.onStop();
        NetworkEvent.getInstance().unregister(this);
    }

    public void displayErrorDialog(String title,
                                   String desc) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(desc)
                .setCancelable(false)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .show();
    }
}
