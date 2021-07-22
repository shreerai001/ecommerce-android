package com.shree.ecom.utils.di;

import com.shree.ecom.Main2Activity;
import com.shree.ecom.activityBrowse.BrowseFragment;
import com.shree.ecom.activityBrowse.module.allEquipment.AllEquipmentProductApiModule;
import com.shree.ecom.activityBrowse.module.allEquipment.AllEquipmentProductModule;
import com.shree.ecom.activityBrowse.module.newProduct.NewProductApiModule;
import com.shree.ecom.activityBrowse.module.newProduct.NewProductModule;
import com.shree.ecom.activityBrowse.module.rental.RentalApiModule;
import com.shree.ecom.activityBrowse.module.rental.RentalModule;
import com.shree.ecom.activityBrowse.module.usedProduct.UsedProductApiModule;
import com.shree.ecom.activityBrowse.module.usedProduct.UsedProductModule;
import com.shree.ecom.activityBrowse.view.activity.AllEquipmentProductActivity;
import com.shree.ecom.activityBrowse.view.activity.RentalEquipmentActivity;
import com.shree.ecom.activityProductDetail.view.ProductDetailActivity;
import com.shree.ecom.activityBrowse.view.activity.NewEquipmentActivity;
import com.shree.ecom.activityBrowse.view.activity.UsedEquipmentActivity;
import com.shree.ecom.activityCancelOrders.CancelOrderActivity;
import com.shree.ecom.activityCancelOrders.module.CancelOrderApiModule;
import com.shree.ecom.activityCancelOrders.module.CancelOrderModule;
import com.shree.ecom.activityCartProceed.module.CartApiModule;
import com.shree.ecom.activityCartProceed.module.CartProceedModule;
import com.shree.ecom.activityCartProceed.view.CartProceedActivity;
import com.shree.ecom.activityLogin.LoginActivity;
import com.shree.ecom.activityLogin.module.LoginApiModule;
import com.shree.ecom.activityLogin.module.LoginModule;
import com.shree.ecom.activityMain.module.ActivityMainApiModule;
import com.shree.ecom.activityMain.module.ActivityMainModule;
import com.shree.ecom.activityMyCart.MyCartActivity;
import com.shree.ecom.activityMyCart.module.MyCartModule;
import com.shree.ecom.activityMyOrders.module.MyOrdersApiModule;
import com.shree.ecom.activityMyOrders.module.MyOrdersModule;
import com.shree.ecom.activityMyOrders.views.MyOrdersActivity;
import com.shree.ecom.activityProductDetail.module.ProductDetailApiModule;
import com.shree.ecom.activityProductDetail.module.ProductDetailModule;
import com.shree.ecom.activityProfile.module.ProfileApiModule;
import com.shree.ecom.activityProfile.module.ProfileModule;
import com.shree.ecom.activityProfile.view.ProfileActivity;
import com.shree.ecom.activityRent.RentActivity;
import com.shree.ecom.activityRent.module.RentApiModule;
import com.shree.ecom.activityRent.module.RentModule;
import com.shree.ecom.activityRequestProduct.RequestProductActivity;
import com.shree.ecom.activityRequestProduct.module.RequestProductApiModule;
import com.shree.ecom.activityRequestProduct.module.RequestProductModule;
import com.shree.ecom.activitySearch.module.SearchApiModule;
import com.shree.ecom.activitySearch.module.SearchModule;
import com.shree.ecom.activitySearch.view.SearchScreenActivity;
import com.shree.ecom.activitySellRegister.module.SellerRegisterApiModule;
import com.shree.ecom.activitySellRegister.module.SellerRegisterModule;
import com.shree.ecom.activitySellRegister.view.RegisterSellerActivity;
import com.shree.ecom.activitySignUp.module.SignUpApiModule;
import com.shree.ecom.activitySignUp.module.SignUpModule;
import com.shree.ecom.activitySignUp.view.CredentialSignUpActivity;
import com.shree.ecom.activityWhishlist.module.addWishlist.WishlistApiModule;
import com.shree.ecom.activityWhishlist.module.addWishlist.WishlistModule;
import com.shree.ecom.activityWhishlist.module.cancelWishlist.CancelWishlistApiModule;
import com.shree.ecom.activityWhishlist.module.cancelWishlist.CancelWishlistModule;
import com.shree.ecom.activityWhishlist.module.showWishlist.MyWishlistApiModule;
import com.shree.ecom.activityWhishlist.module.showWishlist.MyWishlistModule;
import com.shree.ecom.activityWhishlist.view.CancelWishlistActivity;
import com.shree.ecom.activityWhishlist.view.WishlistActivity;
import com.shree.ecom.categories.module.CategoryModule;
import com.shree.ecom.categories.module.EquipmentModule;
import com.shree.ecom.categories.module.api.CategoryApiModule;
import com.shree.ecom.categories.module.api.EquipmentApiModule;
import com.shree.ecom.categories.view.CategoriesFragment;
import com.shree.ecom.categories.view.fragments.EquipmentFragment;
import com.shree.ecom.checkout.module.CheckoutApiModule;
import com.shree.ecom.checkout.module.CheckoutModule;
import com.shree.ecom.contacts.activityContactUs.module.ContactUsApiModule;
import com.shree.ecom.contacts.activityContactUs.module.ContactUsModule;
import com.shree.ecom.contacts.activityContactUs.view.ContactUsActivity;
import com.shree.ecom.contacts.activityPolicy.module.PolicyApiModule;
import com.shree.ecom.contacts.activityPolicy.module.PolicyModule;
import com.shree.ecom.contacts.activityPolicy.view.PoliciesActivity;
import com.shree.ecom.home.module.FeaturedProductModule;
import com.shree.ecom.home.module.LatestProductModule;
import com.shree.ecom.home.module.api.FeaturedProductApiModule;
import com.shree.ecom.home.module.api.LatestProductApiModule;
import com.shree.ecom.home.view.HomeFragment;
import com.shree.ecom.profile.view.ProfileFragment;
import com.shree.ecom.reviews.module.ReviewsApiModule;
import com.shree.ecom.reviews.module.ReviewsModule;
import com.shree.ecom.similarProducts.module.SimilarProductsApiModule;
import com.shree.ecom.similarProducts.module.SimilarProductsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,
        CategoryModule.class, CategoryApiModule.class,
        SignUpModule.class, SignUpApiModule.class,
        LoginModule.class, LoginApiModule.class,
        PolicyModule.class, PolicyApiModule.class,
        ContactUsModule.class, ContactUsApiModule.class,
        EquipmentModule.class, EquipmentApiModule.class,
        RentalModule.class, RentalApiModule.class,
        AllEquipmentProductModule.class, AllEquipmentProductApiModule.class,
        ReviewsModule.class, ReviewsApiModule.class,
        ActivityMainModule.class, ActivityMainApiModule.class,
        MyOrdersModule.class, MyOrdersApiModule.class,
        LatestProductModule.class, LatestProductApiModule.class,
        FeaturedProductModule.class, FeaturedProductApiModule.class,
        CancelOrderModule.class, CancelOrderApiModule.class,
        ProfileModule.class, ProfileApiModule.class,
        NewProductModule.class, NewProductApiModule.class,
        UsedProductModule.class, UsedProductApiModule.class,
        MyWishlistModule.class, MyWishlistApiModule.class,
        WishlistModule.class, WishlistApiModule.class,
        CancelWishlistModule.class, CancelWishlistApiModule.class,
        ProductDetailModule.class, ProductDetailApiModule.class,
        RentModule.class, RentApiModule.class,
        RequestProductModule.class, RequestProductApiModule.class,
        SearchModule.class, SearchApiModule.class,
        SellerRegisterModule.class, SellerRegisterApiModule.class,
        CartApiModule.class, CartProceedModule.class,
        SimilarProductsModule.class, SimilarProductsApiModule.class,
        CheckoutModule.class, CheckoutApiModule.class,
        MyCartModule.class
})
public interface ApplicationComponent {

    void inject(HomeFragment homeFragment);

    void inject(CategoriesFragment categoriesFragment);

    void inject(CredentialSignUpActivity credentialSignUpActivity);

    void inject(LoginActivity loginActivity);

    void inject(PoliciesActivity policiesActivity);

    void inject(ContactUsActivity contactUs);

    void inject(EquipmentFragment equipmentFragment);

    void inject(RentalEquipmentActivity rentalEquipmentActivity);

    void inject(AllEquipmentProductActivity allEquipmentProductActivity);

    void inject(BrowseFragment browseFragment);

    void inject(ProductDetailActivity productDetailActivity);

    void inject(MyOrdersActivity myOrdersActivity);

    void inject(Main2Activity main2Activity);

    void inject(CancelOrderActivity cancelOrderActivity);

    void inject(ProfileActivity profileActivity);

    void inject(NewEquipmentActivity newEquipmentActivity);

    void inject(UsedEquipmentActivity usedEquipmentActivity);

    void inject(WishlistActivity wishlistActivity);

    void inject(CancelWishlistActivity cancelWishlistActivity);

    void inject(MyCartActivity myCartActivity);

    void inject(RentActivity rentActivity);

    void inject(RequestProductActivity requestProductActivity);

    void inject(SearchScreenActivity searchScreenActivity);

    void inject(RegisterSellerActivity registerSellerActivity);

    void inject(CartProceedActivity cartProceedActivity);

    void inject(ProfileFragment profileFragment);

}
