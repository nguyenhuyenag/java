package learn.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public class ByJsoup {

	public static void main(String[] args) {

		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Envelope xmlns:t2bi=\"http://t2bi.traketqua.van.gdt.gov.vn/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "	<Body>\r\n" + "		<maGDich>11420191000603887</maGDich>\r\n" + "	</Body>\r\n" + "</Envelope>\r\n"
				+ "";
		Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
		// System.out.println(doc.select("Body").html());
		// System.out.println(doc.select("Body").text());
		// System.out.println(doc.select("Envelope").outerHtml());
		System.out.println(doc.select("Envelope").first());

	}

}
