package xml;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.NodeList;

import common.util.FilesUtils;

public class ReadXml {

	public static void main(String[] args) {
		Path filename = Paths.get("file/data.xml");
		String xml = FilesUtils.readFile(filename).trim();

		// NodeList root = XmlUtils.asNoteList(xml, "TBaoThueDTu");
		// NodeList root = XmlUtils.asNoteList(xml, "TBaoThueDTu");
		NodeList NDungTBao = XmlUtils.asNoteList(xml, "NDungTBao");
		// NodeList GDich = XmlUtils.asNoteList(xml, "GDich");

		for (int i = 0; i < NDungTBao.getLength(); i++) {
			if ("GDich".equals(NDungTBao.item(i).getNodeName())) {
				String data = XmlUtils.getText(NDungTBao.item(i), "mtaLoiGDich");
				System.out.println(data);
			}
		}

	}

}
