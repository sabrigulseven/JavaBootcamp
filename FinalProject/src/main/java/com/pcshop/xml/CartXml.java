package com.pcshop.xml;

import static com.pcshop.core.utils.XmlHelper.addSingleElementText;
import static com.pcshop.core.utils.XmlHelper.create;
import static com.pcshop.core.utils.XmlHelper.getAttribute;
import static com.pcshop.core.utils.XmlHelper.getSingleElementText;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcshop.database.entity.Cart;


public class CartXml {
	public static Document format(Cart cart) throws ParserConfigurationException {
        Document document = create("cart");
        Element element = document.getDocumentElement();
        element.setAttribute("cartId", Long.toString(cart.getCartId()));
        addSingleElementText(document, element, "customerName", cart.getCustomerName());
        addSingleElementText(document, element, "totalAmount", cart.getTotalAmount());
        return document;
    }
	
	public static Cart format(Document document) {
        Element element = document.getDocumentElement();
        long cartId = getAttribute(element, "cartId", 0);
        String customerName = getSingleElementText(element, "customerName", "");
        double totalAmount = getSingleElementText(element, "totalAmount", 0);
        try {
        	Cart cart = new Cart(cartId, totalAmount, customerName);
            return cart;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
