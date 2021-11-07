package com.basic.xml;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlUtils {

	public static String getTextOfTag(String xml, String parent, String tagName) {
		if (StringUtils.isEmpty(xml)) {
			return "";
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xml));
			Document doc = builder.parse(is);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(parent);
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element el = (Element) nNode;
					Node tagNode = el.getElementsByTagName(tagName).item(0);
					if (tagNode != null) {
						return tagNode.getTextContent();
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getStructAndTextOfTag(String xml, String tagName) {
		if (StringUtils.isEmpty(xml) || StringUtils.isEmpty(tagName)) {
			return "";
		}
		return StringUtils.substringBetween(xml, "<" + tagName + ">", "</" + tagName + ">");
	}

}
