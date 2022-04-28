package token;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;

import com.chilkatsoft.CkGlobal;
import com.chilkatsoft.CkJsonObject;
import com.chilkatsoft.CkPkcs11;

import digital.sign.Signs;
import sun.security.pkcs11.SunPKCS11;

public class USBToken {

	private static boolean isActive = true;
	private static KeyStore keyStore = null;

	private static PrivateKey privateKey;
	private static Certificate[] certificates;

	private static String SHARED_LIB_PATH = "Safe-ca_v2.dll";

	static {
		try {
			System.loadLibrary("chilkat");
		} catch (UnsatisfiedLinkError e) {
			System.err.println("Native code library failed to load.\n" + e);
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		// unlock();
		signFile();
	}

	// Hàm chỉ chạy 1 lần
	static void initKeyStore(final String pin, int slot) {
		if (isActive) {
			isActive = false;
			Path path = Paths.get(SHARED_LIB_PATH);
			if (!path.toFile().exists()) {
				return;
			}
			String config = "name=XXX\nlibrary=YYY\nslot=ZZZ";
			try (InputStream is = new ByteArrayInputStream(config.getBytes(StandardCharsets.UTF_8))) {
				SunPKCS11 p1 = new SunPKCS11(is);
				Security.addProvider(p1);
				KeyStore ks = KeyStore.getInstance("PKCS11", p1);
				ks.load(null, pin.toCharArray());
				keyStore = ks;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void signFile() {
		try {
			String pin 					= "123456";
			String filetype 			= ".docx";
			String tokenNumber 			= "54071505112727";
			String tokenSerialNumber 	= "54010108001866B9E2CE8E16D9726E83";
			Path filein = Paths.get("filein");
			Path fileout = Paths.get("fileout");
			if (!filein.toFile().exists()) {
				System.out.println("File in doesn't exists!");
				return;
			}
			int slot = findSlotID(tokenNumber);
			if (slot == 0) {
				System.out.println("Slot is 0!");
				return;
			}
			initSignData(pin, tokenSerialNumber, slot);
			if (privateKey == null || certificates == null) {
				System.out.println("PrivateKey or Certificates is NULL!");
				return;
			}
			Signs ky = new Signs(privateKey, certificates);
			boolean success = ky.SignFile(filein.toString(), fileout.toString(), filetype, "", "", "", false);
			if (success) {
				System.out.println("Successfull");
				return;
			}
			System.out.println("Fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initSignData(String pin, String serialNumber, int slot) {
		initKeyStore(pin, slot);
		try {
			if (keyStore == null) {
				return;
			}
			for (String alias : Collections.list(keyStore.aliases())) {
				Certificate[] certs = keyStore.getCertificateChain(alias);
				if (certs == null) {
					continue;
				}
				for (Certificate cert : certs) {
					X509Certificate x509cert = (X509Certificate) cert;
					// 54010108001866B9E2CE8E16D9726E83
					String certSerialNumber = x509cert.getSerialNumber().toString(16);
					if (certSerialNumber.equalsIgnoreCase(serialNumber)) {
						certificates = certs;
						privateKey = (PrivateKey) keyStore.getKey(alias, pin.toCharArray());
						return;
					}
				}
			}
		} catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException e) {
			e.printStackTrace();
		}
	}

	public static CkJsonObject getCkJsonObject() {
		CkPkcs11 pkcs11 = new CkPkcs11();
		Path path = Paths.get(SHARED_LIB_PATH);
		if (!path.toFile().exists()) {
			System.out.println("File not found!");
			return null;
		}
		pkcs11.put_SharedLibPath(path.toFile().toString());
		boolean success = pkcs11.Initialize();
		if (!success) {
			System.out.println(pkcs11.lastErrorText());
			return null;
		}
		CkJsonObject json = new CkJsonObject();
		success = pkcs11.Discover(true, json);
		if (!success) {
			System.out.println(pkcs11.lastErrorText());
			return null;
		}
		json.put_EmitCompact(false);
		return json;
	}

	// https://www.example-code.com/java/pkcs11_discover.asp
	public static int findSlotID(String tokenSerialNumber) {
		CkJsonObject json = getCkJsonObject();
		int len = json.SizeOfArray("slot");
		for (int i = 1; i <= len; i++) {
			String serialNumber = json.stringOf("slot[i].token.serialNumber");
			if (tokenSerialNumber.equalsIgnoreCase(serialNumber)) {
				return i;
			}
		}
		return 0;
	}

	public static void unlock() {
		CkGlobal glob = new CkGlobal();
		boolean success = glob.UnlockBundle("Anything");
		if (!success) {
			System.out.println(glob.lastErrorText());
			return;
		}
		int status = glob.get_UnlockStatus();
		if (status == 2) {
			System.out.println("Unlocked using purchased unlock code.");
		} else {
			System.out.println("Unlocked in trial mode.");
		}
		// System.out.println(glob.lastErrorText());
	}

}
