package com.pcshop.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

import com.pcshop.core.utils.XmlHelper;
import com.pcshop.database.entity.Cart;
import com.pcshop.database.manager.CartManager;
import com.pcshop.xml.CartXml;

/**
 * Servlet implementation class CartCreateServlet
 */
@WebServlet("/cart/create")
public class CartCreateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartManager cartManager = new CartManager();
		try {
			Cart cart = cartManager.create(request.getParameter("username"));
			Document document = CartXml.format(cart);
			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
		} catch (SQLException | TransformerException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

}
