/* =================================================================================================
Created by Thomas on 03/30/2015.
Purpose: Make a program like https://d396qusza40orc.cloudfront.net/android/Labs/ModernArtUI/modernUI.mp4 for Coursera
Personal note: This code is based on "fragment manager"
================================================================================================= */

package com.thomas.moderartui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.Toast;

import com.thomas.moderartui.lib.L;


public class MainActivity extends Activity {
	private FragmentManager manager;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.activity_main);

	   //Main page
	   if (savedInstanceState == null) {
		   manager		= getFragmentManager();
		   manager.beginTransaction()
			   .add(R.id.mainContainer, new MainUIFragment())
			   .commit();
	   }

	   //Action menu/bar (Just for learning. You can avoid all lines except the last one)
	   ActionBar actionBar = getActionBar();
	   actionBar.setTitle("Modern Art UI");
	   actionBar.setSubtitle("Thomas version");
	   //actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE) );
	   //actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(65,77,185)) );
	   actionBar.setBackgroundDrawable(new ColorDrawable(R.color.bgDefault2) );
	   actionBar.show();
	   //actionBar.setDisplayShowHomeEnabled(true);
	   getOverflowMenu();
	}

	/* =================================================================
	ACTION MENU/BAR (= bottom menu on my cellphone)
	================================================================= */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId())
		{
			case R.id.action_moreInfoID:
				Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
				startActivity(intent);
				break;
			case R.id.action_creditsID:
				//R.string.* is a reference to an int in R.java that points to your actual String.
				L.t(getApplicationContext(), getString(R.string.action_creditsNames) );
				break;
			case R.id.action_exitID:
				finish();			//close activity
				System.exit(0);		//close application
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	// put the other two menu on the three dots (overflow) SOURCE: https://www.codeofaninja.com/2014/02/android-action-bar-tutorial-with-22.html
	private void getOverflowMenu() {
		try {

			ViewConfiguration config = ViewConfiguration.get(this);
			java.lang.reflect.Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
			if(menuKeyField != null) {
				menuKeyField.setAccessible(true);
				menuKeyField.setBoolean(config, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}