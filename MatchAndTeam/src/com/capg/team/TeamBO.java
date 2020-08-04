package com.capg.team;

import com.capg.player.Player;

public class TeamBO {
	
	public Team createTeam(String data,Player[] playerList) {
		
		String[] teamInfo = data.split(",");
		
		Team t = new Team();
		t.setName(teamInfo[0]);
		for(Player player : playerList) {
			
			if(player.getName().equalsIgnoreCase(teamInfo[1])) {
				t.setPlayer(player);
			}
		}
		return t;
		
	}

}
