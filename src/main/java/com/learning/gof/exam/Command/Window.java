package com.learning.gof.exam.Command;

public class Window {

	public Window(String ipAddress){
	}

	public boolean isBroken(){
		// TODO: 與遠端 client 溝通，並傳回窗戶是否被打破
		// 此類別實作由廠商提供
		return false;
	}

	public boolean isOpen(){
		// TODO: 與遠端 client 溝通，並傳回窗戶開啟或關閉狀態
		// 此類別實作由廠商提供
		return false;
	}
}
