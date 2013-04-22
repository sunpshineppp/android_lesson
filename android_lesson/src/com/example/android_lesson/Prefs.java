package com.example.android_lesson;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.sunpshine.android_lesson.R;

public class Prefs extends PreferenceActivity{

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.prefs);
		
		
	}

	
	
}
