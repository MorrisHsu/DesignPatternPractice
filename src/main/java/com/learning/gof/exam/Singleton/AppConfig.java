package com.learning.gof.exam.Singleton;

public class AppConfig {
	
	private static AppConfig appConfig = null;

	private AppConfig() {
		
	}
	
	public static AppConfig getInstance() {
		if(null == appConfig) {
			appConfig = new AppConfig();
		}
		return appConfig;
	}
	
}
