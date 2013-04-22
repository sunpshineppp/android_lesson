package com.example.android_lesson;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.sunpshine.android_lesson.R;

public class TextToVoice extends Activity implements OnClickListener {

	TextView textInput;
	Button buGetText;

	static String texts;
	TextToSpeech speech;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.text_to_voice);
		textInput = (TextView) findViewById(R.id.textInput);
		buGetText = (Button) findViewById(R.id.buGetText);

		buGetText.setOnClickListener(this);

		speech = new TextToSpeech(TextToVoice.this,
				new TextToSpeech.OnInitListener() {

					@Override
					public void onInit(int status) {
						// TODO Auto-generated method stub
						
						if (status != TextToSpeech.ERROR){
							speech.setLanguage(Locale.US);
						}
						
					}

				});

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub

		if (speech != null) {
			speech.stop();
			speech.shutdown();
		}

		super.onPause();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()){
		
			case R.id.buGetText:
				
				texts = textInput.getText().toString();
				
				speech.speak(texts, TextToSpeech.QUEUE_FLUSH, null);
				
				break;
		
		}
		
	}

}
