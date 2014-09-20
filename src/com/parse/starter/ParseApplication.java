package com.parse.starter;

import java.util.jar.Attributes.Name;

import android.app.Application;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class ParseApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		// Add your initialization code here
		Parse.initialize(this, "3xb92uewkwGwRGulPj9spBCNiD2Dx4Uy7bvFLXdu", "HlimuCif48Tz2xw73ne9Jg66kERQWYofvv0NQ7Pl");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		/*
		ParseObject testObject = new ParseObject("Resources");
		testObject.put("name", "orange");
		testObject.put("qauntity", 1);
		testObject.put("Description", "Its yellow");
		testObject.saveInBackground();
		*/
		
		
		
	}
	
	public static void insertInCloud(resource r){
		ParseObject testObject = new ParseObject("Resources");
		testObject.put("name", r.Name);
		testObject.put("qauntity", r.quantity);
		testObject.put("Description", r.Description);
		
		testObject.saveInBackground();
	}



}
