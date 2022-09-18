package com.pcshop.web.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.pcshop.core.utils.WebHelper;
import com.pcshop.core.utils.XmlHelper;
import com.pcshop.database.entity.Product;
import com.pcshop.xml.ProductXml;

public class ProductFindClient {
    public static void main(String[] args) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        long productId = 1;
        String address = String.format("http://localhost:8080/FinalProject/product/find?id=%d", productId);
        InputStream in = WebHelper.get(address);
        Document document = XmlHelper.parse(in);
        Product product = ProductXml.format(document);
        System.out.println(product.getProductId() + " "
                + product.getProductName() + " "
                + product.getSalesPrice());
    }
}
