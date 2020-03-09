package com.learning.gof.exam.Command;

public class DoorCommand implements Command {

	private Door door = null;
	
	public DoorCommand(String ipAddress){
		this.door = new Door(ipAddress);
	}
	
	public DoorCommand(Door door){
		this.door = door;
	}
	
	@Override
	public Result execute() {
		Result result = new Result(Status.OK);
		if("open".equals(this.door.getDoorStatus())) {
			result.setStatus(Status.CRITICAL);
			result.setMessage("門被開啟");
		}
		return result;
	}

}
