package com.example.android_lesson;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.sunpshine.android_lesson.R;

public class CatNoise extends Activity implements OnClickListener, OnLongClickListener{

	SoundPool catMeow;
	// in case meowSound not load ready, play will cause error.
	// so, give it a value, and use if statement to check it. 
	int meowSound = 0;
	
	MediaPlayer backgroundMelody;
	int Melody = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		View cat = new View(this);
		
		cat.setOnClickListener(this);
		
		cat.setOnLongClickListener(this);
		
		setContentView(cat);
		
		catMeow = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		meowSound = catMeow.load(this, R.raw.meow5, 1); 
		
		backgroundMelody = MediaPlayer.create(this, R.raw.nocturne);
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		// if statement to check meowSound is load ready.
		if (meowSound !=0)
		catMeow.play(meowSound, 1, 1, 0, 0, 1);
		
	}

	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		backgroundMelody.start();
		return false;
	}

	
	
}
