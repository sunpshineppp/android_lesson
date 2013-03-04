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

	// get game started or not

	String gameStart;

	// set batter`s view variables
	TextView batterOpen;
	EditText batterNameInput;
	RadioGroup batterChoices;
	Button batterActing;

	// set batter`s passing variables
	String setBatterAct;
	String bName;
	String bAct;

	// set runner`s view variables
	TextView runnerOpen;
	EditText runnerNameInput;
	RadioGroup runnerChoices;
	Button runnerActing;

	// set runner`s passing variables
	String setRunnerAct;
	String rName;
	String rAct;

	// set string array for pass bundle
	String[] gameStatus_r = { gameStart, setBatterAct, bName, bAct,
			setRunnerAct, rName, rAct };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.run_and_hit);

		initialize();

	}

	private void initialize() {
		// TODO Auto-generated method stub

		runnerOpen = (TextView) findViewById(R.id.RunnerView);
		runnerNameInput = (EditText) findViewById(R.id.RunnerName);
		runnerChoices = (RadioGroup) findViewById(R.id.rbuRunner);
		runnerActing = (Button) findViewById(R.id.buRunnerAct);
		runnerActing.setOnClickListener(this);
		runnerChoices.setOnCheckedChangeListener(this);

		if (gameStart == null) {
			// if game first time start, set open
			runnerOpen.setText("the Ball is hit !!");
		} else {

			// set a bundle to get a bundle
			Bundle getGameStatus = this.getIntent().getExtras();
			String[] status = getGameStatus.getStringArray("status_b");

			// merge 2 bundles
			int count = status.length;
			for (int i = 0; i < count; i++) {
				gameStatus_r[i] = status[i];
			}

			// if game already started, use string array to get bundle from
			// the other activity.
			runnerOpen.setText(rAct);

		}

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {

		case R.id.buRunnerAct:
			// get data by listeners
			gameStatus_r[0] = "playball !";

			rName = runnerNameInput.getText().toString();

			rAct = rName + " " + setRunnerAct;

			// put data into bundle
			Bundle bundle = new Bundle();

			bundle.putStringArray("status_r", gameStatus_r);

			Intent intent = new Intent(RunAndHit.this, HitAndRun.class);
			intent.putExtras(bundle);
			startActivity(intent);

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
