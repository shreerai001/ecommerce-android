package com.shree.ecom.contacts.activityContactUs.view;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.contacts.activityContactUs.contract.ContactUsContract;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.CONST;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactUsActivity extends AppCompatActivity implements ContactUsContract.View {

    @BindView(R.id.name)
    EditText name_v;

    @BindView(R.id.email)
    EditText email_v;

    @BindView(R.id.subject)
    EditText subject_v;

    @BindView(R.id.message)
    EditText message_v;

    @BindView(R.id.realtiveLayout)
    RelativeLayout relativeLayout_v;

    @BindView(R.id.submit)
    Button submit_v;

    @Inject
    ContactUsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayout_v, message, Snackbar.LENGTH_SHORT).show();
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

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
    }

    @Override
    @OnClick(R.id.submit)
    public void saveQuery() {
        if (name_v.getText() == null) {
            name_v.setError(CONST.INPUT_NULL_ERROR);
            name_v.requestFocus();
        } else if (email_v.getText() == null) {
            email_v.setError(CONST.INPUT_NULL_ERROR);
            email_v.requestFocus();
        } else if (subject_v.getText() == null) {
            subject_v.setError(CONST.INPUT_NULL_ERROR);
            subject_v.requestFocus();
        } else if (message_v.getText() == null) {
            message_v.setError(CONST.INPUT_NULL_ERROR);
            message_v.requestFocus();
        } else {
            presenter.saveQuery(name_v.getText().toString(), email_v.getText().toString(), subject_v.getText().toString(), message_v.getText().toString());
        }
    }
}
