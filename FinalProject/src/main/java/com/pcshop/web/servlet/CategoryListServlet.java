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
import com.pcshop.database.entity.Category;
import com.pcshop.database.manager.CategoryManager;
import com.pcshop.xml.CategoryXml;

@WebServlet("/categories")
public class CategoryListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CategoryManager categoryManager = new CategoryManager();
    	try {
			List<Category> categoryList =categoryManager.list();
			Document document = CategoryXml.format(categoryList);
			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
