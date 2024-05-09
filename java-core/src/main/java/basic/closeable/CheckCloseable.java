package basic.closeable;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CheckCloseable {

	public static <T> boolean isAutoCloseable(T obj) {
		return (obj instanceof AutoCloseable);
	}

	public static void main(String[] args) {
		CloseableHttpClient client = HttpClients.createDefault();
		System.out.println(isAutoCloseable(client));
	}

}
