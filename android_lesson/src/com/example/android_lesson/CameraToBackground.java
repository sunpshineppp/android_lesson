package com.example.android_lesson;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CameraToBackground extends Activity implements OnClickListener {

	ImageView pic;
	ImageButton openCamera;
	Button setBackground;

	Intent i;
	int picResults;
	
	final static int picData = 0;
	
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.camera_to_background);

		initialize();
		
		InputStream iniPic = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(iniPic);
		
	}

	private void initialize() {
		// TODO Auto-generated method stub

		pic = (ImageView) findViewById(R.id.picPreview);
		setBackground = (Button) findViewById(R.id.buSetBackground);
		openCamera = (ImageButton) findViewById(R.id.buOpenCamera);

		setBackground.setOnClickListener(this);
		openCamera.setOnClickListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View bu) {
		// TODO Auto-generated method stub

		switch (bu.getId()) {

			case R.id.buOpenCamera:
				
				i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(i, picData);
	
				break;
	
			case R.id.buSetBackground:
				
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == RESULT_OK) {
			
			Bundle extras = data.getExtras();
			
			bmp = (Bitmap) extras.get("data");
			
			pic.setImageBitmap(bmp);
			
			};
		
		
	}
	
	

}
