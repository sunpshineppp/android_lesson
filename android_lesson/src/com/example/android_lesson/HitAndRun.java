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

public class HitAndRun extends Activity implements OnClickListener,
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
	String[] gameStatus_b = { gameStart, setBatterAct, bName, bAct,
			setRunnerAct, rName, rAct };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.hit_and_run);

		initialize();

	}

	private void initialize() {
		// TODO Auto-generated method stub

		batterOpen = (TextView) findViewById(R.id.BatterView);
		batterNameInput = (EditText) findViewById(R.id.BatterName);
		batterChoices = (RadioGroup) findViewById(R.id.rbuBatter);
		batterActing = (Button) findViewById(R.id.buBatterAct);
		batterActing.setOnClickListener(this);
		batterChoices.setOnCheckedChangeListener(this);

		if (gameStart == null) {
			// if game first time start, set open
			batterOpen.setText("the Ball is coming !!");
		} else {

			// set a bundle to get a bundle
			Bundle getGameStatus = this.getIntent().getExtras();
			String[] status = getGameStatus.getStringArray("status_r");

			// merge 2 bundles
			int count = status.length;
			for (int i = 0; i < count; i++) {
				gameStatus_b[i] = status[i];
			}

			// if game already started, use string array to get bundle from
			// the other activity.
			batterOpen.setText(rAct);

		}

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {

		case R.id.buBatterAct:

			// get data by listeners
			gameStatus_b[0] = "playball !";

			bName = batterNameInput.getText().toString();

			bAct = bName + " " + setBatterAct;

			// put data into bundle
			Bundle bundle = new Bundle();

			bundle.putStringArray("status_b", gameStatus_b);

			Intent intent = new Intent(HitAndRun.this, RunAndHit.class);
			intent.putExtras(bundle);
			startActivity(intent);

			break;

		}

	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub

		switch (arg1) {

		case R.id.rbuBatter_1:

			setBatterAct = " hit the god damm ball to outspace  !";

			break;
		case R.id.rbuBatter_2:

			setBatterAct = " technically knock it to the outfield ~";

			break;
		case R.id.rbuBatter_3:

			setBatterAct = " carefully sacrifice bunt.";

			break;

		}
		;

	}

}
