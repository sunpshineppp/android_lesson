package com.example.android_lesson;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Text extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.text);
		
		Button getTextInput = (Button) findViewById(R.id.buSetTextInput);
		ToggleButton switchPassword = (ToggleButton) findViewById(R.id.tbuSwitchPassword);
		EditText textIn = (EditText) findViewById(R.id.textInput);
		TextView textOut = (TextView) findViewById(R.id.textOutput);
		
	}
	
	

}
