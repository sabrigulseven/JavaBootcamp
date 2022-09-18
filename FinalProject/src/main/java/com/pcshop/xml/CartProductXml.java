package com.pcshop.xml;

import static com.pcshop.core.utils.XmlHelper.addSingleElementText;
import static com.pcshop.core.utils.XmlHelper.create;
import static com.pcshop.core.utils.XmlHelper.getAttribute;
import static com.pcshop.core.utils.XmlHelper.getSingleElementText;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcshop.database.entity.CartProduct;
import com.pcshop.database.entity.Product;

public class CartProductXml {
	public static Document format(CartProduct cartProduct) throws ParserConfigurationException {
        Document document = create("cartProduct");
        Element element = document.getDocumentElement();
        element.setAttribute("cartProductId", Long.toString(cartProduct.getCartProductId()));
        addSingleElementText(document, element, "cartId", cartProduct.getCartId());
        addSingleElementText(document, element, "productId", cartProduct.getCartProductId());
        addSingleElementText(document, element, "salesQuantity", cartProduct.getSalesQuantity());
        addSingleElementText(document, element, "salesPrice", cartProduct.getSalesPrice());
        return document;
    }
	
	public static CartProduct format(Document document) {
        Element element = document.getDocumentElement();
        return format(element);
	}
	
	public static Document format(List<CartProduct> productlist) throws ParserConfigurationException {
        Document document = create("products");
        Element rootelement = document.getDocumentElement();
		for (CartProduct cartProduct : productlist) {
            
            Element element = document.createElement("cartProduct");
            element.setAttribute("cartProductId", Long.toString(cartProduct.getCartProductId()));
            addSingleElementText(document, element, "cartId", cartProduct.getCartId());
            addSingleElementText(document, element, "productId", cartProduct.getProductId());
            addSingleElementText(document, element, "salesQuantity", cartProduct.getSalesQuantity());
            addSingleElementText(document, element, "salesPrice", cartProduct.getSalesPrice());
            rootelement.appendChild(element);
        }
		return document;
		
	}

	public static CartProduct format(Element element) {
		long cartProductId = getAttribute(element, "cartProductId", 0);
        long cartId = (long) getSingleElementText(element, "cartId", 0);
        long productId = (long) getSingleElementText(element, "productId", 0);
        int salesQuantity = (int) getSingleElementText(element, "salesQuantity", 0);
        double salesPrice = getSingleElementText(element, "salesPrice", 0);
        try {
        	CartProduct cart = new CartProduct(cartProductId, cartId, productId, salesQuantity, salesPrice);
            return cart;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
