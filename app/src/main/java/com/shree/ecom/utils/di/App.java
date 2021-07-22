package com.shree.ecom.utils.di;

import android.app.Application;

import com.shree.ecom.activityBrowse.module.allEquipment.AllEquipmentProductModule;
import com.shree.ecom.activityBrowse.module.newProduct.NewProductModule;
import com.shree.ecom.activityBrowse.module.rental.RentalModule;
import com.shree.ecom.activityBrowse.module.usedProduct.UsedProductModule;
import com.shree.ecom.activityCancelOrders.module.CancelOrderModule;
import com.shree.ecom.activityCartProceed.module.CartProceedModule;
import com.shree.ecom.activityMain.module.ActivityMainModule;
import com.shree.ecom.activityMyCart.module.MyCartModule;
import com.shree.ecom.activityMyOrders.module.MyOrdersModule;
import com.shree.ecom.activityProductDetail.module.ProductDetailModule;
import com.shree.ecom.activityProfile.module.ProfileModule;
import com.shree.ecom.activityRent.module.RentModule;
import com.shree.ecom.activityRequestProduct.module.RequestProductModule;
import com.shree.ecom.activitySearch.module.SearchModule;
import com.shree.ecom.activitySellRegister.module.SellerRegisterModule;
import com.shree.ecom.activitySignUp.module.SignUpModule;
import com.shree.ecom.activityWhishlist.module.addWishlist.WishlistModule;
import com.shree.ecom.categories.module.CategoryModule;
import com.shree.ecom.categories.module.EquipmentModule;
import com.shree.ecom.checkout.module.CheckoutModule;
import com.shree.ecom.contacts.activityContactUs.module.ContactUsModule;
import com.shree.ecom.home.module.FeaturedProductModule;
import com.shree.ecom.home.module.LatestProductModule;
import com.shree.ecom.activityLogin.module.LoginModule;
import com.shree.ecom.reviews.module.ReviewsModule;
import com.shree.ecom.activityWhishlist.module.cancelWishlist.CancelWishlistModule;
import com.shree.ecom.activityWhishlist.module.showWishlist.MyWishlistModule;
import com.shree.ecom.similarProducts.module.SimilarProductsModule;
import com.onesignal.OneSignal;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        OneSignal.sendTag("subscribed","true");

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .categoryModule(new CategoryModule())
             //   .signUpModule(new SignUpModule())
                .loginModule(new LoginModule())
                .contactUsModule(new ContactUsModule())
                .equipmentModule(new EquipmentModule())
                .rentalModule(new RentalModule())
                .allEquipmentProductModule(new AllEquipmentProductModule())
                .reviewsModule(new ReviewsModule())
                .myOrdersModule(new MyOrdersModule())
                .latestProductModule(new LatestProductModule())
                .featuredProductModule(new FeaturedProductModule())
                .cancelOrderModule(new CancelOrderModule())
                .profileModule(new ProfileModule())
                .newProductModule(new NewProductModule())
                .usedProductModule(new UsedProductModule())
                .wishlistModule(new WishlistModule())
                .myWishlistModule(new MyWishlistModule())
                .cancelWishlistModule(new CancelWishlistModule())
                .myCartModule(new MyCartModule())
                .activityMainModule(new ActivityMainModule())
                .productDetailModule(new ProductDetailModule())
                .rentModule(new RentModule())
                .requestProductModule(new RequestProductModule())
                .searchModule(new SearchModule())
                .sellerRegisterModule(new SellerRegisterModule())
                .cartProceedModule(new CartProceedModule())
                .similarProductsModule(new SimilarProductsModule())
                .checkoutModule(new CheckoutModule())
                .build();

    }

    public ApplicationComponent getComponent() {
        return component;
    }



}
