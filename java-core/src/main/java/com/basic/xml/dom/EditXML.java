package com.basic.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class EditXML {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder buider = factory.newDocumentBuilder();

		File f = new File("./file/students.xml");
		Document doc = buider.parse(f);

		Element student = (Element) doc.getElementsByTagName("student").item(0);

		// Cập nhập thuộc tính n0
		NamedNodeMap attr = student.getAttributes();
		Node nodeAttr = attr.getNamedItem("id");
		nodeAttr.setTextContent("2");

		// Cập nhập thẻ name
		Element name = (Element) student.getElementsByTagName("name").item(0);
		name.setTextContent("Huyen");

		// Thêm thẻ email
		Element email = doc.createElement("email");
		email.appendChild(doc.createTextNode("huyennv@gmail.com"));
		student.appendChild(email);

		// Xóa thẻ age
		Element age = (Element) student.getElementsByTagName("age").item(0);
		student.removeChild(age);

		// Ghi xuống ổ đĩa
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(f);
		transformer.transform(source, result);
	}

}
