package com.godoro.orm.relation.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.godoro.orm.relation.entity.Player;


public class TestFilter{
    public static void main(String[] args) {
        long teamId = 2;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager manager = factory.createEntityManager();
        String jpql = "select p from player where p.team.teamId :teamId";
        TypedQuery<Player> query = manager.createQuery(jpql,Player.class);
        query.setParameter("teamId", teamId);
        List<Player> playerList = query.getResultList();
        for (Player player : playerList) {
            System.out.println(player.getPlayerName()+" "+player.getAverageScore());
        }
        manager.close();
        factory.close();
    
    }
}