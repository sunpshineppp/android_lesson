package com.example.android_lesson;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

@SuppressLint("Wakelock")
public class BallBall extends Activity{
	
	CreateBallBall GiveMeTheDammBall ;
	// declare an wake lock
	WakeLock locks;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		// set an wake lock to keep it open, have the device stay on.
		PowerManager power = (PowerManager) getSystemService(Context.POWER_SERVICE);
		locks = power.newWakeLock(PowerManager.FULL_WAKE_LOCK ,"power saving");
		
		
		super.onCreate(savedInstanceState);
		
		// activated the wake lock
		locks.acquire();
		
		// call another class to control the view
		GiveMeTheDammBall = new CreateBallBall(this);
		setContentView(GiveMeTheDammBall);
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		// break the lock.
		locks.release();
		
	}

	
	
}
