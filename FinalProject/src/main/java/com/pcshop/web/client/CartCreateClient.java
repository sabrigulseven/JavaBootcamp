package com.pcshop.web.client;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.pcshop.core.utils.WebHelper;
import com.pcshop.core.utils.XmlHelper;
import com.pcshop.database.entity.Cart;
import com.pcshop.xml.CartXml;

public class CartCreateClient {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		String username = "user1";
        String address = "http://localhost:8080/FinalProject/cart/create?username="+ username;
        InputStream in = WebHelper.get(address);
        Document document = XmlHelper.parse(in);
        Cart cart = CartXml.format(document);
        System.out.println(cart.getCartId()+ " "
                + cart.getCustomerName() + " "
                + cart.getTotalAmount());
	}

}
