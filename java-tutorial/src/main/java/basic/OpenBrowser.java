package basic;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenBrowser {

	public static void main(String[] args) {
		try {
			String url = "https://nguyenhuyenag.wordpress.com/";
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI(url));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
