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

import com.promob.basematerialdesign.custom.BaseActivity;
import com.promob.basematerialdesign.fragment.FirstFragment;
import com.promob.basematerialdesign.fragment.SecondFragment;
import com.promob.basematerialdesign.fragment.ThreeFragment;

public class MainActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private static final long DRAWER_CLOSE_DELAY_MS = 250;
    private static final String NAV_ITEM_ID = "navItemId";

    private final Handler mDrawerActionHandler = new Handler();
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mNavItemId;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        // İlk başta hangi fragment açılacaksa o belirleniyor.
        if (null == savedInstanceState) {
            mNavItemId = R.id.first; //Drawer'daki id'ye göre
        } else {
            mNavItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }
        drawerLayoutSetup();
    }

    void init() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));
    }

    /**
     * Bu metod navigation drawerı oluşturuyor
     */
    public void drawerLayoutSetup() {
        // Navigasyon olaylarını dinler
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        // navigasyon elemanı seçimi
        navigationView.getMenu().findItem(mNavItemId).setChecked(true);

        // hamburger ikonu aç kapa
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open,
                R.string.close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
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
                getSupportActionBar().setTitle(getString(R.string.app_name));
                break;
            case R.id.second:
                f = new SecondFragment();
                launchFragment(f, R.string.second);
                getSupportActionBar().setTitle(getString(R.string.app_name));
                break;
            case R.id.three:
                f = new ThreeFragment();
                launchFragment(f, R.string.three);
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

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
