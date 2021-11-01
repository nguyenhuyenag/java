package xml;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.NodeList;

public class ReadXml {

	public static void main(String[] args) {
		Path filename = Paths.get("file/data.xml");
		String xml = FileUtils.readFile(filename).trim();

		NodeList node = XmlUtils.asNoteList(xml, "bookstore");
		// NodeList GDich = XmlUtils.asNoteList(xml, "GDich");

		for (int i = 0; i < node.getLength(); i++) {
//			if ("GDich".equals(node.item(i).getNodeName())) {
//				String data = XmlUtils.getText(node.item(i), "mtaLoiGDich");
//				System.out.println(data);
//			}
			System.out.println(node.item(i).getNodeName());
		}

	}

}
