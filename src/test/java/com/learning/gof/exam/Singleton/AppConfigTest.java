package com.learning.gof.exam.Singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AppConfigTest {
	@Test
	public void default_instance_is_not_null() {
		assertNotNull(AppConfig.getInstance());
	}
	@Test
	public void call_getInstance_twice_gets_the_same_instance() {
		assertEquals(AppConfig.getInstance(), AppConfig.getInstance());
	}
	@Test (expected = IllegalAccessException.class) 
	public void cannot_call_the_default_constructor() throws Exception {
		   String className = "com.learning.gof.exam.Singleton.AppConfig";
		   Class<?> c =  Class.forName(className);
		   assertNotNull((AppConfig) c.newInstance());
	}
}

