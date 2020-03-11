package com.learning.gof.exam.Command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RedoUdoTest {
	
	class MockRemoteWindow extends Window {
		private boolean isBroken = false;
		private boolean isOpen = false;
		
		public MockRemoteWindow(String ipAddress) {
			super(ipAddress);
		}
		
		public MockRemoteWindow(String ipAddress, boolean isBroken, boolean isOpen) {
			super(ipAddress);
			this.isBroken = isBroken;
			this.isOpen = isOpen;
		}

		@Override
		public boolean isBroken() {
			return this.isBroken;
		}

		@Override
		public boolean isOpen() {
			return this.isOpen;
		}
		
	}

	@Test
	public void redo() {
		Window window = new MockRemoteWindow("127.0.0.1", true, true);
		Command windowCommand = new WindowCommand(window);
		Result result = windowCommand.execute();
		assertEquals(Status.CRITICAL, result.getStatus());
		assertTrue(result.getMessage().indexOf("窗戶被打破") != -1);
		assertTrue(result.getMessage().indexOf("窗戶被打開") != -1);
	}
	
}
