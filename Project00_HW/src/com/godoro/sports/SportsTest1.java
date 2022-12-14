package com.godoro.sports;

import java.util.ArrayList;

public class SportsTest1 {

	public static void main(String[] args) {

		Team team1 = new Team(801,"Godoro Spor");
		team1.setPlayerList(new ArrayList<>());
		
		Player player1 = new Player(401,"Teoman Alpay", 4.67);
		player1.setTeam(team1);
		team1.getPlayerList().add(player1);
		
		Player player2 = new Player(402, "Yusuf Nalkesen", 7.89);
		player2.setTeam(team1);
		team1.getPlayerList().add(player2);

		Player player3 = new Player(403, "Avni Anıl", 6.61);
		player3.setTeam(team1);
		team1.getPlayerList().add(player3);

		System.out.println(team1.getTeamId() + " " + team1.getTeamName());
		for(Player player : team1.getPlayerList()) {
			
			System.out.println("\t" + player.getPlayerId() + " "
					+player.getPlayerName() + " "
					+player.getAverageScore());
		}
	}

}
