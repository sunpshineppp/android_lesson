package com.example.android_lesson;

import android.app.Activity;
import android.os.Bundle;

public class BallBall extends Activity{
	
	CreateBallBall GiveMeTheDammBall ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// call another class to control the view
		GiveMeTheDammBall = new CreateBallBall(this);
		setContentView(GiveMeTheDammBall);
		
	}

	
	
}
