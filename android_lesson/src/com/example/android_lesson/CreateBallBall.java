package com.example.android_lesson;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import com.sunpshine.android_lesson.R;

public class CreateBallBall extends View{
	
	// set bitmap variables
	Bitmap trollFace;
	float changingY;
	
	// set font variables
	Typeface newFont;

	public CreateBallBall(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		// import PNG file
		trollFace = BitmapFactory.decodeResource(getResources(), R.drawable.troll_face);
		
		// set Y variable for PNG in the Canvas
		changingY = 0;
		
		//set font from asset folder
		newFont = Typeface.createFromAsset(context.getAssets(), "ActionIs.ttf");
		
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//set canvas background color
		canvas.drawColor(Color.WHITE);
		
		//set paint within font
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 20, 240, 60);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(newFont);
		canvas.drawText("Hey, what`s up.", (canvas.getWidth()/2), 200, textPaint );
		
		//put PNG into canvas
		canvas.drawBitmap(trollFace, (canvas.getWidth()/2), changingY, null);
		
		//let PNG move along the changing Y
		if (changingY < canvas.getHeight()){
			changingY += 10;
		} else {
			changingY = 0;
		}
		
		// draw a rectangle
		Rect miniBar = new Rect();
		int miniBar_top = 400;
		int miniBar_bot = 500;
		miniBar.set(0,miniBar_top,canvas.getWidth(),miniBar_bot);
		Paint miniBar_color = new Paint();
		miniBar_color.setColor(Color.BLUE);
		canvas.drawRect(miniBar,miniBar_color);
		
		invalidate();
		
	}

	
	
}
