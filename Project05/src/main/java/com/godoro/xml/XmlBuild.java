package com.godoro.xml;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static com.godoro.xml.XmlUtilities.*;
public class XmlBuild {
	
	 
	public static void main(String[] args) throws Exception{
		String path ="C:\\Users\\Sabri\\Desktop\\workspace\\Product.xml";
		Document document = parse(path);
		
		Element product = document.getDocumentElement();
		long id = getAttribute(product,"id",0);
		System.out.println("id: " + id);
		
		String name = getSingleElementText(product, "name", "");
		System.out.println("name: " +name);
		double price = getSingleElementText(product, "price", 0);
		System.out.println("price: " +price);
		
		//XML JAXP DOM
	}
}
