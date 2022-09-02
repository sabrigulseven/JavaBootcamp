package com.godoro.xml;

import static com.godoro.xml.XmlUtilities.*;

import org.w3c.dom.*;

public class XmlCreate {
	public static void main(String[] args) throws Exception {
		Document document = create("student");
		Element student = document.getDocumentElement();
		student.setAttribute("id", "601");
		addSingleElementText(document, student, "name", "Yıldırım Gürses");
		addSingleElementText(document, student, "mark", 2.7);

		long id = getAttribute(student, "id", 0);
		String name = getSingleElementText(student, "name", "");
		double salary = getSingleElementText(student, "salary", 0);
		System.out.println(id + " " + name + " " + salary);

		String path = "C:\\Users\\Sabri\\Desktop\\workspace\\Generated.xml";
		dump(document, path);
	}
}
