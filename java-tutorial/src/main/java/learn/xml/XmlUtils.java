package learn.xml;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlUtils {

	public static NodeList ReadXMLFile(String xmlFilePath) {
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

	public static NodeList ReadXMLFileFromNode(String xmlFilePath, String NodeName) {
		try {
			// begin attach file
			File xmlFile = new File(xmlFilePath);

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			// take the form tag in template
			NodeList nodeList = doc.getElementsByTagName(NodeName);

			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static NodeList ReadXMLString(String xmlContent) {
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
			Document document = builder.parse(new InputSource(new StringReader(xml)));
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName(nodeName);
			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getElement(Node node, String NameParent, String NameNode) {
		try {
			if (NameParent.equals("")) {
				Element eElement = (Element) node;
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					return eElement.getElementsByTagName(NameNode).item(0).getTextContent();
				}
			} else {
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element ojbElement = (Element) node;
					NodeList nodeList = ojbElement.getElementsByTagName(NameParent);
					for (int i = 0; i < nodeList.getLength(); i++) {
						Node nodeTree = nodeList.item(i);
						Element eElement = (Element) nodeTree;
						if (nodeTree.getNodeType() == Node.ELEMENT_NODE) {
							return eElement.getElementsByTagName(NameNode).item(0).getTextContent();
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
				return StringUtils.EMPTY;
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
		return StringUtils.EMPTY;
	}
}
