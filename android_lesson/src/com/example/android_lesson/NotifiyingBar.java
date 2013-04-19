package com.example.android_lesson;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotifiyingBar extends Activity implements OnClickListener{

	
	Button buNotifiying;
	
	
	NotificationManager nm;
	
	static final int uniqueID = 168;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.notifiying_bar);
		
		buNotifiying = (Button)findViewById(R.id.buNotifiying);
		
		buNotifiying.setOnClickListener(this);
		
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		nm.cancel(uniqueID);
	}

	@Override
	public void onClick(View bu) {
		// TODO Auto-generated method stub
		
		switch (bu.getId()){
		
		case R.id.buNotifiying :
			
			Intent intent = new Intent(this, NotifiyingBar.class);
			PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
			
			String body = "Fake Alerm ~";
			String title = "Wolve is Coming !!";
			Notification alerm = new Notification(R.drawable.mad_notifiying, body, System.currentTimeMillis());
			
			alerm.setLatestEventInfo(this, title, body, pi);
			
			alerm.defaults = Notification.DEFAULT_ALL;
			
			nm.notify(uniqueID, alerm);
			
			finish();
			
			break;
		
		}
		
		
		
	}

}
