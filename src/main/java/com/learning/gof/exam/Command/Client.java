package com.learning.gof.exam.Command;

public class Client {
	private Command checkCommand;
	private Result currentResult = new Result(Status.PENDING);
	
	public Client(Command command) {
		this.checkCommand = command;
	}
	public void setCurrentResult(Result result) {
		currentResult = result;
	}
	public Result getCurrentResult() {
		return currentResult;
	}
	public void setCheckCommand(Command command) {
		this.checkCommand = command;
	}
	public Command getCheckCommand() {
		return checkCommand;
	}
}
