package com.example.android_lesson;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleIE extends Activity implements OnClickListener {

	EditText webSiteInput;
	Button goWeb, buGoBack, buGoForward, buRefresh, buClearHistory;
	WebView ie;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.simple_ie);

		ie = (WebView) findViewById(R.id.ie);
		
		// enable js
		ie.getSettings().setJavaScriptEnabled(true);
		// 
		ie.getSettings().setLoadWithOverviewMode(true);
		// 
		ie.getSettings().setUseWideViewPort(true);
		
		// set SimpleIE dominated browser
		ie.setWebViewClient(new DominatedBrowser());
		
		try{
		ie.loadUrl("http://www.google.com");
		} catch (Exception e){
			e.printStackTrace();
		}
		
		webSiteInput = (EditText) findViewById(R.id.webSiteInput);

		goWeb = (Button) findViewById(R.id.goWeb);
		buGoBack = (Button) findViewById(R.id.buGoBack);
		buGoForward = (Button) findViewById(R.id.buGoForward);
		buRefresh = (Button) findViewById(R.id.buRefresh);
		buClearHistory = (Button) findViewById(R.id.buClearHistory);

		goWeb.setOnClickListener(this);
		buGoBack.setOnClickListener(this);
		buGoForward.setOnClickListener(this);
		buRefresh.setOnClickListener(this);
		buClearHistory.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.goWeb:
			
			ie.loadUrl(webSiteInput.getText().toString());
			
			// hide keyboard after on click
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(webSiteInput.getWindowToken(), 0);

			break;

		case R.id.buGoBack:

			if(ie.canGoBack())
			ie.goBack();
			
			break;
		case R.id.buGoForward:
			
			if(ie.canGoForward())
				ie.goForward();

			break;
		case R.id.buRefresh:
			
			ie.reload();

			break;
		case R.id.buClearHistory:
			
			ie.clearHistory();

			break;

		}

	}

}
