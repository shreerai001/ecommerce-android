package com.shree.ecom.contacts.activityPolicy.view;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.contacts.activityPolicy.contract.PolicyContract;
import com.shree.ecom.contacts.activityPolicy.model.dto.PolicyEntity;
import com.shree.ecom.utils.di.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PoliciesActivity extends AppCompatActivity implements PolicyContract.View {

    @BindView(R.id.relative_layout)
    RelativeLayout relativeLayout;

    @BindView(R.id.recycler_policy)
    RecyclerView recyclerView;

    @Inject
    PolicyContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies);
        ((App) getApplicationContext()).getComponent().inject(this);
        presenter.setView(this);
        ButterKnife.bind(this);
    }

    @Override
    public void updateView(List<PolicyEntity> policyEntityList) {
        PolicyAdapter policyAdapter = new PolicyAdapter(policyEntityList, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(policyAdapter);
        recyclerView.setHasFixedSize(false);
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayout, message, Snackbar.LENGTH_SHORT).show();
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
        presenter.loadData();
        presenter.setView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxUnsuscribe();
    }
}
