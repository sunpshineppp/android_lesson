package com.example.android_lesson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoveMail extends Activity implements View.OnClickListener {

	// 設定此CLASS可通用的變數
	EditText name;
	String nameString;
	EditText firstDate;
	String firstDateString;
	EditText action;
	String actionString;
	EditText amount;
	String amountString;
	EditText time;
	String timeString;
	EditText mail;
	String mailString;

	String emailContent;
	Button sent;

	@Override
	protected void onCreate(Bundle love) {
		// TODO Auto-generated method stub
		super.onCreate(love);

		// 將這個JAVA黨跟XML檔連接在一起，這樣Manifest呼叫這個JAVA時，在這裡就會去建立VIEW。
		setContentView(R.layout.love_mail);

		initialzeVars();

		sent.setOnClickListener(this);

	}

	private void initialzeVars() {

		// 將已設好的變數，跟VIEW連接在一起。
		name = (EditText) findViewById(R.id.nameInput);
		firstDate = (EditText) findViewById(R.id.firstDateInput);
		action = (EditText) findViewById(R.id.actionInput);
		amount = (EditText) findViewById(R.id.amountInput);
		time = (EditText) findViewById(R.id.timeInput);
		mail = (EditText) findViewById(R.id.mailInput);
		
		sent = (Button) findViewById(R.id.buSent);

	}

	public void onClick(View bu) {

		magicOfTextToString();

		String mailAddress[] = { mailString };


		String emailContent = "Dear "
				+ nameString
				+ ", "
				+ '\n'
				+ "Remember the first time I meet you, you looked like Chrismas`s morning. "
				+ '\n'
				+ "And from that day began, "
				+ firstDateString
				+ ",you completed my life. "
				+ '\n'
				+ "I would to "
				+ actionString
				+ " to show you how much I love you. "
				+ '\n'
				+ "If there is a scale to measure my feeling about loving you... "
				+ "I will say it would be greater than " + amountString + "."
				+ '\n' + "If God have me to give an end of our love... "
				+ "I will make it " + timeString + ".";

		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, mailAddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Love Letter For " + nameString);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailContent);
		startActivity(emailIntent);

	}

	private void magicOfTextToString() {
		// TODO Auto-generated method stub

		nameString = name.getText().toString();
		firstDateString = firstDate.getText().toString();
		actionString = action.getText().toString();
		amountString = amount.getText().toString();
		timeString = time.getText().toString();

		mailString = mail.getText().toString();

	}

}
