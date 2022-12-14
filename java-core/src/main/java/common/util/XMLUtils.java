package common.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

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
	public static String getTagValue2(String xml, String parent, String tagName) {
		if (StringUtils.isEmpty(xml)) {
			return "";
		}
		// xml = xml.trim().replaceFirst("^([\\W]+)<","<"); // "Content is not allowed
		// in prolog"
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
						return tagNode.getTextContent().trim();
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return "";
	}

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

	protected static String getString(String xml, String tagName)
			throws IOException, SAXException, ParserConfigurationException {
		try (InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))) {
			Document doc = DocumentBuilderFactory.newInstance() //
					.newDocumentBuilder() //
					.parse(new InputSource(is));
			Element element = doc.getDocumentElement();
			NodeList list = element.getElementsByTagName(tagName);
			if (list != null && list.getLength() > 0) {
				NodeList subList = list.item(0).getChildNodes();
				if (subList != null && subList.getLength() > 0) {
					return subList.item(0).getNodeValue().trim();
				}
			}
		}
		return null;
	}

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		Path path = Paths.get(PathUtils.HOME, "file/test.xml");
		String xml = FileUtils.readFile(path);
		// System.out.println(xml);
		// String s = getTagValue(xml, "Signature", "SignatureValue");
		System.out.println(getString(xml, "SignatureProperty"));
	}

}
