package com.example.email;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b = (Button) findViewById(R.id.btn);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {

					String[] to = { "mcavalheiro@gmail.com",
							"mcavalheiro@gmail.com" };
					String[] cc = { "" };
					sendEmail(to, cc, "Hello", "Hello my friends!");

				} catch (Exception e) {

				}
			}
		});

	}

	private void sendEmail(String[] emailAddresses, String[] carbonCopies,
			String subject, String message) {
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setData(Uri.parse("mailto:"));
		String[] to = emailAddresses;
		String[] cc = carbonCopies;
		emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
		emailIntent.putExtra(Intent.EXTRA_CC, cc);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, message);
		emailIntent.setType("message/rfc822");
		startActivity(Intent.createChooser(emailIntent, "Email"));
	}

}
