package com.basic.file;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;

public class DetectMimeType {

	public static void main(String[] args) throws IOException {
		String path = PathUtils.PROJECT_DIR + "/file/data.json";
		File file = new File(path);
		Tika tika = new Tika();
		System.out.println(tika.detect(file));
		System.out.println(tika.detect(file));
//		try (InputStream is = new BufferedInputStream(new FileInputStream(file));) {
//			String mimeType = URLConnection.guessContentTypeFromStream(is);
//			System.out.println(mimeType);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
