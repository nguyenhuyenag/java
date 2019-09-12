package xml;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.DataHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlUtils {
	
//	public static boolean saveFile(DataHandler content, String path, String fileName) {
//		try {
//			File f = new File(path);
//			if (!f.exists())
//				f.mkdir();
//
//			InputStream is = content.getInputStream();
//			OutputStream os = new FileOutputStream(new File(path + "/" + fileName));
//
//			// This will copy the file from the two streams
//			IOUtils.copy(is, os);
//
//			// This will close two streams catching exception
//			IOUtils.closeQuietly(os);
//			IOUtils.closeQuietly(is);
//
//			/*
//			 * int length = 0; int total = 0; InputStream in = content.getInputStream();
//			 * FileOutputStream op = new FileOutputStream(path + "/" + fileName); byte[]
//			 * bbuf = new byte[8192]; while ((in != null) && ((length = in.read(bbuf)) !=
//			 * -1)) { total = total + length; op.write(bbuf, 0, length); } op.flush();
//			 * op.close(); in.close();
//			 */
//
//			return true;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return false;
//		}
//	}

	public static boolean save(String content, String path, String fileName) {
		try {
			File f = new File(path);
			if (!f.exists()) {
				f.mkdir();
			}
			Files.write(Paths.get(path + "/" + fileName), content.getBytes(), StandardOpenOption.CREATE);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static String GetCurrentDate() {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			return dateFormat.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String GMTDateToVNDate(String s) throws Exception {
		if (s.equals(""))
			return "";
		return GMTDateToDate(s, "dd/MM/yyyy HH:mm");
	}

	public static String GMTDateToDate(String s) throws Exception {
		if (s.equals(""))
			return "";
		return GMTDateToDate(s, "yyyy-MM-dd HH:mm:ss");
	}

	public static String GMTDateToDate(String s, String format) throws Exception {
		if (s.equals(""))
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SimpleDateFormat output = new SimpleDateFormat(format);
		Date d = sdf.parse(s);
		return output.format(d);
	}

	public static String GMTDateToDate_GD(String s) throws Exception {
		if (s.equals(""))
			return "";
		return GMTDateToDate_GD(s, "yyyy-MM-dd");
	}

	public static String GMTDateToDate_GD(String s, String format) throws Exception {
		if (s.equals(""))
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat output = new SimpleDateFormat(format);
		Date d = sdf.parse(s);
		return output.format(d);
	}

	// public static String GetTextFromHandler(DataHandler sr, String path, String
	// fileName) {
	// try {
	// saveFile(sr, path, fileName);
	// return FileManager.readFileToString(path + "/" + fileName);
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// return null;
	// }
	// }

	public static String GetTextFromHandler(DataHandler sr) {
		try {
			// String path = Constants.TS24_TVAN_PATH_DSOAT + "/Temp";
			// String fileName = "123.xml";
			// String theString = GetTextFromHandler(sr, path, fileName);
			String xmlSrc = IOUtils.toString(sr.getInputStream(), "UTF-8");
			// String theString = IOUtils.readByteToString(IOUtils.toBytes(sr));
			// xmlSrc = CompactString(xmlSrc);
			return xmlSrc;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// public static String CompactString(String input) {
	// input = input.replaceAll(ConstantValue.REPLACE_ANY_LINE_TO_SINGLE_LINE, "");
	// input = input.replaceAll(" <", "<").replaceAll(" <", "<").replaceAll(" <",
	// "<").replaceAll(" <", "<")
	// .replaceAll(" <", "<");
	// input = input.replaceAll("> ", ">").replaceAll("> ", ">").replaceAll("> ",
	// ">").replaceAll("> ", ">")
	// .replaceAll("> ", ">");
	// input = input.replaceAll(" ", " ").replaceAll(" ", " ").replaceAll(" ", "
	// ").replaceAll(" ", " ");
	// return input;
	// }

	public static NodeList ReadXMLFile(String xmlFilePath) {
		try {
			// begin attach file
			File xmlFile = new File(xmlFilePath);

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			// take the form tag in template
			NodeList nodeList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());

			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static NodeList ReadXMLFileFromNode(String xmlFilePath, String NodeName) {
		try {
			// begin attach file
			File xmlFile = new File(xmlFilePath);

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			// take the form tag in template
			NodeList nodeList = doc.getElementsByTagName(NodeName);

			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static NodeList ReadXMLString(String xmlContent) {
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(new InputSource(new StringReader(xmlContent)));
			doc.getDocumentElement().normalize();
			// take the form tag in template
			NodeList nodeList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());

			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static NodeList asNoteList(String xml, String nodeName) {
		try {
			// begin attach file
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(new InputSource(new StringReader(xml)));
			doc.getDocumentElement().normalize();
			// take the form tag in template
			NodeList nodeList = doc.getElementsByTagName(nodeName);
			return nodeList.item(0).getChildNodes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getElement(Node node, String NameParent, String NameNode) {
		try {

			if (NameParent.equals("")) {
				Element eElement = (Element) node;
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					return eElement.getElementsByTagName(NameNode).item(0).getTextContent();
				}
			} else {
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element ojbElement = (Element) node;
					NodeList nodeList = ojbElement.getElementsByTagName(NameParent);
					for (int i = 0; i < nodeList.getLength(); i++) {
						Node nodeTree = nodeList.item(i);
						Element eElement = (Element) nodeTree;
						if (nodeTree.getNodeType() == Node.ELEMENT_NODE) {
							return eElement.getElementsByTagName(NameNode).item(0).getTextContent();
						}
					}
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getElementValue(Node node, String NameNode) {
		try {
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				NodeList nodeList = node.getChildNodes();
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node nodeTree = nodeList.item(i);
					if (nodeTree.getNodeType() == Node.ELEMENT_NODE) {
						if (nodeTree.getNodeName().equals(NameNode))
							return nodeTree.getTextContent();
					}
				}
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
