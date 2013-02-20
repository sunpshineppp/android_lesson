package com.example.android_lesson;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
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
		TextView textOut = (TextView) findViewById(R.id.textOutput);
		
		switchPassword.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				if (switchPassword.isChecked()) {
					textIn.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				} else{
					textIn.setInputType(InputType.TYPE_CLASS_TEXT);
				}
				
			}
			
		});
		
	}
	
	

}
