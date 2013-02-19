package com.example.android_lesson;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingPoing extends Activity {
	
	int counter;
	Button add;
	Button substract;
	TextView result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_starting_poing);
	counter = 0;
	add = (Button) findViewById(R.id.buADD);
	substract = (Button) findViewById(R.id.buSUBSTRACT);
	result = (TextView) findViewById(R.id.resultDisplay);
	
	//use setOnClickListener , onClick
	add.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v){
		//set actions after a CLICK of buADD
			counter = counter + 1;
			result.setText("now the total equals "+ counter);
		}
	});
	substract.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v){
		//set actions after a CLICK of buSUBSTRACT
			counter = counter - 1;
			result.setText("now the total equals "+ counter);
		}
	});
	
	}
}
