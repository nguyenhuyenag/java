package xml;

import java.io.IOException;

import org.json.JSONObject;
import org.json.XML;

public class XmlToJSON {

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;

	public static void main(String[] args) throws IOException {

		//FileService fileService = new FileServiceUtils();
		
		String xml = "D:/Java/workspace/maven/java-tutorial/src/main/resources/file/data.xml";
		
		// FileService.readFileToString(xml)

		// System.out.println(xml.trim());

		JSONObject xmlJSONObj = XML.toJSONObject(xml);
		String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
		System.out.println(jsonPrettyPrintString);

	}

}
