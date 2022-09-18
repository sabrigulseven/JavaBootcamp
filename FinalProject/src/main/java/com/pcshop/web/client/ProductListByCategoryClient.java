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
import com.pcshop.database.entity.Product;
import com.pcshop.xml.ProductXml;

public class ProductListByCategoryClient {
    public static void main(String[] args)
            throws MalformedURLException, IOException, SAXException, ParserConfigurationException {
        
        long categoryId=1;
        String address = String.format("http://localhost:8080/FinalProject/productlist?id=%d", categoryId);
        InputStream in = WebHelper.get(address);
        Document document = XmlHelper.parse(in);
        List<Product> products = new ArrayList<>();
        NodeList productList = document.getElementsByTagName("product");
        for (int i = 0; i < productList.getLength(); i++) {
            Element element = (Element) productList.item(i);
            Product product = ProductXml.format(element);
            products.add(product);
        }
        for (Product product : products) {
            System.out.println(product.getProductId() + " "
                    + product.getProductName() + " "
                    + product.getSalesPrice());
        }

    }
}
