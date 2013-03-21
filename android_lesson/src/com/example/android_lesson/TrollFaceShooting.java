package com.example.android_lesson;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class TrollFaceShooting extends Activity implements OnTouchListener{
	
	// set view variables
	TrollfaceMaker trollFaceView;
	
	// set position variables
	float x, y;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// view & constructor class
		trollFaceView = new TrollfaceMaker(this);
		// view & Listener
		trollFaceView.setOnTouchListener(this);
		// define original position
		x = 0;
		y = 0;
		
		// view
		setContentView(trollFaceView);
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		// call the pause() method we create in TrollfaceMaker
		trollFaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		// call the resume() method we create in TrollfaceMaker
		trollFaceView.resume();
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		
		// use listener to get position
		x = event.getX();
		y = event.getY();
		
		return false;
	}
	
	

}
