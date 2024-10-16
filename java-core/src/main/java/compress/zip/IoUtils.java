package compress.zip;

import java.io.Closeable;
import java.io.IOException;

public class IoUtils {

	private IoUtils() {
	}

	public static void closeAll(Closeable... cls) {
		for (Closeable c : cls) {
			if (c != null)
				try {
					c.close();
				} catch (IOException ex) {
					ex.printStackTrace();
					// Logger.getLogger(IoUtils.class.getName()).log(Level.SEVERE, null, ex);
				}
		}
	}

}
