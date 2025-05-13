package xml.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadXml {

	public static void main(String[] args) {
		Path filename = Paths.get("file/2023_CTT56_TA_0000_E_00000729_0304628540.xml");
		String xml = FileUtils.readFile(filename);
		System.out.println(XmlUtils.isXMLValid(xml));
//		NodeList node = XmlUtilsOld.asNoteList(xml, "TTKhac");
//		// NodeList GDich = XmlUtils.asNoteList(xml, "GDich");
//		for (int i = 0; i < node.getLength(); i++) {
////			if ("GDich".equals(node.item(i).getNodeName())) {
////				String data = XmlUtils.getText(node.item(i), "mtaLoiGDich");
////				System.out.println(data);
////			}
//			System.out.println(node.item(i).getNodeName());
//		}

	}

}
