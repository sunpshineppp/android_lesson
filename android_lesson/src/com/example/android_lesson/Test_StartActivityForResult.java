package com.example.android_lesson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.sunpshine.android_lesson.R;

public class Test_StartActivityForResult extends Activity implements
		OnClickListener {

	// set variables
	TextView status;
	EditText messageInput;
	Button messageIn;
	TextView feedbackMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.test_start_activity_for_result);

		initialize();

	}

	private void initialize() {
		// TODO Auto-generated method stub

		// variables & views
		status = (TextView) findViewById(R.id.status);
		messageInput = (EditText) findViewById(R.id.messageInput);
		messageIn = (Button) findViewById(R.id.messageIn);
		feedbackMessage = (TextView) findViewById(R.id.feedbackMessage);
		
		// set listener
		messageIn.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {

		case R.id.messageIn:

			// use intent to open another activity
			Intent memoryPass = new Intent(Test_StartActivityForResult.this,
					Test_StartActivityForResult_Get.class);

			// go
			startActivityForResult(memoryPass, 0);

			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK) {
			
			// set an empty bundle to get the bundle passed from another activity
			Bundle getMemory = data.getExtras();
			
			String memory = getMemory.getString("feedback");
			
			// change the textView 
			status.setText("we got feedback");
			feedbackMessage.setText("feedback  is " + memory);
		}
		
	}

}
