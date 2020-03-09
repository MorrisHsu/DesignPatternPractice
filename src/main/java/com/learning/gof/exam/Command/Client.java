package com.learning.gof.exam.Command;

public class Client<T> {
	private T checkCommand;
	private Result currentResult = new Result(Status.PENDING);
	
	public Client(T command) {
		this.checkCommand = command;
	}
	public void setCurrentResult(Result result) {
		currentResult = result;
	}
	public Result getCurrentResult() {
		return currentResult;
	}
	public void setCheckCommand(T command) {
		this.checkCommand = command;
	}
	public T getCheckCommand() {
		return checkCommand;
	}
}
