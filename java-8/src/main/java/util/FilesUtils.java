package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FilesUtils {

	/**
	 * DataHandler to byte array
	 * @param handler
	 * @return byte array
	 * @throws IOException
	 */
	public static byte[] toBytes(DataHandler handler) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		handler.writeTo(output);
		return output.toByteArray();
	}

	/**
	 * Get DataHandler by path
	 * @param path
	 * @return
	 */
	public static DataHandler getDataHandler(String path) {
		return new DataHandler(new FileDataSource(path));
	}

}
