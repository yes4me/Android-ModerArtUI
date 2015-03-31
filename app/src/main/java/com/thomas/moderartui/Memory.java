package com.thomas.moderartui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by Thomas on 03/30/2015.
 */
public class Memory extends Activity {
	private final static String TAG = "ModerArtUI";

	public static boolean setPreference_int(String key, int value, Context context) {
		try {
			SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
			SharedPreferences.Editor editor = preferences.edit();
			editor.putInt(key, value);
			editor.commit();
			return true;
		} catch (Exception name) {
			Log.e(TAG, "memory > setPreference_boolean() > FAILED:" + key + "/" + value);
		}
		return false;
	}
}
