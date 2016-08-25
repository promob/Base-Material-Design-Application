package com.promob.basematerialdesign;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.promob.basematerialdesign.helper.Constant;

import io.fabric.sdk.android.Fabric;

/**
 * Uygulama çalıştığında her zaman ilk başta çalışan sınıftır. Görüldüğü üzere Application
 * classın'dan extend oluyor. Uygulama ilk çalışınca çalışacağını ise Manisfest dosyasından
 * belirliyoruz.
 * <p/>
 * Created by user on 27/07/2016.
 *
 * @author Süleyman Bilgin
 * @since 1.0
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (Constant.fabric)
            Fabric.with(this, new Crashlytics());
    }
}
