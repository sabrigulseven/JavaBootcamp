package com.pcshop.xml;

import org.w3c.dom.*;

import com.pcshop.database.entity.Category;
import com.pcshop.database.entity.Product;
import com.pcshop.database.manager.CategoryManager;

import static com.pcshop.core.utils.XmlHelper.*;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class ProductXml {
    public static Document format(Product product) throws ParserConfigurationException {
        Document document = create("product");
        Element element = document.getDocumentElement();
        element.setAttribute("productId", Long.toString(product.getProductId()));
        addSingleElementText(document, element, "productName", product.getProductName());
        addSingleElementText(document, element, "salesPrice", product.getSalesPrice());
        addSingleElementText(document, element, "categoryName", product.getCategory().getCategoryName());
        return document;
    }

    public static Document format(List<Product> productlist) throws ParserConfigurationException {
        Document document = create("products");
        Element rootelement = document.getDocumentElement();
		for (Product product : productlist) {
            
            Element element = document.createElement("product");
            element.setAttribute("productId", Long.toString(product.getProductId()));
            addSingleElementText(document, element, "productName", product.getProductName());
            addSingleElementText(document, element, "salesPrice", product.getSalesPrice());
            addSingleElementText(document, element, "categoryName", product.getCategory().getCategoryName());
            rootelement.appendChild(element);
        }
		return document;
		
	}

    public static Product format(Document document) {
        Element element = document.getDocumentElement();
        long productId = getAttribute(element, "productId", 0);
        String productName = getSingleElementText(element, "productName", "");
        double salesPrice = getSingleElementText(element, "salesPrice", 0);
        String categoryName = getSingleElementText(element, "categoryName", "");
        CategoryManager categoryManager = new CategoryManager();
        try {
            Category category = categoryManager.find(categoryName);
            Product product = new Product(productId, productName, salesPrice, category);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Product format(Element element) {
        long productId = getAttribute(element, "productId", 0);
        String productName = getSingleElementText(element, "productName", "");
        double salesPrice = getSingleElementText(element, "salesPrice", 0);
        String categoryName = getSingleElementText(element, "categoryName", "");
        CategoryManager categoryManager = new CategoryManager();
        try {
            Category category = categoryManager.find(categoryName);
            Product product = new Product(productId, productName, salesPrice, category);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	
}
