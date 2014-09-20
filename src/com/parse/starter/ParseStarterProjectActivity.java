package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseAnalytics;
import com.parse.ParseException;

public class ParseStarterProjectActivity extends Activity {
	/** Called when the activity is first created. */
	
	EditText name, quantity, desc, loc;
	Button submit,get;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpened(getIntent());
		
		name = (EditText) findViewById(R.id.nameText);
		quantity = (EditText) findViewById(R.id.quantityText);
		desc = (EditText) findViewById(R.id.descriptionText);
		loc = (EditText) findViewById(R.id.loc);
		
		submit = (Button) findViewById(R.id.submit);
		get = (Button) findViewById(R.id.getAll);
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				resource tmp = getEntry();
				ParseApplication.insertInCloud(tmp);	
				
				name.setText("");
				desc.setText("");
				quantity.setText("");
				loc.setText("");
				
			}
		});
		
		get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					ParseApplication.getAll();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	
	}
	
	public resource getEntry(){
		
		resource  r = new resource();
		
		r.Name = name.getText().toString();
		r.Description = desc.getText().toString();
		r.Location = loc.getText().toString();
		r.quantity = Integer.parseInt(quantity.getText().toString());
		
		return r;
	}
	
	
}
