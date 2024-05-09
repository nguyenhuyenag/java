package basic.io.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class Buffered {

	public void method() {
		try (BufferedReader reader = new BufferedReader(new FileReader("pom.xml"));) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// skip(long n) -> Bỏ qua n ký tự
	public static void givenBufferedReader_whensSkipChars_thenOk() throws IOException {
		StringBuilder result = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new StringReader("1__2__3__4__5"))) {
			int value;
			while ((value = reader.read()) != -1) {
				result.append((char) value);
				reader.skip(2L);
			}
		}
		System.out.println(result);
	}

	public static void givenBufferedReader_whenSkipsWhitespacesAtBeginning_thenOk() throws IOException {
		String result;
		try (BufferedReader reader = new BufferedReader(new StringReader("    Lorem ipsum dolor sit amet"))) {
			while (Character.isWhitespace(reader.read())) {
				reader.mark(0);
			}
			reader.reset();
			result = reader.readLine();
		}
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		// givenBufferedReader_whensSkipChars_thenOk();
		givenBufferedReader_whenSkipsWhitespacesAtBeginning_thenOk();
	}

}
