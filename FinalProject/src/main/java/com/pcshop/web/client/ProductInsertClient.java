package com.pcshop.web.client;

import java.io.IOException;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

import com.pcshop.core.utils.StreamHelper;
import com.pcshop.core.utils.WebHelper;
import com.pcshop.core.utils.XmlHelper;
import com.pcshop.database.entity.Product;
import com.pcshop.xml.ProductXml;

public class ProductInsertClient {
    public static void main(String[] args) throws TransformerException, IOException, ParserConfigurationException {
        String address = "http://localhost:8080/product/insert";
        Product product = new Product(); //create product 
        Document document = ProductXml.format(product);
        URLConnection connection = WebHelper.connect(address);
        XmlHelper.dump(document, connection.getOutputStream());
        String result = StreamHelper.read(connection.getOutputStream());
        System.out.println(result);

    }
}
