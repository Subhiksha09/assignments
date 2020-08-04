package com.capg.player;

public class PlayerBO {
	
	public Player createPlayer(String data) {
		
		String[] playerInfo =data.split(",");
		return new Player(playerInfo[0], playerInfo[1], playerInfo[2]);
		
	}
}