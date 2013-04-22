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
import com.sunpshine.android_lesson.R;

public class HitAndRun extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	// set batter`s view variables
	TextView batterOpen;
	EditText batterNameInput;
	RadioGroup batterChoices;
	Button batterActing;

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

		setContentView(R.layout.hit_and_run);

		initialize();
		
		// open the bundle, get string, set text view
		Bundle watchBases = getIntent().getExtras();
		setRunnerAct = watchBases.getString("RunnerAct"); 
		batterOpen.setText(setRunnerAct);
		
		bName = watchBases.getString("BatterName");
		rName = watchBases.getString("RunnerName");
		
		batterNameInput.setHint(bName);

	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		// variables & views
		batterOpen = (TextView) findViewById(R.id.BatterView);
		batterNameInput = (EditText) findViewById(R.id.BatterName);
		batterChoices = (RadioGroup) findViewById(R.id.rbuBatter);
		batterActing = (Button) findViewById(R.id.buBatterAct);

		// button & listener
		batterActing.setOnClickListener(this);
		batterChoices.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {

		case R.id.buBatterAct:
			
			bName = batterNameInput.getText().toString();
			
			// set a bundle to carry this string
			// putString("key for access",data need to be pass)
			Bundle status_b = new Bundle();
			status_b.putString("BatterAct", setBatterAct);
			status_b.putString("RunnerAct", setRunnerAct);
			status_b.putString("RunnerName", rName);
			status_b.putString("BatterName", bName);

			
			Intent go_run = new Intent(HitAndRun.this, RunAndHit.class);
			go_run.putExtras(status_b);

			
			startActivity(go_run);

			break;

		}

	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub

		switch (arg1) {

		case R.id.rbuBatter_1:

			setBatterAct = bName + " hit the god damm ball to outspace  !";

			break;
		case R.id.rbuBatter_2:

			setBatterAct = bName + " technically knock it to the outfield ~";

			break;
		case R.id.rbuBatter_3:

			setBatterAct = bName + " carefully sacrifice bunt.";

			break;

		}
		;

	}

}
