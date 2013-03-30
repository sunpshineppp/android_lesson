package com.example.android_lesson;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AccelerateDEMO extends Activity implements SensorEventListener {

	float x, y, sensorX, sensorY;
	Bitmap face;
	
	SensorManager sensorM; 
	
	TrollfaceMaker Trollface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		sensorM = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		// getSensorList() can check is there got this sensor or not.
		// Sensor.TYPE_ACCELEROMETER  means we are calling accelerate sensor, there are many others.
		// getSensorList().size() can return, if return 0, means there is NO sensor.
		if(sensorM.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0){
			
			Sensor s = sensorM.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sensorM.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
			
		};
		
		face = BitmapFactory.decodeResource(getResources(), R.drawable.troll_face);
		x = y = sensorX = sensorY = 0;
		
		Trollface = new TrollfaceMaker(this);
		Trollface.resume();
		
		setContentView(Trollface);
		
	}
	
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		sensorM.unregisterListener(this);
		super.onPause();
	}



	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent e) {
		// TODO Auto-generated method stub
		
		// any time the sensor sense changing, app will trigger onSensorChanged()
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// All values are in SI units (m/s^2) 
		// values[0]: Acceleration minus Gx on the x-axis 
		// values[1]: Acceleration minus Gy on the y-axis 
		// values[2]: Acceleration minus Gz on the z-axis 
		sensorX = e.values[0];
		sensorY = e.values[1];

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

				// set center axis, to let the face shoe in the middle
				// then we use drawBitmap to include sensor modified distance to let the face move.
				float centerX = canvas.getWidth()/2;
				float centerY = canvas.getHeight()/2;
				canvas.drawBitmap(face, centerX + (sensorX * 50), centerY + (sensorX * 50), null);
				// plus 50 is because sensor return is 0~50 in number,
				// if we want to move face more farer, we need to get it larger.
				
				// unlock canvas to show it on view
				faceHolder.unlockCanvasAndPost(canvas);

			}

		}

	}

}
