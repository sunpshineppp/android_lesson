package com.example.android_lesson;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class StartingPoing extends Activity {

	@Override
	//TEST GIT COMMIT 20130216 13:58 NB
	//TEST GIT COMMIT 20130216 23:24 PC
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starting_poing);
	}

	@Override
	//TEST GIT COMMIT 20130216 13:58 NB
	//TEST GIT COMMIT 20130216 23:24 PC
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_starting_poing, menu);
		return true;
	}

}
