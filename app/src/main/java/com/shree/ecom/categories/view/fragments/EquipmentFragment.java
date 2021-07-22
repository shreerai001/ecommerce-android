package com.shree.ecom.categories.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shree.ecom.R;
import com.shree.ecom.categories.contract.EquipmentContract;
import com.shree.ecom.categories.model.dto.equipment.EquipmentDto;
import com.shree.ecom.categories.view.adapter.EquipmentAdapter;
import com.shree.ecom.utils.di.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EquipmentFragment extends Fragment implements EquipmentContract.View {

    @BindView(R.id.recycler_equipment)
    RecyclerView recyclerViewEquipment_v;

    @Inject
    EquipmentContract.Presenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipment, container, false);
        ButterKnife.bind(this,view);
        presenter.setView(this);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadData();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void displayMessage(String message) {
        Snackbar.make(recyclerViewEquipment_v, message, Snackbar.LENGTH_SHORT).show();
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

    @Override
    public void updateData(List<EquipmentDto> equipmentEntityList) {
        EquipmentAdapter equipmentAdapter = new EquipmentAdapter(equipmentEntityList, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewEquipment_v.setLayoutManager(layoutManager);
        recyclerViewEquipment_v.setAdapter(equipmentAdapter);
    }
}
