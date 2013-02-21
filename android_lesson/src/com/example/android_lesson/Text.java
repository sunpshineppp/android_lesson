package com.example.android_lesson;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Text extends Activity {
	
	Button getTextInput;
	ToggleButton switchPassword;
	EditText textIn;
	TextView textOut;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.text);
		
		textFactory();
		
		
		
		switchPassword.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if (switchPassword.isChecked()) {
					textIn.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				} else{
					textIn.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			}
		});
		
		getTextInput.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String getting = textIn.getText().toString();
				if (getting.contentEquals("l")){
					textOut.setGravity(Gravity.LEFT);
				} else if (getting.contentEquals("c")) {
					textOut.setGravity(Gravity.CENTER);
				} else if (getting.contentEquals("r")) {
					textOut.setGravity(Gravity.RIGHT);
				} else if (getting.contentEquals("b")) {
					textOut.setTextColor(Color.BLUE);
				} else if (getting.contentEquals("wtf")) {
					Random mad = new Random();
					textOut.setText("~lol~");
					textOut.setTextSize(mad.nextInt(100));
					textOut.setTextColor(Color.rgb(mad.nextInt(255),mad.nextInt(255),mad.nextInt(255)));
					switch(mad.nextInt(3)){
					case 0:
						textOut.setGravity(Gravity.RIGHT);
						break;
					case 1:
						textOut.setGravity(Gravity.CENTER);
						break;
					case 2:
						textOut.setGravity(Gravity.LEFT);
						break;
					}
				} else {
					textOut.setText("try typing : l c r b wtf");
					textOut.setGravity(Gravity.CENTER);
					textOut.setTextColor(Color.RED);
				}
			}
		});
		
		
	}


	private void textFactory() {
		// TODO Auto-generated method stub
		
		getTextInput = (Button) findViewById(R.id.buSetTextInput);
		switchPassword = (ToggleButton) findViewById(R.id.tbuSwitchPassword);
		textIn = (EditText) findViewById(R.id.textInput);
		textOut = (TextView) findViewById(R.id.textOutput);
		
	}
	
	

}
