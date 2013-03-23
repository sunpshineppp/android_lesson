package com.example.android_lesson;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TabsDemo extends Activity implements OnClickListener {

	TabHost tabs;
	
	// for tab1, clock
	TextView textView1;
	Button button1a;
	Button button1b;
	long startTime=0, stopTime=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tabs_demo);

		// set view
		textView1 = (TextView) findViewById(R.id.textView1);
		button1a = (Button) findViewById(R.id.button1a);
		button1b = (Button) findViewById(R.id.button1b);

		TextView textView2 = (TextView) findViewById(R.id.textView2);
		Button button2a = (Button) findViewById(R.id.button2a);
		Button button2b = (Button) findViewById(R.id.button2b);

		TextView textView3 = (TextView) findViewById(R.id.textView3);
		Button button3a = (Button) findViewById(R.id.button3a);
		Button button3b = (Button) findViewById(R.id.button3b);

		// set listener
		button1a.setOnClickListener(this);
		button1b.setOnClickListener(this);
		button2a.setOnClickListener(this);
		button2b.setOnClickListener(this);
		button3a.setOnClickListener(this);
		button3b.setOnClickListener(this);

		// set tab host
		tabs = (TabHost) findViewById(R.id.tabhost);
		tabs.setup();

		// set tab 1
		TabSpec tabs_spec1 = tabs.newTabSpec("tab1");
		tabs_spec1.setContent(R.id.tab1);
		tabs_spec1.setIndicator("StopWatch");
		tabs.addTab(tabs_spec1);

		// set tab 2
		TabSpec tabs_spec2 = tabs.newTabSpec("tab2");
		tabs_spec2.setContent(R.id.tab2);
		tabs_spec2.setIndicator("WhatEver");
		tabs.addTab(tabs_spec2);

		// set tab 3
		TabSpec tabs_spec3 = tabs.newTabSpec("tab3");
		tabs_spec3.setContent(R.id.tab3);
		tabs_spec3.setIndicator("Add a Tab");
		tabs.addTab(tabs_spec3);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.button1a:
			startTime = System.currentTimeMillis();

			break;

		case R.id.button1b:
			stopTime = System.currentTimeMillis();
			
			if (startTime !=0 && stopTime !=0){
				long result = stopTime - startTime;
				// (int) is make code let "long" save in "int"
				int timePeriod = (int)result;
				int seconds = timePeriod/1000;
				int minutes = seconds/1000;
				
				// Long.toString is a way to transfer long to string
				//textView1.setText(Long.toString(result));
				
				// there are 3 d, each one is direct to the following arguments
				// seconds % 60 => if seconds is 70, then seconds % 60 == 10 , output the remainder
				textView1.setText(String.format("%d:%02d:%02d",minutes, seconds%60, timePeriod%100));
				
			}

			break;
		case R.id.button2a:

			break;

		case R.id.button2b:

			break;
		case R.id.button3a:

			TabSpec newTabSpec = tabs.newTabSpec("new");
			newTabSpec.setContent(new TabHost.TabContentFactory() {

				@Override
				public View createTabContent(String arg0) {
					// TODO Auto-generated method stub

					TextView text = new TextView(TabsDemo.this);
					text.setText("new tab");
					return (text);
				}

			});
			newTabSpec.setIndicator("new");
			tabs.addTab(newTabSpec);

			break;

		case R.id.button3b:

			break;

		}

	}
}
