/*
	* @project: digitalOffice
	*@author:   nganv
*Jun 21, 2010 1:55:04 PM
*/
package digital.impl;

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

public class OOXMLSignUtils {

	// private static final Logger LOG =
	// LoggerFactory.getLogger(AbstractOOXMLSignService.class);

	public OOXMLSignUtils() {
		OOXMLProvider.install();
	}

	/*
	 * @Test public void testSignSpreadsheet() throws Exception {
	 * sign("/hello-world-unsigned.xlsx"); }
	 */

	public File sign(String documentResourceName, String fileSigned, PrivateKey priKey, Certificate chain)
			throws Exception {
		/*
		 * URL ooxmlUrl = AbstractOOXMLSignService.class
		 * .getResource(documentResourceName);
		 */
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
		// GetCertify mycert = new GetCertify();
		File tmpFile;
		DigestInfo digestInfo = signatureService.preSign(null, null);
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, priKey);

		byte[] digestInfoValue = ArrayUtils.addAll(PkiSha1Utils.SHA1_DIGEST_INFO_PREFIX, digestInfo.digestValue);
		byte[] signatureValue = cipher.doFinal(digestInfoValue);

		signatureService.postSign(signatureValue, Collections.singletonList((X509Certificate) chain));

		// verify: signature
		byte[] signedOOXMLData = signatureService.getSignedOfficeOpenXMLDocumentData();
		// tmpFile =new File(fileSigned+"/"+FilenameUtils.getName(ooxmlUrl.getFile()));
		tmpFile = new File(fileSigned);
		if (tmpFile.exists()) {
			tmpFile.delete();
		}
		FileUtils.writeByteArrayToFile(tmpFile, signedOOXMLData);
		return tmpFile;

	}

	private File signSHA2(URL ooxmlUrl, String fileSigned, PrivateKey priKey, Certificate chain) throws Exception {
		OOXMLSignatureServiceImpl signatureService = new OOXMLSignatureServiceImpl(ooxmlUrl);
		// GetCertify mycert = new GetCertify();
		DigestInfo digestInfo = signatureService.preSignSHA2(null, null);
		File tmpFile;
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, priKey);

		byte[] digestInfoValue = ArrayUtils.addAll(PkiSha2Utils.SHA2_DIGEST_INFO_PREFIX, digestInfo.digestValue);
		byte[] signatureValue = cipher.doFinal(digestInfoValue);

		signatureService.postSign(signatureValue, Collections.singletonList((X509Certificate) chain));

		// verify: signature
		byte[] signedOOXMLData = signatureService.getSignedOfficeOpenXMLDocumentData();
		// tmpFile =new File(fileSigned+"/"+FilenameUtils.getName(ooxmlUrl.getFile()));
		tmpFile = new File(fileSigned);
		if (tmpFile.exists()) {
			tmpFile.delete();
		}
		FileUtils.writeByteArrayToFile(tmpFile, signedOOXMLData);
		return tmpFile;

	}

}
