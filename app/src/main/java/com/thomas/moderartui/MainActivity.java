package com.thomas.moderartui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;


public class MainActivity extends Activity implements OnSeekBarChangeListener {
	private Button buttonTopleft		= null;
	private Button buttonBottomleft		= null;
	private Button buttonTopRight		= null;
	private Button buttonCenterRight	= null;
	private Button buttonBottomRight	= null;

	private SeekBar colorControl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		/* =================================================================
		SETUP VARIABLES
		================================================================= */

		buttonTopleft		= (Button) findViewById(R.id.buttonTopleftID);
		buttonBottomleft	= (Button) findViewById(R.id.buttonBottomleftID);
		buttonTopRight		= (Button) findViewById(R.id.buttonTopRightID);
		buttonCenterRight	= (Button) findViewById(R.id.buttonCenterRightID);
		buttonBottomRight	= (Button) findViewById(R.id.buttonBottomRightID);

		colorControl = (SeekBar) findViewById(R.id.colorControlID);

		/* =================================================================
		SET LISTENERS
		================================================================= */

		colorControl.setOnSeekBarChangeListener(this);

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
				Toast.makeText(getApplicationContext(), R.string.action_creditsNames, Toast.LENGTH_SHORT).show();
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

	/* =================================================================
	SEEK BAR
	================================================================= */

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		double opacityPercentage_d	= (100- (double)progress) /100;
		float opacityPercentage_f	= (float)opacityPercentage_d;

		//Alpha is the percentage of opacity
		buttonTopleft.setAlpha(opacityPercentage_f);
		buttonBottomleft.setAlpha(opacityPercentage_f);
		buttonTopRight.setAlpha(opacityPercentage_f);
		buttonCenterRight.setAlpha(opacityPercentage_f);
		buttonBottomRight.setAlpha(opacityPercentage_f);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
	}
}
