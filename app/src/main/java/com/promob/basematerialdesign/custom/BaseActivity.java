package com.promob.basematerialdesign.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;

/**
 * Uygulamadaki bütün activityler bu classtan miras alınacaktır.
 * <p/>
 * Created by Laptop on 26/09/2015.
 *
 * @author Süleyman Bilgin
 * @since 1.0
 */
public class BaseActivity extends AppCompatActivity {
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
}
