package com.shree.ecom.categories.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shree.ecom.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MaterialFragment extends Fragment {

    @BindView(R.id.recycler_material)
    RecyclerView recyclerViewMaterial_v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_material, container, false);
        ButterKnife.bind(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
