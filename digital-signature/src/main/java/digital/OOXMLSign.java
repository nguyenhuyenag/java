package digital;

import java.io.File;
import java.net.URL;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;

import javax.crypto.Cipher;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ooxml.signature.service.spi.DigestInfo;

import be.fedict.eid.applet.service.signer.ooxml.OOXMLProvider;
import digital.impl.OOXMLSignatureServiceImpl;

public class OOXMLSign {

	// private static final Logger LOG =
	// LoggerFactory.getLogger(AbstractOOXMLSignService.class);
	
	public static final byte[] SHA1_DIGEST_INFO_PREFIX = new byte[] { 0x30, 0x1f, 0x30, 0x07, 0x06, 0x05, 0x2b, 0x0e,
			0x03, 0x02, 0x1a, 0x04, 0x14 };

	public static final byte[] SHA2_DIGEST_INFO_PREFIX = new byte[] { 0x30, 0x31, 0x30, 0x0d, 0x06, 0x09, 0x60,
			(byte) 0x86, 0x48, 0x01, 0x65, 0x03, 0x04, 0x02, 0x01, 0x05, 0x00, 0x04, 0x20 };

	public OOXMLSign() {
		OOXMLProvider.install();
	}

	public File sign(String documentResourceName, String fileSigned, PrivateKey priKey, Certificate chain)
			throws Exception {
		File excelFile = new File(documentResourceName);
		URL ooxmlUrl = excelFile.toURI().toURL();
		return sign(ooxmlUrl, fileSigned, priKey, chain);

	}

	public File signSHA2(String documentResourceName, String fileSigned, PrivateKey priKey, Certificate chain)
			throws Exception {
		File excelFile = new File(documentResourceName);
		URL ooxmlUrl = excelFile.toURI().toURL();
		return signSHA2(ooxmlUrl, fileSigned, priKey, chain);
	}

	private File sign(URL ooxmlUrl, String fileSigned, PrivateKey priKey, Certificate chain) throws Exception {
		OOXMLSignatureServiceImpl signatureService = new OOXMLSignatureServiceImpl(ooxmlUrl);
		DigestInfo digestInfo = signatureService.preSign(null, null);
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, priKey);

		byte[] digestInfoValue = ArrayUtils.addAll(SHA1_DIGEST_INFO_PREFIX, digestInfo.digestValue);
		byte[] signatureValue = cipher.doFinal(digestInfoValue);

		signatureService.postSign(signatureValue, Collections.singletonList((X509Certificate) chain));

		// verify: signature
		byte[] signedOOXMLData = signatureService.getSignedOfficeOpenXMLDocumentData();
		File tmpFile = new File(fileSigned);
		if (tmpFile.exists()) {
			tmpFile.delete();
		}
		FileUtils.writeByteArrayToFile(tmpFile, signedOOXMLData);
		return tmpFile;

	}

	private File signSHA2(URL ooxmlUrl, String fileSigned, PrivateKey priKey, Certificate chain) throws Exception {
		OOXMLSignatureServiceImpl signatureService = new OOXMLSignatureServiceImpl(ooxmlUrl);
		DigestInfo digestInfo = signatureService.preSignSHA2(null, null);
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, priKey);

		byte[] digestInfoValue = ArrayUtils.addAll(SHA2_DIGEST_INFO_PREFIX, digestInfo.digestValue);
		byte[] signatureValue = cipher.doFinal(digestInfoValue);

		signatureService.postSign(signatureValue, Collections.singletonList((X509Certificate) chain));

		// verify: signature
		byte[] signedOOXMLData = signatureService.getSignedOfficeOpenXMLDocumentData();
		File tmpFile = new File(fileSigned);
		if (tmpFile.exists()) {
			tmpFile.delete();
		}
		FileUtils.writeByteArrayToFile(tmpFile, signedOOXMLData);
		return tmpFile;
	}

}
