package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import common.util.FileUtils;
import common.util.XMLUtils;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\huyennv\\Desktop\\test.xml");
		String xml = FileUtils.readFile(path);
		// xml = xml.trim().replaceFirst("^([\\W]+)<","<");
		System.out.println(XMLUtils.getTagValue(xml, "SignatureProperty", "SigningTime"));
	}

}
