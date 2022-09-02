package com.godoro.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static com.godoro.xml.XmlUtilities.*;

public class XmlBuild {
	public static void main(String[] args) throws Exception {
		String path = "C:\\Users\\Sabri\\Desktop\\workspace\\Student.xml";
		Document document = parse(path);

		Element student = document.getDocumentElement();
		long id = getAttribute(student, "id", 0);
		System.out.println("id: " + id);

		String name = getSingleElementText(student, "name", "");
		System.out.println("name: " + name);
		double price = getSingleElementText(student, "mark", 0);
		System.out.println("price: " + price);
	}
}
