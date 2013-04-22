package com.example.android_lesson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.sunpshine.android_lesson.R;

public class BaseBall extends Activity implements OnClickListener{
	
	// set view variables
	Button HitBallFirst , RunBaseFirst;
	TextView game;
	
	// set batter`s passing variables
	String setBatterAct = "the ball is hit and flying.";
	String bName;
	String bAct;

	// set runner`s passing variables
	String setRunnerAct = "the runner is leaving base.";
	String rName;
	String rAct;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView (R.layout.base_ball);
		
		initialize();
		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		game = (TextView) findViewById(R.id.game);
		
		HitBallFirst = (Button) findViewById(R.id.HitBallFirst);
		RunBaseFirst = (Button) findViewById(R.id.RunBaseFirst);
		
		// set listener
		HitBallFirst.setOnClickListener(this);
		RunBaseFirst.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()){
		
			case R.id.HitBallFirst :
				
				// test button
				game.setText(setRunnerAct);
				
				// set a bundle to carry this string
				// putString("key for access",data need to be pass)
				Bundle status_r = new Bundle();
				status_r.putString("RunnerAct", setRunnerAct);
				status_r.putString("BatterAct", setBatterAct);
				
				Intent go_hit = new Intent(BaseBall.this, HitAndRun.class);
				go_hit.putExtras(status_r);
				
				startActivity(go_hit);
				
				break;
			
			case R.id.RunBaseFirst :
				
				// test button
				game.setText(setBatterAct);
				
				// set a bundle to carry this string
				// putString("key for access",data need to be pass)
				Bundle status_b = new Bundle();
				status_b.putString("BatterAct", setBatterAct);
				status_b.putString("RunnerAct", setRunnerAct);

				
				Intent go_run = new Intent(BaseBall.this, RunAndHit.class);
				go_run.putExtras(status_b);

				
				startActivity(go_run);
	
				break;

		}
		
	}

	
	
	
}
