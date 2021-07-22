package com.shree.ecom.activitySearch.view;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;
import com.shree.ecom.R;
import com.shree.ecom.activitySearch.contract.SearchContract;
import com.shree.ecom.activitySearch.model.dto.SearchDataDto;
import com.shree.ecom.activitySearch.view.adapter.SearchAdapter;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SearchScreenActivity extends AppCompatActivity implements SearchContract.View {
    RelativeLayout rel_head_brand, rel_body_brand;

    @BindView(R.id.searchProgress)
    ProgressBar searchProgressBar;

    @BindView(R.id.relativesearch)
    RelativeLayout relativeLayoutSearch_v;


    @BindView(R.id.filter)
    Button filter;

    @BindView(R.id.sort)
    Button sort;

    @BindView(R.id.searchBar)
    MaterialSearchBar materialSearchBar_v;

    @BindView(R.id.search_result)
    RecyclerView recyclerViewSearchResult_v;

    @Inject
    SearchContract.Presenter presenter;

    SearchAdapter searchAdapter;
    List<SearchDataDto> searchResponseEntityList;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchResponseEntityList = new ArrayList<>();
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        materialSearchBar_v.setHint("shree Search");
        materialSearchBar_v.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if (!enabled) {
                    searchResponseEntityList = new ArrayList<>();
                    searchResponseEntityList.clear();
                    loadSearchResult(searchResponseEntityList);
                }
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                progressOn(true);
                if (text != null) {
                    presenter.searchProduct(String.valueOf(text));
                } else {
                    displayMessage(CONST.INPUT_NULL_ERROR);
                }
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });
    }

    @OnClick(R.id.sort)
    void onSortClicked() {
        loadBotttomSheetSort();
    }

    @OnClick(R.id.filter)
    void onFilterClicked() {
        loadbottomSheetfilter();
    }


    @Override
    public void loadSearchResult(List<SearchDataDto> dataEntityList) {
        stop();
        if (dataEntityList.size() <= 0) {
            displayMessage(CONST.NULL_SEARCH_RESULT);
        }
        this.searchResponseEntityList = dataEntityList;
        searchAdapter = new SearchAdapter(dataEntityList, getApplicationContext());
        searchAdapter.notifyDataSetChanged();
        recyclerViewSearchResult_v.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerViewSearchResult_v.setAdapter(searchAdapter);
        recyclerViewSearchResult_v.setHasFixedSize(false);
    }

    @Override
    public List<SearchDataDto> sort(List<SearchDataDto> searchDataDtoList) {
        return null;
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayoutSearch_v, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void progressOn(boolean progressState) {
        searchProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stop() {
        searchProgressBar.setVisibility(View.GONE);
    }

    public void loadbottomSheetfilter() {
        stop();
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(SearchScreenActivity.this);
        bottomSheetDialog.setContentView(R.layout.filter_bottom_sheet);
        RecyclerView filterRecyclerView=bottomSheetDialog.findViewById(R.id.filter_recyclerview);

//        rel_head_brand = bottomSheetDialog.findViewById(R.id.rel_brand_head);
//        rel_body_brand = bottomSheetDialog.findViewById(R.id.rel_brand_body);
//        bottomSheetDialog.show();
//
//        rel_head_brand.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setVisibility(rel_body_brand);
//            }
//        });
    }

    public void loadBotttomSheetSort() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(SearchScreenActivity.this);
        bottomSheetDialog.setContentView(R.layout.sort_bottom_sheet);
        RadioButton newestRadioButton = bottomSheetDialog.findViewById(R.id.newest);
        RadioButton aZRadioButton = bottomSheetDialog.findViewById(R.id.a_z);
        RadioButton zARadioButton = bottomSheetDialog.findViewById(R.id.z_a);
        RadioButton lowestRadioButton = bottomSheetDialog.findViewById(R.id.lowest);
        RadioButton highestRadioButton = bottomSheetDialog.findViewById(R.id.hieghest_lowest);
        newestRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sortNewest(searchResponseEntityList);
                bottomSheetDialog.dismiss();
            }
        });

        aZRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sortAz(searchResponseEntityList);
                bottomSheetDialog.dismiss();
            }
        });
        zARadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sortZa(searchResponseEntityList);
                bottomSheetDialog.dismiss();
            }
        });
        lowestRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sortPriceDown(searchResponseEntityList);
                bottomSheetDialog.dismiss();
            }
        });
        highestRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sortPriceUp(searchResponseEntityList);
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.show();
    }

    public void setVisibility(View view) {

        switch (view.getVisibility()) {
            case View.VISIBLE:
                view.setVisibility(View.GONE);
                break;
            case View.GONE:
                view.setVisibility(View.VISIBLE);
                break;
        }
    }

}
