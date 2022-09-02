package com.godoro.xml;

import org.w3c.dom.*;
import static com.godoro.xml.XmlUtilities.*;

public class XmlBuildList {
	public static void main(String[] args) throws Exception {
		String path = "C:\\Users\\Sabri\\Desktop\\workspace\\Exam.xml";
		Document document = parse(path);

		Element exam = document.getDocumentElement();
		String id = getAttribute(exam, "id", "0");
		System.out.println("id" + id);

		NodeList questions = exam.getElementsByTagName("question");
		for (int i = 0; i < questions.getLength(); i++) {
			Element question = (Element) questions.item(i);
			String text = getSingleElementText(question, "text", "");
			String number = getAttribute(question, "number", "");
			System.out.println( number+". " + text);

			NodeList options = question.getElementsByTagName("option");
			for (int j = 0; j < options.getLength(); j++) {
				Element option = (Element) options.item(j);
				String code = getAttribute(option, "code", "");
				String content = option.getTextContent();
				System.out.println("\t"+code + ") " + content);
			}
		}
	}
}
