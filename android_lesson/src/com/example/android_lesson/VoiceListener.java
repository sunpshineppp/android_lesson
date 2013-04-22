package com.example.android_lesson;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.sunpshine.android_lesson.R;

public class VoiceListener extends Activity implements OnClickListener{

	ListView voiceList;
	Button buGetVoice;
	
	static final int check = 777;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voice_listener);
		
		voiceList = (ListView) findViewById (R.id.voiceList);
		buGetVoice = (Button) findViewById (R.id.buGetVoice);
		buGetVoice.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		i.putExtra(RecognizerIntent.EXTRA_PROMPT, "SPEAK PLEASE.");
		
		startActivityForResult(i, check);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
		if (requestCode == check && resultCode == RESULT_OK){
			
			ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			
			voiceList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	
	

}
