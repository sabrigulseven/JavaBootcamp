package com.godoro.sports;

import java.util.List;

public class Team {
	private int teamId;
	private String teamName;
	
	private List<Player> playerList;
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Team(int teamId, String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}
	public Team() {
	}
	public List<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	
	
}
