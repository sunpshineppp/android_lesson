package com.example.android_lesson;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingPoint extends Activity {
	
	// test git after a Disaster Conflict problem .... DAMM IT...I lost so many code...
	
	int counter;
	Button add;
	Button substract;
	
	TextView welcome;
	TextView result;
	TextView count;
	
	String UserName;
	String welcomeMessage;
	
	String ListItemSelected;
	String resultCount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_starting_point);
	counter = 0;
	add = (Button) findViewById(R.id.buADD);
	substract = (Button) findViewById(R.id.buSUBSTRACT);
	
	welcome = (TextView) findViewById (R.id.startingPointWelcome);
	result = (TextView) findViewById(R.id.resultDisplay2);
	count = (TextView) findViewById(R.id.count);
	
	// set welcome by EditText input from preferences
	SharedPreferences getUserName = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	UserName = getUserName.getString("userName","Stranger");
	welcomeMessage = "Hi, " + UserName + ", your total is.." ;
	welcome.setText(welcomeMessage);
	
	// set result by List input from preferences
	SharedPreferences getListItemSelected = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	ListItemSelected = getListItemSelected.getString("list","1");
	if(ListItemSelected.contentEquals("1")){
		count.setText("USD");
	}
	if(ListItemSelected.contentEquals("2")){
		count.setText("NTD");
	}
	
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
