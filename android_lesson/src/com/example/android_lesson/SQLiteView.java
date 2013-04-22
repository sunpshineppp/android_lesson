package com.example.android_lesson;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.sunpshine.android_lesson.R;

public class SQLiteView extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite_view);
		TextView dbView = (TextView) findViewById (R.id.SQLinfo);
		
		SQLiteGirlDB loadData = new SQLiteGirlDB(this);
		loadData.open();
		String data = loadData.getData();
		loadData.close();
		dbView.setText(data);
		
		
	}

	
	
}
