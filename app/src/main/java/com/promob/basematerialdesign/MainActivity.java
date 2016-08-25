package com.promob.basematerialdesign;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.promob.basematerialdesign.custom.BaseActivity;
import com.promob.basematerialdesign.fragment.FirstFragment;
import com.promob.basematerialdesign.fragment.SecondFragment;
import com.promob.basematerialdesign.fragment.ThreeFragment;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private static final long DRAWER_CLOSE_DELAY_MS = 250;
    private static final String NAV_ITEM_ID = "navItemId";

    private final Handler mDrawerActionHandler = new Handler();
    private DrawerLayout mDrawerLayout;
    private int mNavItemId;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        // İlk başta hangi fragment açılacaksa o belirleniyor.
        if (null == savedInstanceState) {
            mNavItemId = R.id.first; //Drawer'daki id'ye göre
        } else {
            mNavItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }
        drawerLayoutSetup();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(getString(R.string.app_name));
    }

    @Override
    public void actions() {

    }

    @Override
    public void functions() {

    }

    /**
     * Bu metod navigation drawerı oluşturuyor
     */
    public void drawerLayoutSetup() {
        // Navigasyon olaylarını dinler
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        if (navigationView != null)
            navigationView.setNavigationItemSelectedListener(this);

        // navigasyon elemanı seçimi
        if (navigationView != null)
            navigationView.getMenu().findItem(mNavItemId).setChecked(true);

        // hamburger ikonu aç kapa
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        navigate(mNavItemId);
    }

    /**
     * Bu metod fragmenti activiteye tutturur. İsteklerinize göre özelleştirebilirsiniz.
     *
     * @param itemId navigasyon drawerdaki itemın id'si
     */
    private void navigate(final int itemId) {
        Fragment f = null;
        switch (itemId) {
            case R.id.first:
                f = new FirstFragment();
                launchFragment(f, R.string.first);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(getString(R.string.app_name));
                break;
            case R.id.second:
                f = new SecondFragment();
                launchFragment(f, R.string.second);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(getString(R.string.app_name));
                break;
            case R.id.three:
                f = new ThreeFragment();
                launchFragment(f, R.string.three);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(getString(R.string.app_name));
                break;
            default:
        }
    }

    /**
     * Fragmenti çalıştırır
     *
     * @param f        Seçilen fragmenti alır
     * @param title_id string id'si alır
     */
    public void launchFragment(Fragment f, int title_id) {
        if (f != null) {
            while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, f).addToBackStack(getResources().getString(title_id))
                    .commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
        // update highlighted item in the navigation menu
        menuItem.setChecked(true);
        mNavItemId = menuItem.getItemId();

        // allow some time after closing the drawer before performing real navigation
        // so the user can see what is happening
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigate(menuItem.getItemId());
            }
        }, DRAWER_CLOSE_DELAY_MS);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
