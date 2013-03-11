package com.example.android_lesson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Test_StartActivity extends Activity implements OnClickListener {

	// declare variables
	TextView des;
	EditText input;
	Button pass;

	// declare String for passing
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.test_start_activity);

		initialize();

	}

	private void initialize() {
		// TODO Auto-generated method stub

		// variables & views
		des = (TextView) findViewById(R.id.describe_1);
		input = (EditText) findViewById(R.id.passInput_1);
		pass = (Button) findViewById(R.id.pass_1);

		// buttons & listener
		pass.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.pass_1:
			// get string from edit text input
			String ball;
			ball = input.getText().toString();

			// set a bundle to carry this string
			// putString("key for access",data need to be pass)
			Bundle wind = new Bundle();
			wind.putString("balls_in_wind", ball);

			// create a intent to trigger startActivity
			Intent pitch = new Intent(Test_StartActivity.this,
					Test_StartActivityGet.class);
			pitch.putExtras(wind);
			startActivity(pitch);

			break;

		}
	}

}
