package common.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLUtils {

	/**
	 * Đọc dữ liệu của 1 tag: <name>Java</name> => Java
	 */
	public static String getTagValue(String xml, String parent, String tagName) {
		if (StringUtils.isEmpty(xml)) {
			return "";
		}
		try (StringReader sr = new StringReader(xml)) {
			Document doc = DocumentBuilderFactory.newInstance() //
					.newDocumentBuilder() //
					.parse(new InputSource(sr));
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(parent);
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element el = (Element) node;
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
		String start = "<" + tagName + ">";
		String end = "</" + tagName + ">";
		String between = StringUtils.substringBetween(xml, start, end);
		if (StringUtils.isEmpty(between)) {
			return "";
		}
		return start + between + end;
	}

	public static boolean isXMLValid(String xml) {
		try (StringReader sr = new StringReader(xml)) {
			SAXParserFactory.newInstance() //
					.newSAXParser() //
					.getXMLReader() //
					.parse(new InputSource(sr));
			return true;
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		
	}

}
