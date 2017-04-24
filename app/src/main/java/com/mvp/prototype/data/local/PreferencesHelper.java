
package com.mvp.prototype.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.mvp.prototype.Constants;

public class PreferencesHelper {
    private final static String PREF_FILE = Constants.PREF_FILE_NAME;


    public static void setSharedPreferenceString(Context context, String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }


    public static String getSharedPreferenceString(Context context, String key) {
        String defValue = null;
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        String value = settings.getString(key, defValue);
        return value;
    }

}
