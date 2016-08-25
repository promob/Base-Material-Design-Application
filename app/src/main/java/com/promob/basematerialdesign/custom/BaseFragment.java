package com.promob.basematerialdesign.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;

/**
 * Uygulama içinde oluşturulacak bütün fragmentler bu classtan miras alınarak yapılacaktır.
 * <p/>
 * Created by Laptop on 26/09/2015.
 *
 * @author Süleyman Bilgin
 * @since 1.0
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    /**
     * <h1>mRequestQueue</h1>
     * <p/>
     * mRequestQueue değişkeni network işlemlerinde kullanılmaktadır.
     * Herhangi bir fragment bu classtan miras alındığı zaman değişken tanımlaması gerekmemektedir.
     * <p/>
     * Sadece diğer fragmenlerde aşağıdaki şekilde başlangıç(initialize) haline getirilmelidir. Yoksa network işlemlerinde hata alınır.
     * <p/>
     * mRequestQueue = new Volley().newRequestQueue(getActivity());
     */
    public RequestQueue mRequestQueue;

    /**
     * Miras alınan fragmentlerde onCreateView fonksiyonu altında fragmentlere layout tanımlaması yapmak için bu değişken kullanılması gerekmektedir.
     */
    public View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public abstract void initialize();

    public abstract void initViews();

    public abstract void actions();

    public abstract void functions();
}
