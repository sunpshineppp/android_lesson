package com.example.android_lesson;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

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
	public void pause(){
		// because run() is activated by isRunning, 
		// so change it can do pause.
		isRunning = false;
		
		// destroy the paused thread
		// while(true) => it will definitely happen
		// join => take back the resource given to the thread
		while(true){
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
	public void resume(){
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
			canvas.drawRGB(2,2,150);
			// unlock canvas to show it on view
			faceHolder.unlockCanvasAndPost(canvas);
			
		}

	}

}
