package com.pcshop.web.client;

import java.io.IOException;

import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

import com.pcshop.core.utils.WebHelper;
import com.pcshop.core.utils.XmlHelper;
import com.pcshop.database.entity.CartProduct;
import com.pcshop.xml.CartProductXml;

public class CartAddClient {

	public static void main(String[] args) {
		String adress="http://localhost:8080/FinalProject/cart/add";
		
			CartProduct cartProduct = new CartProduct(0, 7, 15, 1, 2322);
			try {
				Document document = CartProductXml.format(cartProduct);
				URLConnection connection= WebHelper.connect(adress);
				connection.setDoOutput(true);
				XmlHelper.dump(document, connection.getOutputStream());
			} catch (ParserConfigurationException | TransformerException | IOException e) {
				e.printStackTrace();
			}
		
	}
	
}
