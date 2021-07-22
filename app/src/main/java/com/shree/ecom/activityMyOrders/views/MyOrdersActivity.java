package com.shree.ecom.activityMyOrders.views;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.shree.ecom.R;
import com.shree.ecom.activityMyOrders.contract.MyOrdersContract;
import com.shree.ecom.activityMyOrders.model.dto.MyOrdersDataEntity;
import com.shree.ecom.activityMyOrders.views.adapter.MyOrdersAdapter;
import com.shree.ecom.utils.di.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrdersActivity extends AppCompatActivity implements MyOrdersContract.View {

    @BindView(R.id.relative_my_orders)
    RelativeLayout relativeLayout_v;

    @BindView(R.id.recycler_my_orders)
    RecyclerView myOrdersRecycler_v;

    @Inject
    MyOrdersContract.Presenter presenter;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    public void loadData(List<MyOrdersDataEntity> myOrdersDataEntityList) {
        MyOrdersAdapter myOrdersAdapter = new MyOrdersAdapter(myOrdersDataEntityList, getApplicationContext(),MyOrdersActivity.this);
        myOrdersRecycler_v.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        myOrdersRecycler_v.setAdapter(myOrdersAdapter);
        myOrdersRecycler_v.setHasFixedSize(false);
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayout_v, message, Snackbar.LENGTH_LONG).show();
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
