package com.shree.ecom.activityFilter.view.bottomsheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shree.ecom.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterBottomSheet extends BottomSheetDialogFragment {

//    @BindView(R.id.filter_recycler)
//    RecyclerView recyclerViewFilter_v;

    public static FilterBottomSheet newInstance() {
        return new FilterBottomSheet();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filter_bottom_sheet, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
