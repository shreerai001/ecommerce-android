package com.shree.ecom.categories.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.categories.contract.CategoriesContract;
import com.shree.ecom.categories.model.dto.CategoryDto;
import com.shree.ecom.categories.view.adapter.CategoryAdapter;
import com.shree.ecom.categories.view.fragments.EquipmentFragment;
import com.shree.ecom.categories.view.fragments.MaterialFragment;
import com.shree.ecom.utils.di.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesFragment extends Fragment implements CategoriesContract.View {

    private CategoryAdapter categoryAdapter_ic;

    @Inject
    CategoriesContract.Presenter presenter;

    @BindView(R.id.viewpager_rashifal)
    ViewPager v_viewPager;

    @BindView(R.id.tablayout_rashifal)
    TabLayout v_tabLayout;

    @BindView(R.id.recycler_categories)
    RecyclerView recyclerViewCategories_v;


    CategoryDto categoryDtoList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplication()).getComponent().inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        ButterKnife.bind(this, view);
        presenter.setView(this);
        setupViewPager(v_viewPager);
        v_tabLayout.setupWithViewPager(v_viewPager);
        return view;
    }


    @Override
    public void displayMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void progressOn(boolean progressState) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.rxUnsuscribe();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new EquipmentFragment(), "Equipment");
        viewPagerAdapter.addFragment(new MaterialFragment(), "Material");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void updateCategories(CategoryDto categoryDtoList) {

        this.categoryDtoList = categoryDtoList;
        Log.i("Info", "Categories Fragment Checked");
        categoryAdapter_ic = new CategoryAdapter(categoryDtoList.getData(), getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewCategories_v.setLayoutManager(gridLayoutManager);
        recyclerViewCategories_v.setAdapter(categoryAdapter_ic);
        recyclerViewCategories_v.setHasFixedSize(false);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> stringList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            stringList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }
    }
}
