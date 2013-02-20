package com.example.android_lesson;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
	
	String classes[] = {"StartingPoint" , "Text" , "3"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
						
		super.onListItemClick(l, v, position, id);
		String selected = classes[position];
		
		try{
			Class c = Class.forName("com.example.android_lesson." + selected);
			Intent i = new Intent(Menu.this, c);
			startActivity(i);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			
		}
	}
	
}
