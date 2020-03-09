package com.learning.gof.exam.Command;

public class ThermalCommand implements Command {

	private Thermal thermal = null;
	
	public ThermalCommand(String ipAddress) {
		this.thermal = new Thermal(ipAddress);
	}
	
	public ThermalCommand(Thermal thermal) {
		this.thermal = thermal;
	}

	@Override
	public Result execute() {
		Result result = new Result(Status.OK);
		if(this.thermal.isOverheat()) {
			result.setStatus(Status.CRITICAL);
			result.setMessage("溫度過熱");
		}
		return result;
	}

}
