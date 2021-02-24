package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.util.PathUtils;

public class Main {

	public static String getCell(XSSFRow row, int i) {
		try {
			XSSFCell cell = row.getCell(i);
			return cell != null ? cell.getStringCellValue() : "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static final String FILE_NAME = Paths.get(PathUtils.HOME, "file/vocabulary.xlsx").toString();

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = null;
		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			workbook = new XSSFWorkbook(excelFile);
			XSSFSheet worksheet = workbook.getSheet("Q");
			System.out.println(worksheet.getLastRowNum());
			// XSSFSheet worksheet = workbook.getSheetAt(16);
			for (int i = 0; i <= worksheet.getLastRowNum(); i++) {
				XSSFRow row = worksheet.getRow(i);
				if (row == null) {
					System.out.println();
				} else {
					System.out.println(getCell(row, 0) + ", " + getCell(row, 1) + ", " + getCell(row, 2));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}

	}

}
