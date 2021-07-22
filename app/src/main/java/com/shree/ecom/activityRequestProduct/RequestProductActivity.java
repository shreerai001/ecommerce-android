package com.shree.ecom.activityRequestProduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.shree.ecom.R;
import com.shree.ecom.activityRequestProduct.contract.RequestProductContract;
import com.shree.ecom.activityRequestProduct.model.dto.RequestProductEntity;
import com.shree.ecom.utils.di.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class RequestProductActivity extends AppCompatActivity implements RequestProductContract.View, AdapterView.OnItemSelectedListener {

    Spinner spinner, spinner2, spinner3, spinner4;
    SpinnerAdapter adapter, adapter2, adapter3, adapter4;

    @Inject
    RequestProductContract.Presenter presenter;

    @BindView(R.id.btn_continue)
    Button continueButton_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_product);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        spinner = findViewById(R.id.spn_select_category);
        spinner2 = findViewById(R.id.spn_brands);
        spinner3 = findViewById(R.id.spn_buy_rental);
        spinner4 = findViewById(R.id.spn_condition);

        adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_dropdown_item);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.brand, android.R.layout.simple_spinner_dropdown_item);
        adapter3 = ArrayAdapter.createFromResource(this, R.array.buy_rental, android.R.layout.simple_spinner_dropdown_item);

        adapter4 = ArrayAdapter.createFromResource(this, R.array.select_condition, android.R.layout.simple_spinner_dropdown_item);

        ((ArrayAdapter) adapter).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        adapterView.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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

    @OnClick(R.id.btn_continue)
    void onContinueClick() {
        RequestProductEntity requestProductEntity = new RequestProductEntity();
        presenter.RequestProduct(getApplicationContext(), requestProductEntity);
    }
}
