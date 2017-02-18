package storage.com.finalstorage.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by uukeshov on 18.02.2017.
 */

public class CheckInternetConnection {
    private Boolean isOnline = false;

    public boolean hasConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                isOnline = true;
            }
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                isOnline = true;
            }
        }
        return isOnline;
    }
}
