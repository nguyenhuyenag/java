package xml.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLUtils {

//	public static String getTagValue2(String xml, String parent, String tagName) {
//		if (StringUtils.isEmpty(xml)) {
//			return "";
//		}
//		// xml = xml.trim().replaceFirst("^([\\W]+)<","<"); // "Content is not allowed
//		// in prolog"
//		try (StringReader sr = new StringReader(xml)) {
//			Document doc = DocumentBuilderFactory.newInstance() //
//					.newDocumentBuilder() //
//					.parse(new InputSource(sr));
//			doc.getDocumentElement().normalize();
//			NodeList nList = doc.getElementsByTagName(parent);
//			for (int i = 0; i < nList.getLength(); i++) {
//				Node node = nList.item(i);
//				if (node.getNodeType() == Node.ELEMENT_NODE) {
//					Element el = (Element) node;
//					Node tagNode = el.getElementsByTagName(tagName).item(0);
//					if (tagNode != null) {
//						return tagNode.getTextContent().trim();
//					}
//				}
//			}
//		} catch (ParserConfigurationException | SAXException | IOException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}

	/**
	 * Đọc dữ liệu của 1 tag: <name>Java</name> => Java
	 */
	public static String getTagValue(String xml, String parent, String tagName) {
		if (StringUtils.isEmpty(xml)) {
			return "";
		}
		try (InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))) {
			Document doc = DocumentBuilderFactory.newInstance() //
					.newDocumentBuilder() //
					.parse(new InputSource(is));
			NodeList nList = doc.getElementsByTagName(parent);
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element el = (Element) node;
					Node tagNode = el.getElementsByTagName(tagName).item(0);
					if (tagNode != null) {
						return tagNode.getTextContent().trim();
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean isXMLValid(String xml) {
		xml = xml.trim().replaceFirst("^([\\W]+)<","<");
		try (StringReader reader = new StringReader(xml)) {
			SAXParserFactory.newInstance() //
					.newSAXParser() //
					.getXMLReader() //
					.parse(new InputSource(reader));
			return true;
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

//	protected static String getTagValue(String xml, String tagName) {
//		try (InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))) {
//			Document doc = DocumentBuilderFactory.newInstance() //
//					.newDocumentBuilder() //
//					.parse(new InputSource(is));
//			Element element = doc.getDocumentElement();
//			NodeList nList = element.getElementsByTagName(tagName);
//			if (nList != null && nList.getLength() > 0) {
//				NodeList subList = nList.item(0).getChildNodes();
//				if (subList != null && subList.getLength() > 0) {
//					return subList.item(0).getNodeValue().trim();
//				}
//			}
//		} catch (SAXException | IOException | ParserConfigurationException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}

//	public static void getTagValue3() throws XPathExpressionException {
//		Path path = Paths.get(PathUtils.HOME, "file/test.xml");
//		String xml = FileUtils.readFile(path);
//		try (InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))) {
//			Document doc = DocumentBuilderFactory.newInstance() //
//					.newDocumentBuilder() //
//					.parse(new InputSource(is));
//			XPath xPath = XPathFactory.newInstance().newXPath();
//			NodeList nodes = (NodeList) xPath.evaluate("//NoiDung/LaoDong/STT", doc, XPathConstants.NODESET);
//			for (int i = 0; i < nodes.getLength(); i++) {
//				Node node = nodes.item(i);
//				System.out.println(node.getTextContent().trim());
//			}
//		} catch (SAXException | IOException | ParserConfigurationException e) {
//			e.printStackTrace();
//		}
//	}

	public static String getStructAndTextOfTag(String xml, String tagName) {
		if (StringUtils.isEmpty(xml) || StringUtils.isEmpty(tagName)) {
			return "";
		}
		String start = "<" + tagName; // + ">";
		String end = "</" + tagName + ">";
		String between = StringUtils.substringBetween(xml, start, end);
		if (StringUtils.isEmpty(between)) {
			return "";
		}
		return start + between + end;
	}

	public static void extractValue() {
		String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<int xmlns=\"http://tempuri.org/\">1279872209</int>";
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			try (ByteArrayInputStream input = new ByteArrayInputStream(xmlString.getBytes())) {
				Document doc = builder.parse(input);
				// Get the int element
				NodeList intNodes = doc.getElementsByTagName("int");
				Element intElement = (Element) intNodes.item(0);
				// Get the value of the int element
				String intValue = intElement.getTextContent();
				System.out.println("Value of int tag: " + intValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws XPathExpressionException {
		// Path path = Paths.get(PathUtils.HOME, "file/test.xml");
		// String xml = FileUtils.readFile(path);
		// System.out.println(xml);
		// String s = getStructAndTextOfTag(xml, "SignatureProperties");
		// System.out.println(s);
		extractValue();
	}

}