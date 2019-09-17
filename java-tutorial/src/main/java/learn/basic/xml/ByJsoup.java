package learn.basic.xml;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import common.util.FilesUtils;

public class ByJsoup {

	public static void main(String[] args) {

		Path path = Paths.get("file/data.xml");
		String xml = FilesUtils.readFileToString(path);
		Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
		// System.out.println(doc.select("Body").html());
		// System.out.println(doc.select("Body").text());
		// System.out.println(doc.select("Envelope").outerHtml());
		// System.out.println(doc.select("Envelope").first());
		System.out.println(doc.select("mtaLoiGDich").text());

	}

}
