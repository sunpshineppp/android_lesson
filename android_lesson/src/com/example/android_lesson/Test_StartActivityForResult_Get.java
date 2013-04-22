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

public class Test_StartActivityForResult_Get extends Activity implements OnClickListener {
	
	// set variables
	TextView messageView;
	TextView enterFeedback;
	EditText messageFeedbackInput;
	Button feedbackSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.test_start_activity_for_result_get);
		
		initialize();
		
		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		// variables & views
		messageView = (TextView) findViewById(R.id.messageView);
		enterFeedback = (TextView) findViewById(R.id.enterFeedback);
		messageFeedbackInput = (EditText) findViewById(R.id.messageFeedbackInput);
		feedbackSend = (Button) findViewById(R.id.feedbackSend);
		
		// set listener
		feedbackSend.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		// get feedback string 
		String totalMemory = messageFeedbackInput.getText().toString();
		
		// set Bundle , put string in bundle
		Bundle memoryFeedback = new Bundle();
		memoryFeedback.putString("feedback",totalMemory);
		
		// set intent , use intent pass bundle
		Intent feedback = new Intent();
		feedback.putExtras(memoryFeedback);
		
		// set result
		setResult(RESULT_OK, feedback);
		
		// close this activity
		finish();
		
	}

}
