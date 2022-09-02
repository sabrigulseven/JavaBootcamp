package com.godoro.sports.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.Doc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.godoro.core.utils.XmlHelper;
import com.godoro.sports.database.entity.Player;
import com.godoro.sports.database.manager.PlayerManager;
import com.godoro.sports.xml.PlayerXml;

// http://localhost:8080/player/find?id=123;
@WebServlet("/player/find")
public class PlayerFindServlet extends HttpServlet { 
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long playerId = Long.parseLong(request.getParameter("productId")) ;
        PlayerManager playerManager = new PlayerManager();
        Player player = playerManager.find(playerId);
		Document document = PlayerXml.format(player);

		response.setContentType("application/xml ; charset=UTF-8");
		XmlHelper.dump(document, response.getOutputStream());

	}	

}