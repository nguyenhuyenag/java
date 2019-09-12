package basic;

import java.net.MalformedURLException;
import java.net.URL;

public class Url {

	public static void main(String[] args) throws MalformedURLException {

		URL url = new URL("https://www.facebook.com/bathudaide");
		System.out.println("PATH = " + url.getPath());
		System.out.println("HOST = " + url.getHost());
		System.out.println("PROTOCOL = " + url.getProtocol());
		System.out.println("PORT = " + url.getPort());

	}

}
