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
import com.sunpshine.android_lesson.R;

public class SQLiteDemo extends Activity implements OnClickListener{
	
	EditText girlNameInput, girlDescription;
	Spinner girlHotnessScale;
	Button buSaveDB, buLoadDB;
	
	EditText rowIDquery;
	Button buRowIDquery, editEntry, deleteEntry;
	
	boolean didItWork = true;
	
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
		
		
		rowIDquery = (EditText) findViewById(R.id.rowIDquery);
		buRowIDquery = (Button) findViewById(R.id.buRowIDquery);
		editEntry = (Button) findViewById(R.id.editEntry);
		deleteEntry = (Button) findViewById(R.id.deleteEntry);
		buRowIDquery.setOnClickListener(this);
		editEntry.setOnClickListener(this);
		deleteEntry.setOnClickListener(this);
		
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		
		case R.id.buSaveDB :
			
			
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
			
			try{
			// "com.example.android_lesson.SQLiteView" must setup in MANIFEST,
			// set <intent-filter> in MANIFEST for the class you want to call by intent.
			Intent load = new Intent("com.example.android_lesson.SQLiteView");
			startActivity(load);
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
		
		case R.id.buRowIDquery :
			
			try{
			
			String id = rowIDquery.getText().toString();
			long idNumber = Long.parseLong(id);
			SQLiteGirlDB getDB = new SQLiteGirlDB(this);
			getDB.open();
			String returnName = getDB.getName(idNumber);
			String returnHotness = getDB.getHotness(idNumber);
			String returnDescription = getDB.getDescription(idNumber);
			getDB.close();
			
			girlNameInput.setText(returnName);
			girlDescription.setText(returnDescription);
			
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

		case R.id.editEntry :
			
			try{
			
			String id_modified = rowIDquery.getText().toString();
			long idNumber_modified = Long.parseLong(id_modified);
			
			String nameData_modified = girlNameInput.getText().toString();
			String descriptionData_modified = girlDescription.getText().toString();
			
			SQLiteGirlDB getDataModified = new SQLiteGirlDB(this);
			getDataModified.open();
			getDataModified.updateEntry(idNumber_modified, nameData_modified, descriptionData_modified);
			getDataModified.close();
			
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
			
		case R.id.deleteEntry :
	
			try{
			
			String id_delete = rowIDquery.getText().toString();
			long idNumber_delete = Long.parseLong(id_delete);
			SQLiteGirlDB getDataDelete = new SQLiteGirlDB(this);
			getDataDelete.open();
			getDataDelete.deleteEntry(idNumber_delete);
			getDataDelete.close();
			
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
			
			
		}
	}

	
	
}
