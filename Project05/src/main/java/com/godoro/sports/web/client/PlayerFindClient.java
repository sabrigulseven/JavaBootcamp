package com.godoro.sports.web.client;

import java.io.InputStream;

import org.w3c.dom.Document;

import com.godoro.core.utils.WebHelper;
import com.godoro.core.utils.XmlHelper;
import com.godoro.sports.database.entity.Player;
import com.godoro.sports.xml.PlayerXml;

public class PlayerFindClient {
    public static void main(String[] args) {
        long productId = 123;
        String adress = String.format("htttp://localhost:8080/player/find?id=%d", productId);
        InputStream in = WebHelper.get(adress);
        Document document = XmlHelper.parse(in);
        Player player = PlayerXml.parse(document);
        System.out.println(player.getPlayerId()+" " 
            +player.getPlayerName()+ " "
            +player.getAverageScore());
    }
}
