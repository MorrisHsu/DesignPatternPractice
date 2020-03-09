package com.learning.gof.exam.Command;

import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<Client<Door>> doors = new ArrayList<>();
	private List<Client<Window>> windows = new ArrayList<>();
	private List<Client<Thermal>> thermals = new ArrayList<>();

	public void monitor(){
		for(Client<Door> door: doors){
			if ("open".equals(door.getCheckCommand().getDoorStatus() ))
				sendAlert("門被打開");
		}
		for(Client<Window> window: windows){
			if (window.getCheckCommand().isOpen())
				sendAlert("窗戶被開啟");
			if (window.getCheckCommand().isBroken())
				sendAlert("窗戶被打破");
		}
		for(Client<Thermal> thermal: thermals){
			if (thermal.getCheckCommand().isOverheat())
				sendAlert("溫度過熱");
		}
	}
	public void sendAlert(String msg){
		System.out.println("發現問題並通知保全人員: " + msg);
	}
	
	public void addDoor(Client<Door> client){
		doors.add(client);
	}
	
	public void addWindow(Client<Window> client){
		windows.add(client);
	}
	
	public void addThermal(Client<Thermal> client){
		thermals.add(client);
	}
}



