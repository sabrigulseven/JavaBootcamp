package com.pcshop.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.pcshop.core.utils.StreamHelper;
import com.pcshop.core.utils.XmlHelper;
import com.pcshop.database.entity.CartProduct;
import com.pcshop.database.manager.CartManager;
import com.pcshop.database.manager.ProductManager;
import com.pcshop.xml.CartProductXml;
import com.pcshop.xml.CartXml;

/**
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/cart/add")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document document;
		try {
			document = XmlHelper.parse(request.getInputStream());
			CartProduct cartProduct =CartProductXml.format(document);
			CartManager cartManager = new CartManager();
			boolean inserted = cartManager.addCartProduct(cartProduct.getCartId(),cartProduct.getProductId());
			String message = inserted 
					? "Eklendi" 
					: "Eklenmedi";

			StreamHelper.write(response.getOutputStream(), message);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
