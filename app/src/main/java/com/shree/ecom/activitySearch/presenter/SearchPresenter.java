package com.shree.ecom.activitySearch.presenter;

import android.widget.Toast;

import com.shree.ecom.activitySearch.contract.SearchContract;
import com.shree.ecom.activitySearch.model.dto.SearchDataDto;
import com.shree.ecom.activitySearch.model.dto.SearchResponseEntity;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View view;
    private SearchContract.Model model;
    private Disposable disposable;
    private List<SearchDataDto> searchDataDtoList;

    public SearchPresenter(SearchContract.Model model) {
        this.model = model;
        searchDataDtoList = new ArrayList<>();
    }

    @Override
    public void setView(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void searchProduct(String productName) {
        disposable = model.searchProduct(productName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<SearchResponseEntity>() {
                    @Override
                    public void onNext(SearchResponseEntity searchResponseEntity) {
                        if (view != null) {
                            List<SearchDataDto> dataEntityList = new ArrayList<>();
                            for (int i = 0; i < searchResponseEntity.getProducts().getData().size(); i++) {
                                dataEntityList.add(searchResponseEntity.getProducts().getData().get(i));
                            }
                            searchDataDtoList = dataEntityList;
                            view.loadSearchResult(dataEntityList);
                        } else {
//                            view.displayMessage(CONST.NETWORK_FETCH_ERROR);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void loadData() {
    }

    @Override
    public void rxUnsuscribe() {

    }


    private Comparator<SearchDataDto> priceUpComparator = new Comparator<SearchDataDto>() {
        @Override
        public int compare(SearchDataDto searchDataDto, SearchDataDto t1) {
            String price = searchDataDto.getSale_price().toUpperCase();
            String price1 = t1.getPrice().toUpperCase();
            return price.compareTo(price1);
        }
    };
    private Comparator<SearchDataDto> newestComparator = new Comparator<SearchDataDto>() {
        @Override
        public int compare(SearchDataDto searchDataDto, SearchDataDto t1) {
            String price = String.valueOf(searchDataDto.getId()).toUpperCase();
            String price1 = String.valueOf(t1.getPrice()).toUpperCase();
            return price.compareTo(price1);
        }
    };
    private Comparator<SearchDataDto> priceDownComparator = new Comparator<SearchDataDto>() {
        @Override
        public int compare(SearchDataDto searchDataDto, SearchDataDto t1) {
            String price = searchDataDto.getSale_price().toUpperCase();
            String price1 = t1.getPrice().toUpperCase();
            return price1.compareTo(price);
        }
    };

    private Comparator<SearchDataDto> aZComparator = new Comparator<SearchDataDto>() {
        @Override
        public int compare(SearchDataDto searchDataDto, SearchDataDto t1) {
            String searchName = searchDataDto.getName().toUpperCase();
            String searchName1 = t1.getName().toUpperCase();
            return searchName.compareTo(searchName1);
        }
    };
    private Comparator<SearchDataDto> zAComparator = new Comparator<SearchDataDto>() {
        @Override
        public int compare(SearchDataDto searchDataDto, SearchDataDto t1) {
            String searchName = searchDataDto.getName().toUpperCase();
            String searchName1 = t1.getName().toUpperCase();
            return searchName1.compareTo(searchName);
        }
    };

    @Override
    public void sortAz(List<SearchDataDto> searchDataDtoList) {
        Collections.sort(searchDataDtoList, aZComparator);
        view.loadSearchResult(searchDataDtoList);
    }

    @Override
    public void sortZa(List<SearchDataDto> searchDataDtoList) {
        Collections.sort(searchDataDtoList, zAComparator);
        view.loadSearchResult(searchDataDtoList);
    }

    @Override
    public void sortPriceUp(List<SearchDataDto> searchDataDtoList) {
        Collections.sort(searchDataDtoList, priceUpComparator);
        view.loadSearchResult(searchDataDtoList);
    }

    @Override
    public void sortPriceDown(List<SearchDataDto> searchDataDtoList) {
        Collections.sort(searchDataDtoList, priceDownComparator);
        view.loadSearchResult(searchDataDtoList);
    }

    @Override
    public void sortNewest(List<SearchDataDto> searchDataDtoList) {
        Collections.sort(searchDataDtoList, newestComparator);
        view.loadSearchResult(searchDataDtoList);
    }
}
