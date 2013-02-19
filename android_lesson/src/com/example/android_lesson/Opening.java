package com.example.android_lesson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Opening extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.opening);
				
		Thread timer = new Thread(){
			
			public void run(){
				try{
					sleep(5000);				
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent goStartPoing = new Intent("com.example.android_lesson.STARTINGPOINT");
					startActivity(goStartPoing);
				}
			}
			
		};
		
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}
