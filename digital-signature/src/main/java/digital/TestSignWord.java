package digital;

import java.io.IOException;
import java.nio.file.Paths;

public class TestSignWord {

	public static void main(String[] args) throws IOException {
		String data = "C:/Users/huyennv/Desktop/sign";
		Signs ky = new Signs(data + "/0309478306-999_TEST_SHA1.p12", "123456", data + "/TS24.png");
		String filetype = ".xlsx";
		String filein = data + "/filetest" + filetype;
		String fileout = data + "/filetest_signed" + filetype;
		if (ky.SignFile(filein, fileout, filetype, "a", "b", "c", false)) {
			if (Paths.get(fileout).toFile().exists()) {
				System.out.println("Successfull");
				return;
			}
		}
		System.out.println("Error!");
	}

}
