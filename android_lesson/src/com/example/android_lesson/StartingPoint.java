package com.example.android_lesson;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingPoint extends Activity {
	
	// test git after a Disaster Conflict problem .... DAMM IT...I lost so many code...
	
	int counter;
	Button add;
	Button substract;
	TextView result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_starting_point);
	counter = 0;
	add = (Button) findViewById(R.id.buADD);
	substract = (Button) findViewById(R.id.buSUBSTRACT);
	result = (TextView) findViewById(R.id.resultDisplay2);
	
	//use setOnClickListener , onClick
	add.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v){
		//set actions after a CLICK of buADD
			counter = counter + 1;
			result.setText(""+ counter);
		}
	});
	substract.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v){
		//set actions after a CLICK of buSUBSTRACT
			counter = counter - 1;
			result.setText(""+ counter);
		}
	});
	
	}
}
