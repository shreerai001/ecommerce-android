package com.shree.ecom.activityProductDetail.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.contract.RentalDetailContract;
import com.shree.ecom.activityBrowse.model.dto.rental.detail.RentalDetailDataDto;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductImgsDto;
import com.shree.ecom.activityBrowse.view.slider.ImageLoading;
import com.shree.ecom.activityBrowse.view.slider.ImageSliderActivity;
import com.shree.ecom.activityBrowse.view.slider.MainSliderAdapter;
import com.shree.ecom.activityProductDetail.contract.ProductDetailContract;
import com.shree.ecom.activityProductDetail.model.dto.ProductDetailEntity;
import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationDataDto;
import com.shree.ecom.activitySearch.view.SearchScreenActivity;
import com.shree.ecom.reviews.contract.ReviewsContract;
import com.shree.ecom.reviews.model.dto.ReviewsDataDto;
import com.shree.ecom.reviews.view.ReviewsAdapter;
import com.shree.ecom.similarProducts.contract.SimilarProductsContract;
import com.shree.ecom.similarProducts.model.dto.SimilarProductsEntity;
import com.shree.ecom.similarProducts.view.adapter.SimilarProductsAdapter;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.ProgressUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import ss.com.bannerslider.Slider;
import ss.com.bannerslider.event.OnSlideClickListener;

public class ProductDetailActivity extends AppCompatActivity implements
        ProductDetailContract.View,
        SimilarProductsContract.View,
        ReviewsContract.View,
        RentalDetailContract.View {

    @BindView(R.id.add_to_cart)
    Button addToCart;

    @BindView(R.id.recycler_reviews)
    RecyclerView recyclerViewReviews_v;

    @BindView(R.id.product_recommendation)
    RecyclerView productRecommendation;

    @BindView(R.id.productName)
    TextView productName_v;

    @BindView(R.id.daily_price)
    TextView productPriceDaily_v;

    @BindView(R.id.hour_price)
    TextView productPriceHourly_v;

    @BindView(R.id.monthly_price)
    TextView productPriceMonthly_v;

    @BindView(R.id.productdetail)
    LinearLayout linearLayout_v;


    @BindView(R.id.reviews_relative)
    RelativeLayout relativeLayoutReviews_v;

    @BindView(R.id.rate)
    TextView textViewRate_v;

    @BindView(R.id.ratingsRecycler)
    RelativeLayout recyclerViewRatings_v;

    @BindView(R.id.rateButton)
    Button rateButton_v;

    @BindView(R.id.cancelRateButton)
    Button cancelRateButton_v;


    @BindView(R.id.comment)
    EditText commentText_v;

    @BindView(R.id.star)
    MaterialRatingBar materialRatingBar;

    @BindView(R.id.banner_slider1)
    Slider slider;

    @BindView(R.id.description_id)
    TextView description_ids;

    @BindView(R.id.company_id)
    TextView company_ids;

    @BindView(R.id.year_id)
    TextView year_ids;

    @BindView(R.id.location_id)
    TextView location_ids;

    @BindView(R.id.created_id)
    TextView created_ids;

    @BindView(R.id.updated_id)
    TextView updated_ids;

    @BindView(R.id.slug_id)
    TextView slug_ids;

    @BindView(R.id.stuck_qty_id)
    TextView stuckqty_ids;

    @BindView(R.id.name_id)
    TextView name_ids;

    @BindView(R.id.stuck_id)
    TextView stuck_ids;

    @BindView(R.id.progress_recommendation)
    ProgressBar progressBarRecommendation_v;

    private String name_V;
    private String dailyRate_V;
    private String monthlyRate_V;
    private String hourRate_V;
    private String productId_V;
    private String id_V;
    private String description_id_V;
    private String manuf_company_V;
    private String manuf_year_V;
    private String location_V;
    private String created_V;
    private String updated_V;
    private String slug_V;
    private int stuck_V;
    private int stuckqty_V;
    private String image_V;

    private MainSliderAdapter mainSliderAdapter;
    private List<UsedProductImgsDto> usedProductImgsDtos;
    @Inject
    ReviewsContract.Presenter presenter;

    @Inject
    SimilarProductsContract.Presenter presenterSimilarProducts;
    private float ratingBarValue;

    @Inject
    ProductDetailContract.Presenter productDetailPresenter;


    @BindView(R.id.scrollview)
    NestedScrollView nestedScrollView;

    @BindView(R.id.linear)
    LinearLayout linearLayout;

    private ProgressDialog progressDialog;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadData(productId_V);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        getIntentValue();
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        presenterSimilarProducts.setView(this);
        presenterSimilarProducts.loadSimilarProducts(productId_V);
        productDetailPresenter.setView(this);
        initView();
        starRating();
        setSlider();
        checkRental(dailyRate_V, monthlyRate_V, hourRate_V);
        final Rect scrollBounds = new Rect();
        nestedScrollView.getHitRect(scrollBounds);
        /**
         * to slide addtocart button on slider
         */


    }

    /**
     * checks if it is being intent through rental adapter or not
     * if it is pass through rental adapter this method sets the rental price on view
     */
    void checkRental(String dailyRate, String monthlyRate, String hourRate) {
        if (dailyRate == null && monthlyRate == null && hourRate == null) {
            productPriceDaily_v.setVisibility(View.GONE);
            productPriceMonthly_v.setVisibility(View.GONE);
            productPriceHourly_v.setVisibility(View.GONE);
        }
    }

    void setSlider() {
        ImageLoading imageLoading = new ImageLoading(this);
        slider.init(imageLoading);
        mainSliderAdapter = new MainSliderAdapter();
        slider.setAdapter(mainSliderAdapter);
        //slider.setInterval(0);
        // slider.setSelectedSlide(1);
        slider.showIndicators();
        slider.setAnimateIndicators(true);
        mainSliderAdapter.setImgLoad(usedProductImgsDtos);

        slider.setOnSlideClickListener(new OnSlideClickListener() {
            @Override
            public void onSlideClick(int position) {
                Intent intent1 = new Intent(ProductDetailActivity.this, ImageSliderActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("Images", (Serializable) usedProductImgsDtos);
                intent1.putExtra("Images", args);
                startActivity(intent1);
            }
        });

    }

    /**
     * Gets intent value from adapter
     */
    void getIntentValue() {
        Intent intent = getIntent();
        name_V = intent.getStringExtra("name");
        dailyRate_V = intent.getStringExtra("day_price");
        monthlyRate_V = intent.getStringExtra("month_price");
        hourRate_V = intent.getStringExtra("hour_price");
        productId_V = intent.getStringExtra("id");
        description_id_V = intent.getStringExtra("description");
        manuf_company_V = intent.getStringExtra("company");
        manuf_year_V = intent.getStringExtra("cyear");
        location_V = intent.getStringExtra("location");
        created_V = intent.getStringExtra("created");
        updated_V = intent.getStringExtra("updated");
        slug_V = intent.getStringExtra("slug");
        name_V = intent.getStringExtra("name");
        image_V = intent.getStringExtra("pic");

        if (intent.hasExtra("Images")) {
            Bundle args = intent.getBundleExtra("Images");
            usedProductImgsDtos = (List<UsedProductImgsDto>) args.getSerializable("Images");

        } else if (intent.hasExtra("pic")) {
            String img = intent.getStringExtra("pic");
            usedProductImgsDtos = new ArrayList<>();
            UsedProductImgsDto usedProductImgsDto = new UsedProductImgsDto();
            usedProductImgsDto.setLargeUrl(img);
            usedProductImgsDto.setMediumUrl(img);
            usedProductImgsDto.setRelativePath(img);
            usedProductImgsDto.setSmallUrl(img);
            usedProductImgsDto.setUrl(img);
            usedProductImgsDtos.add(usedProductImgsDto);

        }

    }


    @OnClick(R.id.rate)
    void onRateClick() {
        relativeLayoutReviews_v.setVisibility(View.VISIBLE);
        recyclerViewRatings_v.setVisibility(View.GONE);
    }

    @OnClick(R.id.rateButton)
    void onRateButtonClick() {
        if (ratingBarValue > 1 && commentText_v.getText().toString().length() >= 3) {
            presenter.postReviews(Integer.parseInt(productId_V), Math.round(ratingBarValue), commentText_v.getText().toString());
            onCancelRateButtonClick();
        } else {
            displayMessage("Please rate the product");
        }
    }

    @OnClick(R.id.cancelRateButton)
    void onCancelRateButtonClick() {
        relativeLayoutReviews_v.setVisibility(View.GONE);
        recyclerViewRatings_v.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            startActivity(new Intent(ProductDetailActivity.this, SearchScreenActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadData(List<RentalDetailDataDto> rentalDetailDataDtoList) {

    }

    @Override
    public void initView() {
        productName_v.setText(name_V);
        productPriceHourly_v.setText(hourRate_V + "/ Hour");
        productPriceDaily_v.setText(dailyRate_V + "/ Day");
        productPriceMonthly_v.setText(monthlyRate_V + "/ Month");

        description_ids.setText(description_id_V);
        company_ids.setText(manuf_company_V);
        year_ids.setText(manuf_year_V);
        location_ids.setText(location_V);
        created_ids.setText(created_V);
        updated_ids.setText(updated_V);
        slug_ids.setText(slug_V);
        name_ids.setText(name_V);
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(linearLayout_v, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void progressOn(boolean isLoading) {
        if (isLoading) {
            progressBarRecommendation_v.setVisibility(View.VISIBLE);
        } else {
            progressBarRecommendation_v.setVisibility(View.GONE);
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void loadReviews(List<ReviewsDataDto> reviewsEntityList) {
        if (reviewsEntityList != null) {
            ReviewsAdapter reviewsAdapter = new ReviewsAdapter(reviewsEntityList, getApplicationContext());
            recyclerViewReviews_v.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
            recyclerViewReviews_v.setHasFixedSize(false);
            recyclerViewReviews_v.setAdapter(reviewsAdapter);
        }
    }

    @Override
    public void onBackPressed() {
        if (relativeLayoutReviews_v.getVisibility() == View.VISIBLE) {
            relativeLayoutReviews_v.setVisibility(View.GONE);
            recyclerViewRatings_v.setVisibility(View.VISIBLE);
        } else
            super.onBackPressed();
    }

    //    OnRatingChangeListener
    public void starRating() {
        materialRatingBar.setOnRatingChangeListener(new MaterialRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChanged(MaterialRatingBar ratingBar, float rating) {
                ratingBarValue = rating;
            }
        });

    }

    @Override
    public void loadSimilarProducts(List<SimilarProductsEntity> similarProductsEntityList) {
        if (similarProductsEntityList != null) {
            progressBarRecommendation_v.setVisibility(View.GONE);
            SimilarProductsAdapter similarProductsAdapter = new SimilarProductsAdapter(similarProductsEntityList, getApplicationContext());
            productRecommendation.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            productRecommendation.setHasFixedSize(false);
            productRecommendation.setAdapter(similarProductsAdapter);
        }
    }

    @Override
    public void loadProductRecommendataion(List<ProductRecommendationDataDto> productRecommendationDataDtoList) {

    }

    @Override
    public void addProductToCart(ProductDetailEntity productDetailEntity) {
        productDetailPresenter.addProductToCart(productDetailEntity);
    }

    @Override
    public void showLoading(boolean loadingState) {
        if (loadingState) {
            progressDialog = ProgressUtils.showProgressDialog(getApplicationContext());
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    @OnClick({R.id.add_to_cart})
    void onAddToCartClicked() {
        ProductDetailEntity productDetailEntity = new ProductDetailEntity();
        Toast.makeText(getApplicationContext(), "" + productId_V, Toast.LENGTH_LONG).show();
        productDetailEntity.setName(name_V);
        productDetailEntity.setId(Integer.parseInt(productId_V));
        productDetailEntity.setImg(image_V);
        productDetailEntity.setDescription(description_id_V);
        productDetailEntity.setManufacture_company(manuf_company_V);
        productDetailEntity.setManufacture_year(manuf_year_V);
        productDetailEntity.setLocation(location_V);
        productDetailEntity.setCreated_at(created_V);
        productDetailEntity.setUpdated_at(updated_V);
        productDetailEntity.setSlug(slug_V);
        productDetailPresenter.addProductToCart(productDetailEntity);
    }

    private boolean isViewVisible(View view) {
        Rect scrollBounds = new Rect();
        nestedScrollView.getDrawingRect(scrollBounds);

        float top = view.getY();
        float bottom = top + view.getHeight();

        if (scrollBounds.top < top && scrollBounds.bottom > bottom) {
            return true;
        } else {
            return false;
        }
    }

}
