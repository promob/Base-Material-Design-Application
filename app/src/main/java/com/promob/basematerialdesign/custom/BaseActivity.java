package com.promob.basematerialdesign.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.volley.RequestQueue;

/**
 * Uygulamadaki bütün activityler bu classtan miras alınacaktır.
 * <p/>
 * Created by Laptop on 26/09/2015.
 *
 * @author Süleyman Bilgin
 * @since 1.0
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * mRequestQueue değişkeni network işlemlerinde kullanılmaktadır.
     * Herhangi bir activity bu classtan miras alındığı zaman değişken tanımlaması gerekmemektedir.
     * <p/>
     * Sadece diğer activityde başlangıç(initialize) haline getirilmelidir. Yoksa network işlemlerinde hata alınır.
     * <p/>
     * mRequestQueue = new Volley().newRequestQueue(getApplicationContext());
     */
    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public abstract void initialize();

    public abstract void initViews();

    public abstract void actions();

    public abstract void functions();

}
