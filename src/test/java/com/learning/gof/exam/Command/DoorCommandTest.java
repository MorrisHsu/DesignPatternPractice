/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package com.learning.gof.exam.Command;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoorCommandTest {
	class MockRemoteDoor extends Door {
		private String status = null;
		
		public MockRemoteDoor(String ipAddress) {
			super(ipAddress);
		}
		public MockRemoteDoor(String ipAddress, String status) {
			super(ipAddress);
			this.status = status;
		}
		@Override
		public String getDoorStatus(){
			return status;
		}
	}

	@Test
	public void testCommand_DoorOpen() {
		Door door = new MockRemoteDoor("192.168.0.1", "open");
		Command doorCmd = new DoorCommand(door);
		Result result = doorCmd.execute();
		assertEquals(Status.CRITICAL, result.getStatus());
		assertTrue(result.getMessage().startsWith("門被開啟"));
	}
	@Test
	public void testCommand_DoorClose() {
		Door door = new MockRemoteDoor("192.168.0.1", "not open");
		Command doorCmd = new DoorCommand(door);
		Result result = doorCmd.execute();
		assertEquals(Status.OK, result.getStatus());
		assertTrue(result.getMessage().isEmpty());
	}

//	@Test
//	public void testＬLambdaCommand_DoorClose() {
//		Command doorCmd = () -> {
//			Result result = new Result();
//			result.setStatus(HostState.OK);
//			return result;
//		};
//		Result result = doorCmd.execute();
//		assertEquals(Status.OK, result.getStatus());
//		assertTrue(result.getMessage().isEmpty());
//	}

	
	@Test
	public void testServer() {
		Server server = new Server();
		Door door = new MockRemoteDoor("192.168.0.1", "open");
		Client client = new Client(new DoorCommand(door));
		server.addClient(client);
		server.monitor();
	}
}



