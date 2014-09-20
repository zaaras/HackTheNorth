package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseAnalytics;

public class ParseStarterProjectActivity extends Activity {
	/** Called when the activity is first created. */
	
	EditText name, quantity, desc;
	Button submit;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpened(getIntent());
		
		name = (EditText) findViewById(R.id.nameText);
		quantity = (EditText) findViewById(R.id.quantityText);
		desc = (EditText) findViewById(R.id.descriptionText);
		
		submit = (Button) findViewById(R.id.submit);
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				resource tmp = getEntry();
				ParseApplication.insertInCloud(tmp);	
				
				name.setText("");
				desc.setText("");
				quantity.setText("");
			}
		});
	
	}
	
	public resource getEntry(){
		
		resource  r = new resource();
		
		r.Name = name.getText().toString();
		r.Description = desc.getText().toString();
		r.quantity = Integer.parseInt(quantity.getText().toString());
		
		return r;
	}
	
	
}
