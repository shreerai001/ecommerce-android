package com.shree.ecom.activitySearch.contract;

import com.shree.ecom.activitySearch.model.dto.SearchDataDto;
import com.shree.ecom.activitySearch.model.dto.SearchResponseEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface SearchContract {
    interface View extends BaseView {
        void loadSearchResult(List<SearchDataDto> dataEntityList);

        List<SearchDataDto> sort(List<SearchDataDto> searchDataDtoList);

    }

    interface Presenter extends BasePresenter {
        void setView(SearchContract.View view);

        void searchProduct(String productName);

        void sortAz(List<SearchDataDto> searchDataDtoList);

        void sortZa(List<SearchDataDto> searchDataDtoList);

        void sortPriceUp(List<SearchDataDto> searchDataDtoList);

        void sortPriceDown(List<SearchDataDto> searchDataDtoList);

        void sortNewest(List<SearchDataDto> searchDataDtoList);
    }

    interface Model {
        Observable<SearchResponseEntity> searchProduct(String productName);
    }
}
