package com.godoro.sports.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.StreamHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.godoro.core.utils.StreamHelper;
import com.godoro.core.utils.XmlHelper;
import com.godoro.sports.database.entity.Player;
import com.godoro.sports.database.manager.PlayerManager;
import com.godoro.sports.xml.PlayerXml;

@WebServlet("/player/insert")
public class PlayerInsertServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document document = XmlHelper.parse(request.getInputStream());
        Player player = PlayerXml.parse(document);
        PlayerManager playerManager = new PlayerManager();
        boolean inserted =   playerManager.insert(player);
        String result=inserted
            ?"Eklendi"
            :"Eklenmedi";
        StreamHelper.write(response.getOutputStream(), result);
    }
}
