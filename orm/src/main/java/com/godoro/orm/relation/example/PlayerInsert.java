package com.godoro.orm.relation.example;

import com.godoro.orm.relation.entity.Player;
import com.godoro.orm.relation.repository.PlayerRepository;

public class PlayerInsert {
    public static void main(String[] args) {
        Player player = new Player(0,"Arif sağ",4.3);
        PlayerRepository playerRepository=new PlayerRepository();
        playerRepository.insert(player);
    }
}
