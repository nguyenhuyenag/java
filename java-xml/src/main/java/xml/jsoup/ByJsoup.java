package xml.jsoup;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import xml.FileUtils;

public class ByJsoup {

	public static void main(String[] args) {
		Path path = Paths.get("file/data.xml");
		String xml = FileUtils.readFile(path);
		// Document doc = Jsoup.parse(xml);
		Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
		// Lấy ra tất cả các nội dung, thẻ
		System.out.println(doc.select("book[category='web']").html());
		// System.out.println(doc.select("Body").text());
		// System.out.println(doc.select("Envelope").outerHtml());
		// System.out.println(doc.select("Envelope").first());
		// String el = doc.select("book").attr("cooking");
		// System.out.println(el);
	}

}
