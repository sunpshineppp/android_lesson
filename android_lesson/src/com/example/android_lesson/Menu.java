package com.example.android_lesson;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "StartingPoint", "Text", "LoveMail",
			"CameraToBackground", "Test_StartActivity",
			"Test_StartActivityForResult", "BaseBall",
			"BallBall", "TrollFaceShooting", "CatNoise",
			"SlidingPanel", "TabsDemo", "SimpleIE", "FlipperDemo" };

	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//request for full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub

		super.onListItemClick(l, v, position, id);
		String selected = classes[position];

		try {
			@SuppressWarnings("rawtypes")
			Class c = Class.forName("com.example.android_lesson." + selected);
			Intent i = new Intent(Menu.this, c);
			startActivity(i);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub

		super.onCreateOptionsMenu(menu);

		MenuInflater showOption = getMenuInflater();
		showOption.inflate(R.menu.option_menu, menu);
		return true;

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {

			case R.id.aboutApp:
				
				Intent i = new Intent("com.example.android_lesson.ABOUTAPP");
				startActivity(i);
		
				break;
		
			case R.id.aboutUser:
		
				break;
		
			case R.id.preferences:
				Intent p = new Intent("com.example.android_lesson.PREFS");
				startActivity(p);
		
				break;
				
			case R.id.exit:
				finish();
				
				break;

		}

		return false;
	}

}
