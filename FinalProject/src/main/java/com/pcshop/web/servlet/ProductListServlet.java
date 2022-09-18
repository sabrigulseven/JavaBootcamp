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
import com.pcshop.database.entity.Product;
import com.pcshop.database.manager.ProductManager;
import com.pcshop.xml.ProductXml;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductManager productManager = new ProductManager();

		try {
			List<Product> productlist = productManager.list();
			Document document = ProductXml.format(productlist);
			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
