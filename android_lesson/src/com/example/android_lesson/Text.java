package com.example.android_lesson;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.sunpshine.android_lesson.R;

public class Text extends Activity implements View.OnClickListener {

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

		switchPassword.setOnClickListener(this);
		getTextInput.setOnClickListener(this);
	}

	private void textFactory() {
		// TODO Auto-generated method stub

		getTextInput = (Button) findViewById(R.id.buSetTextInput);
		switchPassword = (ToggleButton) findViewById(R.id.tbuSwitchPassword);
		textIn = (EditText) findViewById(R.id.textInput);
		textOut = (TextView) findViewById(R.id.textOutput);

	}

	@Override
	public void onClick(View bu) {
		// TODO Auto-generated method stub
		switch (bu.getId()) {

		case R.id.tbuSwitchPassword:

			if (switchPassword.isChecked()) {
				textIn.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
			} else {
				textIn.setInputType(InputType.TYPE_CLASS_TEXT);
			}

			break;

		case R.id.buSetTextInput:

			String getting;
			getting = textIn.getText().toString();

			if (getting.contentEquals("l")) {
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
				textOut.setTextColor(Color.rgb(mad.nextInt(255),
						mad.nextInt(255), mad.nextInt(255)));
				switch (mad.nextInt(3)) {
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

			// hide keyboard after on click
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(textIn.getWindowToken(), 0);
			
			break;
		}
	}
}
