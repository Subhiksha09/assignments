package com.capg.team;

import com.capg.player.Player;

public class Team {
	

	@Override
	public String toString() {
		return String.format("Team [name=%s, player=%s]", name, player);
	}
	private String name;
	private Player player;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Team(String name, Player player) {
		super();
		this.name = name;
		this.player = player;
	}
	public Team() {
		super();
	}

}
