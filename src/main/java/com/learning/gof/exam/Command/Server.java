package com.learning.gof.exam.Command;

import java.util.ArrayList;
import java.util.List;

public class Server {
	
	private List<Client> clients = new ArrayList<>();
	
	public void monitor(){
		for(Client client : clients){
			client.setCurrentResult(client.getCheckCommand().execute());
			if (Status.OK != client.getCurrentResult().getStatus()) {
				sendAlert(client.getCurrentResult().getMessage());
			}
		}
	}
	public void sendAlert(String msg){
		System.out.println("發現問題並通知保全人員: " + msg);
	}
	
	public void addClient(Client client){
		this.clients.add(client);
	}

}



