package com.example.android_lesson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class RunAndHit extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	// set runner`s view variables
	TextView runnerOpen;
	EditText runnerNameInput;
	RadioGroup runnerChoices;
	Button runnerActing;

	// set batter`s passing variables
	String setBatterAct;
	String bName;
	String bAct;

	// set runner`s passing variables
	String setRunnerAct;
	String rName;
	String rAct;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.run_and_hit);

		initialize();
		
		// open the bundle, get string, set text view
		Bundle getPitch = getIntent().getExtras();
		setBatterAct = getPitch.getString("BatterAct"); 
		runnerOpen.setText(setBatterAct);

	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		// variables & views
		runnerOpen = (TextView) findViewById(R.id.RunnerView);
		runnerNameInput = (EditText) findViewById(R.id.RunnerName);
		runnerChoices = (RadioGroup) findViewById(R.id.rbuRunner);
		runnerActing = (Button) findViewById(R.id.buRunnerAct);
		
		// button & listener
		runnerActing.setOnClickListener(this);
		runnerChoices.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {

		case R.id.buRunnerAct:
			
			
			
			// set a bundle to carry this string
			// putString("key for access",data need to be pass)
			Bundle status_r = new Bundle();
			status_r.putString("RunnerAct", setRunnerAct);
			status_r.putString("BatterAct", setBatterAct);
			
			Intent go_hit = new Intent(RunAndHit.this, HitAndRun.class);
			go_hit.putExtras(status_r);
			
			startActivity(go_hit);
		
			break;

		}

	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub

		switch (arg1) {

		case R.id.rbuRunner_1:

			setRunnerAct = " is running back to home base madly !";

			break;
		case R.id.rbuRunner_2:

			setRunnerAct = " is run through bases gracefully ~";

			break;
		case R.id.rbuRunner_3:

			setRunnerAct = " is staying holded.";

			break;

		}
		;

	}

}
