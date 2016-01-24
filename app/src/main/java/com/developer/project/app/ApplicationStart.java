package com.developer.project.app;

import android.app.Application;


public class ApplicationStart extends Application {
    public static final String TAG = "DoctorApp";
    private static String userName = null;
	private static String accountType = null;
	
    public static String getUserName() {
		return userName;
	}

	public static void setUserName(String name) {
		userName = name;
	}

	public static String getAccountType() {
		return accountType;
	}

	public static void setAccountType(String type) {
		accountType = type;
	}


	@Override
	public void onCreate() {
		super.onCreate();
	}
}