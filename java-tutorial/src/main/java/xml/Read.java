package xml;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Read {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<soapenv:Envelope xmlns:t2bi=\"http://t2bi.traketqua.van.gdt.gov.vn/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "	<soapenv:Header/>\r\n" + "<soapenv:Body>\r\n"
				+ "		<t2bi:maGDich>11420191000603887</t2bi:maGDich>\r\n" + "	</soapenv:Body>\r\n"
				+ "</soapenv:Envelope>\r\n" + "";

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource src = new InputSource();
		src.setCharacterStream(new StringReader(xml));

		Document doc = builder.parse(src);
		String age = doc.getElementsByTagName("soapenv:Body").item(0).getTextContent();
		System.out.println("age: " + age);
		// String name = doc.getElementsByTagName("name").item(0).getTextContent();
		// System.out.println("name: " + name);

	}

}
