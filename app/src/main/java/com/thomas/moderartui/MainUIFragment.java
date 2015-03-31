/* =================================================================================================
Created by Thomas on 03/30/2015.
Purpose: Main fragment
================================================================================================= */

package com.thomas.moderartui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

/**
 * Created by Thomas on 03/30/2015.
 */
public class MainUIFragment extends Fragment {
	private final static String TAG = "ModerArtUI";
	private Context context;
	private Button buttonTopleft		= null;
	private Button buttonBottomleft		= null;
	private Button buttonTopRight		= null;
	private Button buttonCenterRight	= null;
	private Button buttonBottomRight	= null;

	private SeekBar colorsSeekBar		= null;
	private int progressValue			= 0;
	private static final String PROGRESS_VALUE = "progressValue";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		context = container.getContext();
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

		/* =================================================================
		SETUP VARIABLES
		================================================================= */

		buttonTopleft		= (Button) rootView.findViewById(R.id.buttonTopleftID);
		buttonBottomleft	= (Button) rootView.findViewById(R.id.buttonBottomleftID);
		buttonTopRight		= (Button) rootView.findViewById(R.id.buttonTopRightID);
		buttonCenterRight	= (Button) rootView.findViewById(R.id.buttonCenterRightID);
		buttonBottomRight	= (Button) rootView.findViewById(R.id.buttonBottomRightID);
		colorsSeekBar = (SeekBar) rootView.findViewById(R.id.colorsSeekBarID);

		/* =================================================================
		SET LISTENERS
		================================================================= */

		colorsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				progressValue = progress;
				ColorTransform(progressValue);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});

		if( savedInstanceState != null ){
			progressValue = savedInstanceState.getInt(PROGRESS_VALUE);
			ColorTransform(progressValue);
		}

		return rootView;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt (PROGRESS_VALUE, progressValue);
	}

	// =============================================================================================

	private void ColorTransform(int percentage) {
		double opacityPercentage_d	= (100- (double)progressValue) /100;
		float opacityPercentage_f	= (float)opacityPercentage_d;

		//Alpha is the percentage of opacity
		buttonTopleft.setAlpha(opacityPercentage_f);
		buttonBottomleft.setAlpha(opacityPercentage_f);
		buttonTopRight.setAlpha(opacityPercentage_f);
		buttonCenterRight.setAlpha(opacityPercentage_f);
		buttonBottomRight.setAlpha(opacityPercentage_f);
	}
}
