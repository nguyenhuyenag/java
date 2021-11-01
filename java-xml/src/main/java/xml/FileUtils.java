package xml;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

class FileException extends RuntimeException {

	private static final long serialVersionUID = -791011360967376587L;

	public FileException(String message) {
		super(message);
	}

	public FileException(String message, Throwable cause) {
		super(message, cause);
	}
}

public class FileUtils {

	private final static String MQ_PATH = "C:/ftp/HDDT";

	public static Path validateFile(Path path) {
		if (PathUtils.isNotExist(path)) {
			throw new FileException("Path does't exists!");
		}
		return path;
	}

	// Ham tao thu muc
	private static boolean createDirectories(Path dir) {
		try {
			Files.createDirectories(dir);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean createFile(Path path) {
		if (path == null) {
			System.out.println("Path `" + path + "` does't exists!");
			return false;
		}
		Path parent = path.getParent();
		if (PathUtils.isNotExist(parent)) {
			createDirectories(parent);
		}
		try {
			return path.toFile().createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean writeByteArrayToFile(Path path, byte[] bytes, boolean append) {
		if (PathUtils.isNotExist(path)) {
			FileUtils.createFile(path);
		}
		try {
			if (!append) {
				Files.write(path, bytes);
			} else {
				Files.write(path, bytes, StandardOpenOption.APPEND);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean writeStringToFile(Path path, String content) {
		if (content == null) {
			throw new FileException("Content is NULL!");
		}
		return writeByteArrayToFile(path, content.getBytes(), false);
	}

	public static byte[] toByteArray(Path path) {
		validateFile(path);
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String readFile(Path path) {
		if (path != null) {
			byte[] bytes = toByteArray(path);
			if (bytes != null) {
				return new String(bytes, StandardCharsets.UTF_8);
			}
		}
		return "";
	}

//	// TODO
//	public static Path saveMQMessage(String message, String filename) {
//		if (StringUtils.isEmpty(message)) {
//			throw new FileException("Message is NULL or EMPTY!");
//		}
//		filename = filename.replaceAll("-", "");
//		Path pathFile = Paths.get(MQ_PATH, DateTimeUtils.getCurrentDateTimeByPattern("yyyy/MM/dd"), "mq/mq_" + filename + ".xml");
//		boolean flag = writeByteArrayToFile(pathFile, message.getBytes(), false);
//		if (flag) {
//			return pathFile;
//		}
//		return null;
//	}

}
