package com.pcshop.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import com.pcshop.core.utils.XmlHelper;
import com.pcshop.database.entity.Product;
import com.pcshop.database.manager.ProductManager;
import com.pcshop.xml.ProductXml;

/**
 * Servlet implementation class ProductFindServlet
 */
@WebServlet("/product/find")
public class ProductFindServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long productId = Long.parseLong(request.getParameter("id"));
		ProductManager productManager = new ProductManager();
		Document document;
		try {
			Product product = productManager.find(productId);
			document = ProductXml.format(product);
			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
