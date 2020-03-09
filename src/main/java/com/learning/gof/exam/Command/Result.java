package com.learning.gof.exam.Command;

public class Result {
	private Status status;
	private String message = "";
	
	public  Result(Status status) {
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setMessage(String msg) {
		message = msg;
	}
}
