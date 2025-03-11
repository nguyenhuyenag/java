package xml.util;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlUtilsOld {

	public static NodeList readXMLFile(String xmlFilePath) {
		try {
			// begin attach file
			File xmlFile = new File(xmlFilePath);

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			// take the form tag in template
			NodeList nodeList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());

			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static NodeList readXMLFileFromNode(String xmlFilePath, String nodeName) {
		try {
			// begin attach file
			File xmlFile = new File(xmlFilePath);

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			// take the form tag in template
			NodeList nodeList = doc.getElementsByTagName(nodeName);

			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static NodeList readXMLString(String xmlContent) {
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(new InputSource(new StringReader(xmlContent)));
			doc.getDocumentElement().normalize();
			// take the form tag in template
			NodeList nodeList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static NodeList asNoteList(String xml, String nodeName) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(xml))); // close stream
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName(nodeName);
			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getElement(Node node, String nameParent, String nameNode) {
		try {
			if (nameParent.equals("")) {
				Element eElement = (Element) node;
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					return eElement.getElementsByTagName(nameNode).item(0).getTextContent();
				}
			} else {
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element ojbElement = (Element) node;
					NodeList nodeList = ojbElement.getElementsByTagName(nameParent);
					for (int i = 0; i < nodeList.getLength(); i++) {
						Node nodeTree = nodeList.item(i);
						Element eElement = (Element) nodeTree;
						if (nodeTree.getNodeType() == Node.ELEMENT_NODE) {
							return eElement.getElementsByTagName(nameNode).item(0).getTextContent();
						}
					}
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getText(Node node, String nodeName) {
		try {
			if (node.getNodeType() != Node.ELEMENT_NODE) {
				return "";
			}
			NodeList nodeList = node.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nodeTree = nodeList.item(i);
				if (nodeTree.getNodeType() == Node.ELEMENT_NODE) {
					if (nodeName.equals(nodeTree.getNodeName())) {
						return nodeTree.getTextContent();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
