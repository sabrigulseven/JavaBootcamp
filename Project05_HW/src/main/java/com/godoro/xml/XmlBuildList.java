package com.godoro.xml;

import org.w3c.dom.*;
import static com.godoro.xml.XmlUtilities.*;

public class XmlBuildList {
	public static void main(String[] args) throws Exception {
		String path = "C:\\Users\\Sabri\\Desktop\\workspace\\Students.xml";
		Document document = parse(path);
		NodeList students = document.getElementsByTagName("student");
		System.out.println("Students:");
		for (int i = 0; i < students.getLength(); i++) {
			Element student = (Element) students.item(i);
			long id = getAttribute(student, "id", 0);
			String name = getSingleElementText(student, "name", "");
			double mark = getSingleElementText(student, "mark", 0);

			System.out.println("\t" + id + ". " + name + ". " + mark);
		}
	}
}
