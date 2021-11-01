package xml.jsoup;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import xml.FileUtils;

public class DOMMethods {

	public static void main(String[] args) {
		Path path = Paths.get("file/data.xml");
		String xml = FileUtils.readFile(path);
		Document doc = Jsoup.parse(xml);
		
		Element eId = doc.getElementById("3");
		
		// Thẻ và nội dung
		//System.out.println(eId.html());
		
		// Tất cả nội dung
		//System.out.println(eId.text());
		
		// Elements authors = eId.getElementsByTag("author");
		// for (Element el : authors) {
		// 	System.out.println(el.text());
		// }
		
		// Phần tử kế tiếp
		System.out.println(eId.nextElementSibling().html());
		
	}

}
