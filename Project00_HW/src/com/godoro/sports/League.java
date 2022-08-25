package com.godoro.sports;

import java.util.List;

public class League {
	
	private int leagueId;
	private String leagueName;
	private List<Team> teamList;

	public int getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public List<Team> getTeamList() {
		return teamList;
	}
	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}
	public League(int leagueId, String leagueName) {
		this.leagueId = leagueId;
		this.leagueName = leagueName;
	}
	
}
