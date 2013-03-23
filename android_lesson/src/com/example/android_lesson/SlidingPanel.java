package com.example.android_lesson;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class SlidingPanel extends Activity implements OnClickListener,
		OnCheckedChangeListener, OnDrawerOpenListener, OnDrawerCloseListener {

	SlidingDrawer slide;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.sliding_panel);

		Button slideOpen = (Button) findViewById(R.id.slideOpen);
		Button slideClose = (Button) findViewById(R.id.slideClose);
		Button toggle = (Button) findViewById(R.id.toggle);
		Button handleLock = (Button) findViewById(R.id.handleLock);
		Button handleUnlock = (Button) findViewById(R.id.handleUnlock);
		Button handle = (Button) findViewById(R.id.handle);
		
		CheckBox checkSlidable = (CheckBox) findViewById(R.id.checkSlidable);

		slide = (SlidingDrawer) findViewById(R.id.slidingDrawer);
		
		slideOpen.setOnClickListener(this);
		slideClose.setOnClickListener(this);
		toggle.setOnClickListener(this);
		
		handleLock.setOnClickListener(this);
		handleUnlock.setOnClickListener(this);
		handle.setOnClickListener(this);

		checkSlidable.setOnCheckedChangeListener(this);
		
		slide.setOnDrawerOpenListener(this);
		slide.setOnDrawerCloseListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.slideOpen:
			slide.open();
			break;
			
		case R.id.slideClose:
			slide.close();
			break;
			
		case R.id.toggle:
			slide.toggle();
			break;
			
		case R.id.handleLock:
			slide.lock();
			break;

		case R.id.handleUnlock:
			slide.unlock();
			break;
		case R.id.handle:

			break;

		}

	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub

		if (arg0.isChecked()) {
			slide.lock();
		} else {
			slide.unlock();
		}

	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		
		MediaPlayer slidingSound = MediaPlayer.create(this,R.raw.drum_hit);
		slidingSound.start();
		
	}

	@Override
	public void onDrawerClosed() {
		// TODO Auto-generated method stub
		
		MediaPlayer slidingSound = MediaPlayer.create(this,R.raw.trumpet_blow);
		slidingSound.start();
		
	}

}
