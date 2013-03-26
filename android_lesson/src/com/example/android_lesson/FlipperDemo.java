package com.example.android_lesson;

import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class FlipperDemo extends Activity implements OnClickListener {

	// create ViewFlipper
	ViewFlipper flippers;
	
	// create ImageView
	ImageView image_view_1;
	ImageView image_view_2;
	ImageView image_view_3;
	ImageView image_view_4;
	Bitmap bmp_1;
	Bitmap bmp_2;
	Bitmap bmp_3;
	Bitmap bmp_4;

	// create Button for auto flip
	Button buStartAutoFlipper;
	Button buStopAutoFlipper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.flipper_demo);

		// setup ViewFlipper
		flippers = (ViewFlipper) findViewById(R.id.viewFlipper);
		flippers.setOnClickListener(this);
		
		// setup ImageView
		image_view_1 = (ImageView) findViewById(R.id.image_view_1);
		image_view_2 = (ImageView) findViewById(R.id.image_view_2);
		image_view_3 = (ImageView) findViewById(R.id.image_view_3);
		image_view_4 = (ImageView) findViewById(R.id.image_view_4);
		InputStream image_view_1_bmp = getResources().openRawResource(R.drawable.troll_face);
		InputStream image_view_2_bmp = getResources().openRawResource(R.drawable.jizz_face);
		InputStream image_view_3_bmp = getResources().openRawResource(R.drawable.yao_face);
		InputStream image_view_4_bmp = getResources().openRawResource(R.drawable.rage_face);
		bmp_1 = BitmapFactory.decodeStream(image_view_1_bmp);
		bmp_2 = BitmapFactory.decodeStream(image_view_2_bmp);
		bmp_3 = BitmapFactory.decodeStream(image_view_3_bmp);
		bmp_4 = BitmapFactory.decodeStream(image_view_4_bmp);
		image_view_1.setImageBitmap(bmp_1);
		image_view_2.setImageBitmap(bmp_2);
		image_view_3.setImageBitmap(bmp_3);
		image_view_4.setImageBitmap(bmp_4);
		
		// setup Button for auto flip
		buStartAutoFlipper = (Button) findViewById(R.id.buStartAutoFlipper);
		buStopAutoFlipper = (Button) findViewById(R.id.buStopAutoFlipper);
		buStartAutoFlipper.setOnClickListener(this);
		buStopAutoFlipper.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.viewFlipper:

			// flip it
			flippers.showNext();

			break;

		case R.id.buStartAutoFlipper:

			// start auto flip
			flippers.setFlipInterval(500);
			flippers.startFlipping();

			break;
			
		case R.id.buStopAutoFlipper:

			// stop auto flip
			flippers.stopFlipping();

			break;

		}

	}

}
