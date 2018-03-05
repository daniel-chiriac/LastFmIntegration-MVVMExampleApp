package com.chiriacd.lastfmexampleapp.utils;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class NavigationUtils {

    private static final String LOG_TAG = "NavigationUtils";

    //todo this should be part of a Navigator class and not static
    public static void openWebBrowser(Context context, String url) {
        if (url != null) {
            try {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(url));
               context.startActivity(intent);
            } catch (Exception e) {
                Log.d(LOG_TAG, "Bad url: " + url);
            }
        }
    }
}
