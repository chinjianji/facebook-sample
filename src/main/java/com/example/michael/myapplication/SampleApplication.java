package com.example.michael.myapplication;

import android.app.Application;

import com.facebook.SessionDefaultAudience;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.SimpleFacebookConfiguration;
import com.example.michael.myapplication.utils.SharedObjects;
import com.sromku.simple.fb.utils.Logger;

public class SampleApplication extends Application {
	private static final String APP_ID = "1526145084341651";
//    private static final String APP_ID = "625994234086470";
	private static final String APP_NAMESPACE = "michaelchin_app";
//    private static final String APP_NAMESPACE = "sromkuapp";

	@Override
	public void onCreate() {
		super.onCreate();
		SharedObjects.context = this;

		// set log to true
		Logger.DEBUG_WITH_STACKTRACE = true;

		// initialize facebook configuration
		Permission[] permissions = new Permission[] { 
				Permission.PUBLIC_PROFILE,
				Permission.PUBLISH_ACTION
				};

		SimpleFacebookConfiguration configuration = new SimpleFacebookConfiguration.Builder()
			.setAppId(APP_ID)
			.setNamespace(APP_NAMESPACE)
			.setPermissions(permissions)
			.setDefaultAudience(SessionDefaultAudience.FRIENDS)
			.setAskForAllPermissionsAtOnce(false)
			.build();

		SimpleFacebook.setConfiguration(configuration);
	}
}
