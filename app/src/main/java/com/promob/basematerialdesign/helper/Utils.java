package com.promob.basematerialdesign.helper;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

/**
 * Created by user on 25/08/2016.
 */
public class Utils {
    /**
     * Uygulamanın hangi durumda geliştirildiğinin bulunduğu utildir. İki tür status vardır.
     * <p/>
     * 1) development
     * 2) production
     *
     * @return true  -> production
     * false -> development
     */
    public static boolean isAppDevelopment() {
        return Constant.development;
    }

    /**
     * Ekranda uyarı çıkarmak için kullanılmaktadır.
     * Herhangi bir activity ya da fragmentte bu fonksiyonu kullanarak uyarı mesajı çıkarılabilir.
     * Bazı cihazlarda Snackbar hata verdiği için try catch ile kullandıldı. Snackbar'ın çıkmadığı
     * cihazlarda Toast mesajı verir. Bu sayede muhtemel çıkacak hatalardan kaçınmış oluyoruz.
     *
     * @param mActivity      Utilin kullanılacağı ekranda alınması gereklidir.
     *                       <p/>
     *                       1) Eğer bu util activity içerisinde kullanılıyorsa this
     *                       kullanılabilir.
     *                       <p/>
     *                       2) Fragment içinde kullanılıyorsa üzerinde çalıştığı activityi
     *                       göndermek gereklidir. (MainActivity) getActivity(); şeklinde
     *                       kullanılmalıdır.
     * @param textResourseID strings.xml içine yazılan string R.string.blabla şeklinde alınır
     */
    public static void messageToUser(Activity mActivity, int textResourseID) {
        try {
            Snackbar.make(mActivity.findViewById(android.R.id.content),
                    mActivity.getResources().getString(textResourseID), Snackbar.LENGTH_LONG)
                    .show();
        } catch (Exception ex) {
            Toast.makeText(mActivity, mActivity.getResources().getString(textResourseID),
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Cihazın internet erişimi olup olmadığını kontrol eder. İnternete bağlılık durumuna göre true
     * ya da false değer döndürmektedir.
     *
     * @param mActivity activity üzerinde this
     *                  fragment üzerinde (MainActivity) getActivity(); şeklinde gönderilmelidir.
     * @return true veya false
     */
    public static boolean isOnline(Activity mActivity) {
        ConnectivityManager cm =
                (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
