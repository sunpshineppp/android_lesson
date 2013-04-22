package com.example.android_lesson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.sunpshine.android_lesson.R;

public class Test_StartActivityGet extends Activity implements OnClickListener {
	
	// set variables
	TextView output;
	Button back;
	
	String comingBall;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.test_start_activity_get);
		
		initialize();
		
		Bundle getPitch = getIntent().getExtras();
		comingBall = getPitch.getString("balls_in_wind"); 
		
		output.setText(comingBall);
		
	}



	private void initialize() {
		// TODO Auto-generated method stub
		
		output = (TextView) findViewById(R.id.outPut);
		back = (Button) findViewById(R.id.goBack);
		
		back.setOnClickListener(this);
		
		
		
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()){
		
			case R.id.goBack:
				
				Intent go = new Intent(Test_StartActivityGet.this , Test_StartActivity.class);
				startActivity(go);
				
				
				
				break;
		
		
		}
		
		
	}
	
	
	

}
