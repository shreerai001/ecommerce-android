package com.shree.ecom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.shree.ecom.activityLogin.LoginActivity;
import com.shree.ecom.activityMain.contract.ActivityMainContract;
import com.shree.ecom.activityMain.view.adapter.NavMenuExpandableAdapter;
import com.shree.ecom.activityMyCart.MyCartActivity;
import com.shree.ecom.activityMyOrders.views.MyOrdersActivity;
import com.shree.ecom.activityProfile.model.dto.ProfileDataDto;
import com.shree.ecom.activityProfile.view.ProfileActivity;
import com.shree.ecom.activitySearch.view.SearchScreenActivity;
import com.shree.ecom.activityBrowse.BrowseFragment;
import com.shree.ecom.activityWhishlist.view.WishlistActivity;
import com.shree.ecom.buySell.view.BuySellFragment;
import com.shree.ecom.categories.contract.CategoriesContract;
import com.shree.ecom.categories.model.dto.CategoryDto;
import com.shree.ecom.home.view.HomeFragment;

import javax.inject.Inject;

import com.shree.ecom.profile.view.ProfileFragment;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.CONST;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ActivityMainContract.View, CategoriesContract.View {
    private NavMenuExpandableAdapter navMenuExpandableAdapter;
    private DrawerLayout drawer;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentManager homeManager = getSupportFragmentManager();
                    FragmentTransaction homeTransaction = homeManager.beginTransaction();
                    homeTransaction.replace(R.id.frame_layout, new HomeFragment());
                    homeTransaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    FragmentManager buySellManager = getSupportFragmentManager();
                    FragmentTransaction buySellTransaction = buySellManager.beginTransaction();
                    buySellTransaction.replace(R.id.frame_layout, new BuySellFragment());
                    buySellTransaction.commit();
                    return true;
                case R.id.browse:
                    FragmentManager browseManager = getSupportFragmentManager();
                    FragmentTransaction buySellTranscation = browseManager.beginTransaction();
                    buySellTranscation.replace(R.id.frame_layout, new BrowseFragment());
                    buySellTranscation.commit();
                    return true;
                case R.id.navigation_about:
                    if (presenter.checkedLogged()) {
                        FragmentManager aboutManager = getSupportFragmentManager();
                        FragmentTransaction aboutTranscation = aboutManager.beginTransaction();
                        aboutTranscation.replace(R.id.frame_layout, new ProfileFragment());
                        aboutTranscation.commit();
                    } else {
                        startActivity(new Intent(Main2Activity.this, LoginActivity.class));
                    }
                    return true;
            }
            return false;
        }
    };

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private CircleImageView imageView_account;
    private TextView userName;
    private TextView email_v;

    @Inject
    ActivityMainContract.Presenter presenter;

    @Inject
    CategoriesContract.Presenter presenterCategories;

    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    TextView textCartItemCount;
    int mCartItemCount = 10;
    private long timeStamp;

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.timeStamp = System.currentTimeMillis();
        presenter.setView(this);
        presenterCategories.setView(this);
        if (isUpToDate()) {
            presenterCategories.loadData();
        }
        if (presenter.checkedLogged()) {
            presenter.saveProfileDetail();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View view = navigationView.getHeaderView(0);
        initView(view);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimaryDark));
        navigationView.setNavigationItemSelectedListener(this);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment();
    }


    Animation rotateUp;
    Animation rotateDown;

    private void setSideNav(CategoryDto subCategory) {

        navMenuExpandableAdapter = new NavMenuExpandableAdapter(this);
        expandableListView.setAdapter(navMenuExpandableAdapter);
        expandableListView.setScrollContainer(false);
        navMenuExpandableAdapter.setValues(subCategory.getData());
        rotateDown = AnimationUtils.loadAnimation(this, R.anim.rotate_down);
        rotateUp = AnimationUtils.loadAnimation(this, R.anim.rotate_up);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                final ImageView imageView = v.findViewById(R.id.image_icon);
                if (parent.isGroupExpanded(groupPosition)) {
                    imageView.startAnimation(rotateUp);
                    imageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                } else {
                    imageView.startAnimation(rotateUp);
                    imageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                }
                return false;
            }
        });

    }

    public void closeDrawer() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    /**
     * set up cart size badge on cart icon
     */
    private void setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_cart) {
            startActivity(new Intent(Main2Activity.this, MyCartActivity.class));
            Log.i(Main2Activity.class.getCanonicalName(), "onOptionsItemSelected");
        }
        if (id == R.id.action_search) {
            if (presenter.checkedLogged()) {
                startActivity(new Intent(Main2Activity.this, SearchScreenActivity.class));
            } else {
                startActivity(new Intent(Main2Activity.this, LoginActivity.class));
            }
        }
        if (id == R.id.action_wishlist) {
            if (presenter.checkedLogged()) {
                startActivity(new Intent(Main2Activity.this, WishlistActivity.class));
            } else {
                startActivity(new Intent(Main2Activity.this, LoginActivity.class));
            }
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(Main2Activity.this, MyOrdersActivity.class));

        } else if (id == R.id.wishlist) {
            startActivity(new Intent(Main2Activity.this, WishlistActivity.class));
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void initView(View view) {
        imageView_account = view.findViewById(R.id.account);
        userName = view.findViewById(R.id.username);
        email_v = view.findViewById(R.id.email);

        imageView_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenter.checkedLogged()) {
                    startActivity(new Intent(Main2Activity.this, ProfileActivity.class));
                } else {
                    startActivity(new Intent(Main2Activity.this, LoginActivity.class));
                }
            }

        });
    }

    @Override
    public void loadFragment() {
        FragmentManager homeManager = getSupportFragmentManager();
        FragmentTransaction homeTransaction = homeManager.beginTransaction();
        homeTransaction.replace(R.id.frame_layout, new HomeFragment());
        homeTransaction.commit();
    }

    @Override
    public void loadProfileIfLogged(ProfileDataDto profileEntityObservable) {
        userName.setText(profileEntityObservable.getFirst_name() + " " + profileEntityObservable.getLast_name());
        email_v.setText(profileEntityObservable.getEmail());
        Picasso.with(getApplicationContext()).load(profileEntityObservable.getImage()).into(imageView_account);
    }


    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void displayTransferMessage(String message) {

    }

    @Override
    public void progressOn(boolean progressState) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void updateCategories(CategoryDto categoryDtoList) {
        setSideNav(categoryDtoList);

    }
}
