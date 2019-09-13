package xml;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.NodeList;

import common.util.FilesUtils;

public class Read {

	public static void main(String[] args) {

		Path filename = Paths.get("file/data.xml");
		String xml = FilesUtils.readFileToString(filename).trim();
		// System.out.println(xml);

		// NodeList root = XmlUtils.asNoteList(xml, "TBaoThueDTu");
		NodeList nodeTBaoThue = XmlUtils.asNoteList(xml, "TBaoThue");
		// NodeList nodeNDungTBao = XmlUtils.ReadXMLStringFromNode(xml, "NDungTBao");
		// NodeList nodeGDich = XmlUtils.ReadXMLStringFromNode(xml, "GDich");
		//
		// for (int i = 0; i < nodeNDungTBao.getLength(); i++) {
		// if (nodeNDungTBao.item(i).getNodeName().equals("GDich")) {
		// System.out.println(XmlUtils.getElementValue(nodeNDungTBao.item(i),
		// "mtaLoiGDich"));
		// }
		// }

		for (int i = 0; i < nodeTBaoThue.getLength(); i++) {
			System.out.println(nodeTBaoThue.item(i).getNodeName());
		}

	}

}
