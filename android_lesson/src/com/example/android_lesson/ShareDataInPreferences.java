package com.example.android_lesson;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.sunpshine.android_lesson.R;

public class ShareDataInPreferences extends Activity implements OnClickListener {

	EditText secretsInput;
	Button buSaveSecret;
	Button buLoadSecret;
	TextView secretOutput;

	// set a name for preference to save data,
	// this String is like a path,
	// so, we don't want it to be changed by anybody anymore.
	// so, use static to give this String unmodified.
	public static String dataPath = "secretLocker";
	SharedPreferences dataNote;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.share_data_in_preferences);

		initialize();

		// activate SharedPreferences to save data
		dataNote = getSharedPreferences(dataPath, 0);

	}

	private void initialize() {
		// TODO Auto-generated method stub

		secretsInput = (EditText) findViewById(R.id.secretsInput);
		buSaveSecret = (Button) findViewById(R.id.buSaveSecret);
		buLoadSecret = (Button) findViewById(R.id.buLoadSecret);
		secretOutput = (TextView) findViewById(R.id.secretOutput);

		buSaveSecret.setOnClickListener(this);
		buLoadSecret.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.buSaveSecret:

			String data = secretsInput.getText().toString();

			// import Editor to edit data to save it into SharedPreferences.
			SharedPreferences.Editor editor = dataNote.edit();
			editor.putString("dataKey", data);
			editor.commit();

			// hide keyboard after on click
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(secretsInput.getWindowToken(), 0);

			break;

		case R.id.buLoadSecret:

			dataNote = getSharedPreferences(dataPath, 0);
			String dataReturn = dataNote.getString("dataKey", "no data found");

			secretOutput.setText(dataReturn);

			break;

		}

	}

}
