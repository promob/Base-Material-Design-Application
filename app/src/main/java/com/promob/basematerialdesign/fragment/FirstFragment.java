package com.promob.basematerialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.promob.basematerialdesign.R;
import com.promob.basematerialdesign.custom.BaseFragment;

/**
 * Created by Laptop on 26/09/2015.
 *
 * @author Süleyman Bilgin
 * @since 1.0
 */
public class FirstFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);

        return view;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void actions() {

    }

    @Override
    public void functions() {

    }

    @Override
    public void onClick(View v) {

    }
}
