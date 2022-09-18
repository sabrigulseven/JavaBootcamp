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
import com.pcshop.database.entity.Product;
import com.pcshop.database.manager.ProductManager;
import com.pcshop.xml.ProductXml;

@WebServlet("/product/insert")
public class ProductInsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document document;
		try {
			document = XmlHelper.parse(request.getInputStream());
			Product product = ProductXml.format(document);
			ProductManager productManager = new ProductManager();
			boolean inserted = productManager.insert(product);
			String message = inserted 
					? "Eklendi" 
					: "Eklenmedi";

			StreamHelper.write(response.getOutputStream(), message);

		} catch (SAXException | IOException | ParserConfigurationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
