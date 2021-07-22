package com.shree.ecom.utils.values;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.shree.ecom.R;

public class ProgressUtils {
    private ProgressUtils() {
    }

    public static ProgressDialog showProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
