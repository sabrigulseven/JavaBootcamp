package com.godoro.sports;

import java.util.ArrayList;

public class SportsTest2 {

	public static void main(String[] args) {
		
		LeagueList leagueList = new LeagueList();
		leagueList.setLeagueList(new ArrayList<>());
		
		League league1 = new League(601, "Superlig");
		leagueList.getLeagueList().add(league1);
		
		league1.setTeamList(new ArrayList<>());
		
		Team team1 = new Team(801,"Godoro Spor");
		league1.getTeamList().add(team1);
		team1.setPlayerList(new ArrayList<>());	
		
		Player player1 = new Player(401,"Teoman Alpay", 4.67);
		player1.setTeam(team1);
		team1.getPlayerList().add(player1);
		
		Player player2 = new Player(402, "Yusuf Nalkesen", 7.89);
		player2.setTeam(team1);
		team1.getPlayerList().add(player2);

		Player player3 = new Player(404, "Avni Anıl", 6.61);
		player3.setTeam(team1);
		team1.getPlayerList().add(player3);
		
		Team team2 = new Team(802,"Fibiler Spor");
		league1.getTeamList().add(team2);
		team2.setPlayerList(new ArrayList<>());
		
		Player player4 = new Player(403, "Yıldırım Gürses", 2.93);
		player4.setTeam(team2);
		team2.getPlayerList().add(player4);
		
		Player player5 = new Player(405, "Erdoğan Berker", 8.11);
		player5.setTeam(team2);
		team2.getPlayerList().add(player5);
		
		for(League league : leagueList.getLeagueList()) {
			
			System.out.println(league.getLeagueId() + " " + league.getLeagueName());
			
			for(Team team : league.getTeamList()) {
				
				System.out.println("\t" + team.getTeamId() + " " + team.getTeamName());
				for (Player player : team.getPlayerList()) {
					
					System.out.println("\t" + "\t" + player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
					
				}
			}
		}
	}

}
