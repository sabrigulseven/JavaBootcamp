package com.pcshop.web.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.pcshop.core.utils.WebHelper;
import com.pcshop.core.utils.XmlHelper;
import com.pcshop.database.entity.CartProduct;
import com.pcshop.xml.CartProductXml;

public class CartViewClient {

	public static void main(String[] args) throws MalformedURLException, IOException, SAXException, ParserConfigurationException {
		long cartid=11;
        String address = String.format("http://localhost:8080/FinalProject/cart/view?id=%d", cartid);
        InputStream in = WebHelper.get(address);
        Document document = XmlHelper.parse(in);
        List<CartProduct> products = new ArrayList<>();
        NodeList productList = document.getElementsByTagName("cartProduct");
        for (int i = 0; i < productList.getLength(); i++) {
            Element element = (Element) productList.item(i);
            CartProduct product = CartProductXml.format(element);
            products.add(product);
        }
        for (CartProduct product : products) {
            System.out.println(product.getProductId() + " "
                    + product.getCartId() + " "
                    + product.getSalesPrice());
        }
	}

}
