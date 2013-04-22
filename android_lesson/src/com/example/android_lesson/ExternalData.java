package com.example.android_lesson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.sunpshine.android_lesson.R;

public class ExternalData extends Activity implements OnClickListener,
		OnItemSelectedListener {

	// remember to add permission in manifest
	// android:permission.WRITE_EXTERNAL_STORAGE
	
	// "private" means these variables only can be access in this class
	private TextView canWrite, canRead;
	private String storageState;

	boolean canW, canR;

	EditText fileNameInput;
	Button buConfirm;
	Button buSave;

	Spinner pathOption;
	String[] paths = { "Music", "Pictures", "Download" };

	File pathName = null;
	File file = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.external_data);

		canWrite = (TextView) findViewById(R.id.canWrite);
		canRead = (TextView) findViewById(R.id.canRead);

		fileNameInput = (EditText) findViewById(R.id.fileNameInput);
		buConfirm = (Button) findViewById(R.id.buConfirm);
		buSave = (Button) findViewById(R.id.buSave);

		// setup Spinner and OnItemSelectedListener
		pathOption = (Spinner) findViewById(R.id.pathOption);
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
				ExternalData.this, android.R.layout.simple_spinner_item, paths);
		pathOption.setAdapter(spinnerAdapter);
		pathOption.setOnItemSelectedListener(this);

		buConfirm.setOnClickListener(this);
		buSave.setOnClickListener(this);

		checkStorageState();

	}

	private void checkStorageState() {
		// TODO Auto-generated method stub

		// get state by call Environment
		storageState = Environment.getExternalStorageState();

		// use if to check storageState, then change TextView
		// string compare must use .equals(string)
		if (storageState.equals(Environment.MEDIA_MOUNTED)) {
			// MEDIA_MOUNTED => R/W OK
			canWrite.setText("true");
			canRead.setText("true");
			canW = canR = true;

		} else if (storageState.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			// MEDIA_MOUNTED_READ_ONLY => R OK
			canWrite.setText("false");
			canRead.setText("true");
			canW = false;
			canR = true;
		} else {
			canWrite.setText("false");
			canRead.setText("false");
			canW = canR = false;
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.buConfirm:
			// let save button VISIBLE ~
			buSave.setVisibility(View.VISIBLE);
			break;

		case R.id.buSave:

			String fileNameData = fileNameInput.getText().toString();
			
			// try to fix .png problem
			int searchLoc_1 = fileNameData.indexOf(".PNG");
			int searchLoc_2 = fileNameData.indexOf(".png");
			// both can not be found, so we add it.
			if(searchLoc_1 == -1 && searchLoc_2 == -1)
				fileNameData = fileNameData + ".png";
			
			// public File (File dir, String name)
			file = new File(pathName, fileNameData);

			checkStorageState();
			// check is it can be save ?
			// if it is, we call a exist file for this demo from drawable
			// it is just for easy demo and test
			if (canW == canR == true) {
				
				// check the path is exist or not,
				// if it is, then save
				// if it is not, then create one.
				// Creates the directory named by this file, 
				// Use mkdirs() creating missing parent directories if necessary. 
				// Use mkdir() if you don't want to create missing parents. 
				pathName.mkdirs();
				
				try {
					InputStream is = getResources().openRawResource(
							R.drawable.troll_face);
					OutputStream os = new FileOutputStream(file);
					byte[] data = new byte[is.available()];
					is.read(data);
					os.write(data);
					is.close();
					os.close();
					
					// use toast to show the saving is COMPELETE
					Toast savingReport = Toast.makeText(ExternalData.this, "File has been saved ", Toast.LENGTH_LONG);
					savingReport.show();
					
					// Update files for the user to use
					// we trigger mediaScanner to update right after the file is saved.
					// otherwise it might take a while for user to see the saving file in folder.
					MediaScannerConnection.scanFile(ExternalData.this,
							new String[] {file.toString()}, 
							null, 
							new MediaScannerConnection.OnScanCompletedListener(){

								@Override
								public void onScanCompleted(String arg0,
										Uri arg1) {
									// TODO Auto-generated method stub
									Toast MediaUpdateReport = Toast.makeText(ExternalData.this,
											"MediaUpdate is OK",
											Toast.LENGTH_SHORT);
								}
						
					});
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			break;

		}

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		// use listener to get which item is selected.
		int itemSelected = pathOption.getSelectedItemPosition();
		// according itemSelected, switch case to response
		switch (itemSelected) {

		case 0:
			pathName = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;
		case 1:
			pathName = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;
		case 2:
			pathName = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
