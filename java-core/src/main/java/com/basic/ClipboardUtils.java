package com.basic;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class ClipboardUtils {

	public static void copy(String text) {
		Toolkit.getDefaultToolkit() //
				.getSystemClipboard() //
				.setContents(new StringSelection(text), null);
	}

}
