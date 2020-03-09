package com.learning.gof.exam.Command;

public class WindowCommand implements Command {

	private Window window = null;
	
	public WindowCommand(String ipAddress) {
		this.window = new Window(ipAddress);
	}
	
	public WindowCommand(Window window) {
		this.window = window;
		
	}
	
	@Override
	public Result execute() {
		Result result = new Result(Status.OK);
		StringBuilder sb = new StringBuilder();
		if (this.window.isBroken()){
			result.setStatus(Status.CRITICAL);
			sb.append("窗戶被打破");
		}
		if (this.window.isOpen()){
			result.setStatus(Status.CRITICAL);
			if (sb.length() > 0)
				sb.append(", ");
			sb.append("窗戶被打開");
		}
		result.setMessage(sb.toString());
		return result;
	}

}
