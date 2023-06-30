package com.basic.awt;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class OpenBrowser {

	public static void main(String[] args) {
		try {
			String link = "https://nguyenhuyenag.wordpress.com/";
			URL url = new URL(link);
			System.out.println("PATH = " + url.getPath());
			System.out.println("HOST = " + url.getHost());
			System.out.println("PROTOCOL = " + url.getProtocol());
			System.out.println("PORT = " + url.getPort());
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI(link));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void openHomePage() {
        try {
            URI homepage = new URI("http://localhost:8080/");
            Desktop.getDesktop().browse(homepage);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
