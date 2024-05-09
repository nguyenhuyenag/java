package basic;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardUtils {

	public static void copy(String text) {
		Toolkit.getDefaultToolkit() //
				.getSystemClipboard() //
				.setContents(new StringSelection(text), null);
	}

	public static void readClipboard() {
		try {
			String data = (String) Toolkit.getDefaultToolkit() //
					.getSystemClipboard() //
					.getData(DataFlavor.stringFlavor);
			System.out.println(data);
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String s = "I'm Java";
		copy(s);
		readClipboard();
	}

}
