package com.example.android_lesson;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class TrollFaceShooting extends Activity implements OnTouchListener {

	// set view variables
	TrollfaceMaker trollFaceView;

	// set position variables
	float x, y, sx, sy, fx, fy;
	
	// set change position variables
	float dX, dY, aniX, aniY, scaledX, scaledY;
	
	// set 2 Bitmap  
	Bitmap jizzFace , trollFace;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// view & constructor class
		trollFaceView = new TrollfaceMaker(this);
		
		// view & Listener
		trollFaceView.setOnTouchListener(this);
		
		// define original position
		x = 0;
		y = 0;
		sx = 0;
		sy = 0;
		fx = 0;
		fy = 0;
		
		// define change position
		dX = dY = aniX = aniY = scaledX = scaledY = 0;
		
		// get png from res
		jizzFace = BitmapFactory.decodeResource(getResources(), R.drawable.jizz_face);
		trollFace = BitmapFactory.decodeResource(getResources(), R.drawable.troll_face);
		
		// view
		setContentView(trollFaceView);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		// call the pause() method we create in TrollfaceMaker
		trollFaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// call the resume() method we create in TrollfaceMaker
		trollFaceView.resume();
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub

		// use listener to get position
		x = event.getX();
		y = event.getY();
		
		// get onTouch events => get finger position
		switch(event.getAction()){
			
			// case finger on screen
			case MotionEvent.ACTION_DOWN :
				sx = event.getX();
				sy = event.getY();
				
				// re-define change position 
				// reset to avoid aniXY keep going up, cause no second shot error
				dX = dY = aniX = aniY = scaledX = scaledY = fx = fy = 0;
				
				break;
				
			// case finger leave screen
			case MotionEvent.ACTION_UP :
				fx = event.getX();
				fy = event.getY();
				
				// calculate moving direction
				dX = fx - sx;
				dY = fy - sy;
				
				// scale the moving speed
				scaledX = dX/60;
				scaledY = dY/60;
				
				// clean the data, reset position to avoid PNG overlap ugly
				x = y = 0;
				
				break;
		}
		// set return true can let motion event keep tracking when finger is on screen and drag
		return true;
	}

	public class TrollfaceMaker extends SurfaceView implements Runnable {

		// set a surface holder
		SurfaceHolder faceHolder;
		
		// set a thread
		Thread faceThread = null;
		
		// set a boolean to control while loop
		boolean isRunning = false;

		public TrollfaceMaker(Context context) {
			// TODO Auto-generated constructor stub

			// use super to use parent
			super(context);

			// call holder
			faceHolder = getHolder();

		}

		// set a method called pause to pause the thread
		public void pause() {
			
			// because run() is activated by isRunning,
			// so change it can do pause.
			isRunning = false;

			// destroy the paused thread
			// while(true) => it will definitely happen
			// join => take back the resource given to the thread
			while (true) {
				try {
					faceThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			// reset the thread, in order to wait next time run
			faceThread = null;
		}

		// set a method called resume to resume the thread again
		public void resume() {
			// because run() is activated by isRunning,
			// so change it can do resume.
			isRunning = true;

			// define thread and pass in this class
			faceThread = new Thread(this);
			
			// start thread, and thread will go to activate run()
			faceThread.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

			// use while loop to check the status of canvas all the time
			while (isRunning) {

				// if holder is "not" valid, then continue.
				// it is a little bit like break;
				// break; will get out the while loop,
				// and also skip the following statements in while loop
				// continue; will stay in the while loop,
				// but it will still skip the following statements in while loop
				// so.. if holder is valid, then continue wont act.
				// loop will go the following statements, active Canvas
				if (!faceHolder.getSurface().isValid()) {
					continue;
				}

				// set a canvas, and use holder to define the canvas
				// and use lockCanvas() to keep canvas away from other access
				// lock until holder finish drawing
				Canvas canvas = faceHolder.lockCanvas();
				
				// draw canvas background
				canvas.drawRGB(2, 2, 150);
				
				// if touch is change the position x & y
				// then draw onTouch trigger png in canvas
				if (x != 0 && y != 0){
					// finger touch trigger
					canvas.drawBitmap(jizzFace, x - (jizzFace.getWidth()/2), y - (jizzFace.getHeight()/2), null);
				}
				if (sx != 0 && sy != 0){
					// finger touch trigger
					canvas.drawBitmap(trollFace, sx - (trollFace.getWidth()/2), sy - (trollFace.getHeight()/2), null);
				}
				if (fx != 0 && fy != 0){
					// finger leave trigger
					canvas.drawBitmap(trollFace, fx - (trollFace.getWidth()/2), fy - (trollFace.getHeight()/2), null);
					// draw an moving face
					canvas.drawBitmap(jizzFace, fx - (jizzFace.getWidth()/2)-aniX, fy - (jizzFace.getHeight()/2)-aniY, null);
				}
				
				// let aniXY keeping changing => PNG shooting
				// because this statement is still in while loop
				aniX = aniX + scaledX;
				aniY = aniY + scaledY;
				
				// unlock canvas to show it on view
				faceHolder.unlockCanvasAndPost(canvas);

			}

		}

	}

}
