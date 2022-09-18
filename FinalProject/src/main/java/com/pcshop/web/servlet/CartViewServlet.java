package com.pcshop.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.pcshop.core.utils.XmlHelper;
import com.pcshop.database.entity.CartProduct;
import com.pcshop.database.manager.CartManager;
import com.pcshop.xml.CartProductXml;

/**
 * Servlet implementation class CartViewServlet
 */
@WebServlet("/cart/view")
public class CartViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long cartId = Long.parseLong(request.getParameter("id"));

		CartManager cartManager = new CartManager();
		try {
			List<CartProduct> cartProductList = cartManager.viewCartProduct(cartId);
			Document document = CartProductXml.format(cartProductList);
			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

}
