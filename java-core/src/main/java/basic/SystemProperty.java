package basic;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;
import java.util.function.Consumer;

import org.apache.commons.lang3.SystemUtils;

public class SystemProperty {

	static String[] keyArrays = { //
		"file.separator", // Dấu cách thư mục, windows => '\' hay Unix/Mac => '/'
		"java.class.path", //
		"java.home", // Đường dẫn của thư mục JRE
		"java.vendor", //
		"java.vendor.url", //
		"java.version", // Java version
		"os.arch", // x86, x64
		"os.name", // Tên hệ điều hành
		"os.version", // Phiên bản hệ điều hành
		"path.separator", //
		"user.dir", // Đường dẫn của dự án
		"user.home", //
		"user.name", // Tên người dùng
		"line.separator", //
		"user.timezone" //
	};

	// print all
	public void printAllProperties() {
		Properties properties = System.getProperties();
		Enumeration<Object> enumeration = properties.keys();
		for (int i = 0; i < properties.size(); i++) {
			Object obj = enumeration.nextElement();
			System.out.println("Key: " + obj + "\tOutPut= " + System.getProperty(obj.toString()));
		}
	}

	public static void todo() {
		Consumer<String> action = key -> System.out.println(key + " => " + System.getProperty(key));
		Arrays.asList(keyArrays).stream().forEach(action);
	}

	public static void by() {
		System.out.println(SystemUtils.getJavaHome());
		System.out.println(SystemUtils.getUserDir());
		System.out.println(SystemUtils.getJavaIoTmpDir());
		System.out.println(SystemUtils.USER_DIR);
		System.out.println(SystemUtils.USER_HOME);
	}

	public static void main(String[] args) {
		// todo();
		by();
	}

}
