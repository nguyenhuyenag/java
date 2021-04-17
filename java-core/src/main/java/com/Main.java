package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import common.util.FilesUtils;

public class Main {

//	public static void main(String[] args) {
//		Path path = Paths.get("C:\\Users\\huyennv\\Desktop\\text.txt");
//		System.out.println(StringUtils.capitalize("abc"));
//		FilesUtils.readAllLines(path).forEach(t -> {
//			System.out.println("if (LDAPAttribute.hasAttribute(entry, FieldThongTinCongTy." + t.toUpperCase() + ")) {");
//			System.out.println("\tcongty.set"+StringUtils.capitalize(t)+"(LDAPAttribute.getAttributeValue(entry, FieldThongTinCongTy."+t.toUpperCase()+"));");
//			System.out.println("}");
//		});
//	}

	public static void main(String[] args) {
		// String from = "C:\\Users\\nguye\\Desktop\\pepe";
		Path path = Paths.get("D:\\GDrive\\ToCompany\\latex\\cv-latex");
		
		FilesUtils.listFile(path).forEach(t->System.out.println(t));
		
		// System.out.println("OK");
	}

}
