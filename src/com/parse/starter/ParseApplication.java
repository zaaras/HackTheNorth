package com.parse.starter;

import java.util.LinkedList;
import java.util.List;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class ParseApplication extends Application {
	
	public static String table_name = "Resources";
	
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

	}
	
	public static void insertInCloud(resource r){
		ParseObject testObject = new ParseObject(table_name);
		testObject.put("name", r.Name);
		testObject.put("qauntity", r.quantity);
		testObject.put("Description", r.Description);
		testObject.put("location", r.Location);
		
		testObject.saveInBackground();
	}
	
	public static LinkedList<resource> getAll() throws ParseException{
		LinkedList<resource> rList = new LinkedList<resource>();
		resource tmp;
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery(table_name);
		query.whereContains("name", "");
		List<ParseObject> bla = query.find();
		
		int i=0;
		
		for(i=0;i<bla.size();i++){
			tmp = parseObjectToResource(bla.get(i));
			rList.add(tmp);
			Log.i("Resource Tracker ",tmp.Name );
		}
		
		return rList;
		
	}

	
	 static resource parseObjectToResource(ParseObject po){
		resource ret = new resource();
		
		ret.Description = po.getString("Description");
		ret.Name = po.getString("name");
		ret.Location = po.getString("location");
		ret.quantity = po.getInt("quantity");
		
		return ret;
	}


}
