package com.example.android_lesson;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SQLiteDemo extends Activity implements OnClickListener{
	
	EditText girlNameInput, girlDescription;
	Spinner girlHotnessScale;
	Button buSaveDB, buLoadDB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sqlite_demo);
		
		initialize();
		
	}



	private void initialize() {
		// TODO Auto-generated method stub
		girlNameInput = (EditText) findViewById(R.id.girlNameInput);
		girlDescription = (EditText) findViewById(R.id.girlDescription);
		buSaveDB = (Button) findViewById(R.id.buSaveDB);
		buLoadDB = (Button) findViewById(R.id.buLoadDB);
		buSaveDB.setOnClickListener(this);
		buLoadDB.setOnClickListener(this);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		
		case R.id.buSaveDB :
			
			boolean didItWork = true;
			try{
			String nameData = girlNameInput.getText().toString();
			String hotnessData = "10";
			String descriptionData = girlDescription.getText().toString();
			
			SQLiteGirlDB newData = new SQLiteGirlDB(SQLiteDemo.this);
			newData.open();
			newData.dataSaving(nameData, hotnessData, descriptionData);
			newData.close();
			} catch (Exception e){
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("oh no no no");
				TextView dView = new TextView(this);
				dView.setText(error);
				d.setContentView(dView);
				d.show();
			} finally {
				if (didItWork){
					Dialog d = new Dialog(this);
					d.setTitle("oh ya");
					TextView dView = new TextView(this);
					dView.setText("it works perfectly");
					d.setContentView(dView);
					d.show();
				}
			}
			break;
			
		case R.id.buLoadDB :
			
			// "com.example.android_lesson.SQLiteView" must setup in MANIFEST,
			// set <intent-filter> in MANIFEST for the class you want to call by intent.
			Intent load = new Intent("com.example.android_lesson.SQLiteView");
			startActivity(load);
			break;
		
		
		}
	}

	
	
}
