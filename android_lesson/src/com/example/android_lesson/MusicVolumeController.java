package com.example.android_lesson;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.sunpshine.android_lesson.R;

public class MusicVolumeController extends Activity implements OnSeekBarChangeListener {

	SeekBar seekBar_misic_volume;
	MediaPlayer musicPlayer;
	
	AudioManager AudioControll;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.music_volume_controller);
		
		seekBar_misic_volume = (SeekBar)findViewById(R.id.seekBar_misic_volume);
		
		musicPlayer = MediaPlayer.create(this, R.raw.nocturne);
		musicPlayer.start();
		
		AudioControll = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		
		int maxV = AudioControll.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		int curV = AudioControll.getStreamVolume(AudioManager.STREAM_MUSIC);
	
		seekBar_misic_volume.setMax(maxV);
		seekBar_misic_volume.setProgress(curV);
		
		seekBar_misic_volume.setOnSeekBarChangeListener(this);
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		musicPlayer.release();
	}

	@Override
	public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
		// TODO Auto-generated method stub
		
		AudioControll.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
