package com.example.android_lesson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	EditText dataInput;
	Button buSaveData_1;
	Button buSaveData_2;
	Button buLoadData;
	Button buLoadDataByAsyncTask;
	TextView dataOutput;

	FileOutputStream dataSave;
	String FILENAME = "InternalString";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.internal_data);

		initialize();
	}

	private void initialize() {

		dataInput = (EditText) findViewById(R.id.dataInput);
		buSaveData_1 = (Button) findViewById(R.id.buSaveDataByFileMethod);
		buSaveData_2 = (Button) findViewById(R.id.buSaveDataByWriteMethod);
		buLoadData = (Button) findViewById(R.id.buLoadData);
		buLoadDataByAsyncTask = (Button) findViewById(R.id.buLoadDataByAsyncTask);
		dataOutput = (TextView) findViewById(R.id.dataOutput);

		buSaveData_1.setOnClickListener(this);
		buSaveData_2.setOnClickListener(this);
		buLoadData.setOnClickListener(this);
		buLoadDataByAsyncTask.setOnClickListener(this);

		try {
			dataSave = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			try {
				dataSave.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.buSaveDataByFileMethod:

			String dataString_1 = dataInput.getText().toString();
			File x = new File(FILENAME);

			try {
				dataSave = new FileOutputStream(x);
				try {
					dataSave.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case R.id.buSaveDataByWriteMethod:

			String dataString_2 = dataInput.getText().toString();
			try {
				dataSave = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				try {
					dataSave.write(dataString_2.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					dataSave.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case R.id.buLoadData:

			String dataReaded = null;
			FileInputStream dataLoad = null;
			try {
				dataLoad = openFileInput(FILENAME);
				try {
					byte[] dataArray = new byte[dataLoad.available()];

					while (dataLoad.read(dataArray) != -1) {
						// after read() read every bytes in dataArray, it will
						// return -1.
						// so, use -1 to trigger while loop means data is fully
						// read.
						dataReaded = new String(dataArray);

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					dataLoad.close();
					dataOutput.setText(dataReaded);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			break;

		case R.id.buLoadDataByAsyncTask:

			// create an new class to hold an new thread
			// in order to load data separately,
			// instead of use UI method to handle data transfer process.
			new loadStuff().execute(FILENAME);
			break;

		}

	}

	// an new class for case R.id.buLoadDataByAsyncTask:
	// and after extends " AsyncTask <String, Integer, String> "
	// the unimplemented method will be "doInBackground"
	// and this is what we want => to do data process in background.
	// here we show that AsyncTask 4 different methods to handle background
	// process,
	// onPreExecute()
	// doInBackground(String...)
	// onProgressUpdate(Integer...)
	// onPostExecute(String)
	public class loadStuff extends AsyncTask<String, Integer, String> {

		ProgressDialog dialog;
		
		protected void onPreExecute() {
			
			dialog = new ProgressDialog(InternalData.this);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.show();
			
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub

			String dataReaded = null;
			FileInputStream dataLoad = null;
			
			// this for loop is for dialog demo
			// loop will sent 5 for 20 times, 
			// to show 0~100% in dialog. 
			// this 5 is pass to onProgressUpdate(Integer...) as 5 is an Integer.
			for(int i = 0; i < 20 ; i++){
				publishProgress(5);
				// use sleep to avoid dialog finish too fast.
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// after loop bring dialog to 100%,
			// close the dialog.
			dialog.dismiss();
			
			try {
				dataLoad = openFileInput(FILENAME);
				try {
					byte[] dataArray = new byte[dataLoad.available()];

					while (dataLoad.read(dataArray) != -1) {
						// after read() read every bytes in dataArray, it will
						// return -1.
						// so, use -1 to trigger while loop means data is fully
						// read.
						dataReaded = new String(dataArray);

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					dataLoad.close();
					// here use return is different than case R.id.buLoadData
					return dataReaded;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return null;
		}

		protected void onProgressUpdate(Integer... progress) {

			dialog.incrementProgressBy(progress[0]);
			
		}

		protected void onPostExecute(String result) {
			dataOutput.setText(result);
		}

	}
}
