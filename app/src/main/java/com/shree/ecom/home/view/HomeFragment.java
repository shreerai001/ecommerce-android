package com.shree.ecom.home.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.shree.ecom.OfflineActivity;
import com.shree.ecom.R;
import com.shree.ecom.home.contract.FeaturedProductContract;
import com.shree.ecom.home.contract.LatestProductContract;
import com.shree.ecom.home.model.dto.FeaturedProductDto;
import com.shree.ecom.home.model.dto.ProductsEntity;
import com.shree.ecom.home.view.adapter.HomeFeaturedAdapter;
import com.shree.ecom.home.view.adapter.HomeLatestAdapter;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.ProgressUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ir.apend.slider.ui.Slider;


public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, LatestProductContract.View, FeaturedProductContract.View {

    @BindView(R.id.imageSlider)
    Slider slider;

    @BindView(R.id.recycler_menu_latest)
    RecyclerView recyclerViewProduct_v;

    @BindView(R.id.recycler_featured)
    RecyclerView recyclerView_featured;


    @BindView(R.id.home_frame)
    FrameLayout frameLayout_home;

    @Inject
    LatestProductContract.Presenter presenter;

    @Inject
    FeaturedProductContract.Presenter presenterFeatured;

    @BindView(R.id.progress_latest)
    ProgressBar progressBar_v;

    private Unbinder unbinder_deo;
    private Context context;
    private ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder_deo = ButterKnife.bind(this, view);
        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
        presenterFeatured.setView(this);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadData();
        presenterFeatured.loadData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.rxUnsuscribe();
        presenterFeatured.rxUnsuscribe();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(frameLayout_home, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void progressOn(final boolean progressState) {
        if (progressState) {
            progressBar_v.setVisibility(View.VISIBLE);
        } else {
            progressBar_v.setVisibility(View.GONE);
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder_deo.unbind();
    }


    @Override
    public void updateData(List<ProductsEntity> productsList) {
        if (productsList != null) {
            progressOn(false);
            HomeLatestAdapter homeLatestAdapter = new HomeLatestAdapter(productsList, getContext());
            recyclerViewProduct_v.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            recyclerViewProduct_v.setAdapter(homeLatestAdapter);
        }
    }

    @Override
    public void updateFeaturedData(List<FeaturedProductDto> productsList) {
        if (productsList != null) {
            HomeFeaturedAdapter homeFeaturedAdapter = new HomeFeaturedAdapter(productsList, getContext());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView_featured.setHasFixedSize(true);
            recyclerView_featured.setLayoutManager(linearLayoutManager);
            recyclerView_featured.setAdapter(homeFeaturedAdapter);
        }
    }

    @Override
    public void offlineActivity() {
        startActivity(new Intent(getActivity(), OfflineActivity.class));
    }

    @Override
    public void showLoading(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(getActivity());
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

}
