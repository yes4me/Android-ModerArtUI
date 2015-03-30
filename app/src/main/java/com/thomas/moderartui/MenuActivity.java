package com.thomas.moderartui;

/**
 * Created by Thomas on 03/14/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Thomas on 03/14/2015.
 */
public class MenuActivity extends Activity implements View.OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_moreinfo);

		Button buttonSubmit	= (Button) findViewById(R.id.action_buttonSubmitID);
		Button buttonCancel	= (Button) findViewById(R.id.action_buttonCancelID);
		buttonSubmit.setOnClickListener(this);
		buttonCancel.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		Intent intent = null;
		Intent chooser = null;        //A menu is supposed to popup and give the user the choice to pick what software to run

		switch (view.getId()) {
			case R.id.action_buttonSubmitID:
				intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.moma.org"));
				chooser = Intent.createChooser(intent, "View WEB");
				startActivity(chooser);

				finish();
				break;
			case R.id.action_buttonCancelID:
				finish();
				break;
		}
	}
}