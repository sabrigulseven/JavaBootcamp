package com.pcshop.xml;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcshop.database.entity.Category;
import static com.pcshop.core.utils.XmlHelper.*;

public class CategoryXml {
    public static Document format(List<Category> categorylist) throws ParserConfigurationException {
        Document document = create("categories");
        Element rootelement = document.getDocumentElement();
        for (Category category : categorylist) {

            Element element = document.createElement("category");
            element.setAttribute("categoryid", Long.toString(category.getCategoryId()));
            addSingleElementText(document, element, "categoryName", category.getCategoryName());
            rootelement.appendChild(element);
        }
        return document;

    }

    public static Category format(Element element) {
        long categoryid = getAttribute(element, "categoryid", 0);
        String categoryName = getSingleElementText(element, "categoryName", "");
        Category category = new Category(categoryid, categoryName);
        
        return category;
    }
}
