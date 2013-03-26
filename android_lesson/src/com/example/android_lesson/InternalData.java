package com.example.android_lesson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
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
		dataOutput = (TextView) findViewById(R.id.dataOutput);

		buSaveData_1.setOnClickListener(this);
		buSaveData_2.setOnClickListener(this);
		buLoadData.setOnClickListener(this);

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

		}

	}

}
