/* =================================================================================================
Created by Thomas on 03/30/2015.
Purpose: Save preference even if the software turned off
================================================================================================= */

package com.thomas.moderartui.lib;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


public abstract class Memory extends Activity {
	private final static String TAG = "ModerArtUI";
	private Context context;

	public static boolean setPreference(String key, int value, Context context) {
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
	public static int getPreference_int(String key, Context context) {
		try {
			SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
			return preferences.getInt(key, 0);
		} catch (Exception name) {
			Log.e(TAG, "memory > getPreference_int() > FAILED:" + key);
		}
		return 0;
	}
}