/* =================================================================================================
Created by Thomas on 03/30/2015.
Purpose: Shortcut to display stuff
================================================================================================= */

package com.thomas.moderartui.lib;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class L {
	private final static String TAG = "ModerArtUI";
	public static void m(String message) {
		Log.d(TAG, "" + message);
	}

	public static void t(Context context, String message) {
		Toast.makeText(context, message + "", Toast.LENGTH_SHORT).show();
	}

	public static void T(Context context, String message) {
		Toast.makeText(context, message + "", Toast.LENGTH_LONG).show();
	}
}