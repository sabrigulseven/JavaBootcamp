package com.godoro.orm.relation.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.orm.relation.entity.Player;
import com.godoro.orm.relation.entity.Team;

public class TestInsert {
    public static void main(String[] args) {
        Team teamA = new Team(0, "godoro");
        teamA.setPlayerList(new ArrayList<Player>());

        Player player1 = new Player(0, "Neşet Ertaş", 1232);
        player1.setTeam(teamA);
        teamA.getPlayerList().add(player1);

        Player player2 = new Player(0, "Neşet Ertaş", 1232);
        player2.setTeam(teamA);
        teamA.getPlayerList().add(player2);

        Player player3 = new Player(0, "Neşet Ertaş", 1232);
        player3.setTeam(teamA);
        teamA.getPlayerList().add(player3);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(teamA);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
