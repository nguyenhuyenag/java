package digital;

import java.io.IOException;
import java.nio.file.Paths;

public class TestSignWord {

	public static void main(String[] args) throws IOException {
		String data = "C:/Users/nguye/Desktop/sign";
		Signs ky = new Signs(data + "/0309478306-999_TEST_SHA1.p12", "123456", "TS24.png");
		String filetype = ".docx";
		String filein = data + "/filetest" + filetype;
		String fileout = data + "/filetest_signed" + filetype;
		if (ky.SignFile(filein, fileout, filetype, "TS24_TEST", "TS24Corp", "TS24_TEST_1", false)) {
			if (Paths.get(fileout).toFile().exists()) {
				System.out.println("Ký file thành công");
			}
		}

	}

}
