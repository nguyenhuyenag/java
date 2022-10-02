package com;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.basic.ClipboardUtils;

import common.util.Base64Utils;

public class Main {

	public static void validateXMLSchemaStringXML(String xsdPath, String xml) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			StreamSource source = new StreamSource(new StringReader(xml));
			validator.validate(source);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void test() {
		Path path = Paths.get("C:/Users/huyennv/Desktop/tax-conver/953_05_QTT_TNCN_TT80_251.xlsx");
		String base64 = Base64Utils.encodeToString(path);
		System.out.println(base64.trim());
		ClipboardUtils.copy(base64);
	}

	public static void main(String[] args) {
		// test();
		// 3 apple, 2 banana, others 1
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		Map<String, Long> finalMap = new LinkedHashMap<>();

		Map<String, Long> result = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		// Sort a map and add to finalMap
		result.entrySet().stream() //
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()) //
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		System.out.println(finalMap);
	}

}
