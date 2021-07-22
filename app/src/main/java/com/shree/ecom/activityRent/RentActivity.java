package com.shree.ecom.activityRent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.shree.ecom.R;
import com.shree.ecom.activityRent.contract.RentContract;
import com.shree.ecom.utils.di.App;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class RentActivity extends AppCompatActivity implements RentContract.View {

    @Inject
    RentContract.Presenter presenter;
    Spinner spinner, spinner1;
    SpinnerAdapter spinnerAdapter, spinnerAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);

        setSpinner();



    }

    void setSpinner(){
        spinner = findViewById(R.id.spn_select_city);
        spinner1 = findViewById(R.id.spn_select_state);
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter1 = ArrayAdapter.createFromResource(this, R.array.state, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner1.setAdapter(spinnerAdapter1);

    }

    @Override
    public void displayMessage(String message) {


    }

    @Override
    public void displayTransferMessage(String message) {

    }

    @Override
    public void progressOn(boolean progressState) {

    }

    @Override
    public void stop() {

    }
}
