package com.example.android_lesson;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.text);
		
		Button getTextInput = (Button) findViewById(R.id.buSetTextInput);
		final ToggleButton switchPassword = (ToggleButton) findViewById(R.id.tbuSwitchPassword);
		final EditText textIn = (EditText) findViewById(R.id.textInput);
		final TextView textOut = (TextView) findViewById(R.id.textOutput);
		
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
				if (getting.contentEquals("left")){
					textOut.setGravity(Gravity.LEFT);
				} else if (getting.contentEquals("center")) {
					textOut.setGravity(Gravity.CENTER);
				} else if (getting.contentEquals("right")) {
					textOut.setGravity(Gravity.RIGHT);
				} else if (getting.contentEquals("blue")) {
					textOut.setTextColor(Color.BLUE);
				} else if (getting.contentEquals("~lol~")) {
					
				} else {
					textOut.setText("try typing & command");
					textOut.setGravity(Gravity.CENTER);
				}
			}
		});
		
		
	}
	
	

}
