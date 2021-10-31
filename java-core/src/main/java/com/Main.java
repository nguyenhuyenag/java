package com;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import common.util.DateTimeUtils;

public class Main {
	
	private final static String MQ_PATH = "C:/ftp/HDDT";

	public static void main(String[] args) {
		//String data = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz48VERpZXA+PFRUQ2h1bmc+PFBCYW4+MS4wLjA8L1BCYW4+PE1OR3VpPlRDVDwvTU5HdWk+PE1OTmhhbj5WMDMwOTQ3ODMwNjwvTU5OaGFuPjxNTFREaWVwPjk5OTwvTUxURGllcD48TVREaWVwPlRDVF9NVERpZXBfMDAxPC9NVERpZXA+PE1URFRDaGlldT5UQ1ROX01URGllcF8wMDE8L01URFRDaGlldT48L1RUQ2h1bmc+PERMaWV1PjxUQmFvPjxNVERpZXA+OTk5PC9NVERpZXA+PE1OR3VpPlRDVDwvTU5HdWk+PE5OaGFuPjIwMjEtMTAtMzBUMTQ6MDA6MDA8L05OaGFuPjxUVFROaGFuPjE8L1RUVE5oYW4+PERTTERvPjxMRG8+PE1UYT5M4buXaSBr4bu5IHRodeG6rXQgcGjhuqNuIGjhu5NpIHThu6sgVENUPC9NVGE+PE1Mb2k+VENULTAwMTwvTUxvaT48L0xEbz48L0RTTERvPjwvVEJhbz48L0RMaWV1PjwvVERpZXA+";
		//System.out.println(Base64Utils.decodeToString(data));
		String filename = UUID.randomUUID().toString().replaceAll("-", ""); 
		Path pathFile = Paths.get(MQ_PATH, DateTimeUtils.getCurrentDateTimeByPattern("yyyy/MM/dd"), "mq/mq_" + filename + ".xml");
		System.out.println(pathFile.toString());
	}

}
