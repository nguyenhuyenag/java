package digital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfSignatureAppearance;
import com.lowagie.text.pdf.PdfStamper;

public class Signs {

	final Logger LOG = LoggerFactory.getLogger(Signs.class);

	private static PrivateKey PRIVATEKEY;
	private static Certificate[] CHAIN;
	private static String PATH_SIGN_IMAGE;

	private static int POSITION_X, POSITION_Y, POSITION_U, POSITION_Z;

	public Signs() {

	}

	public Signs(PrivateKey privateKey, Certificate[] certs) {
		Signs.PRIVATEKEY = privateKey;
		Signs.CHAIN = certs;
	}

	public Signs(String pathSign, String passSign, String pathImage) {
		try {
			KeyStore ks = KeyStore.getInstance("pkcs12");
			ks.load(new FileInputStream(pathSign), passSign.toCharArray());
			String alias = (String) ks.aliases().nextElement();
			PrivateKey key = (PrivateKey) ks.getKey(alias, passSign.toCharArray());
			Certificate[] chain = ks.getCertificateChain(alias);
			if (StringUtils.isNotEmpty(pathImage)) {
				PATH_SIGN_IMAGE = pathImage;
			}
			PRIVATEKEY = key;
			CHAIN = chain;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	private static String getStackTrace(Exception t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		t.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}

	public boolean SignFile(String filein, String fileout, String fileType, String reason, String location,
			String visible, boolean isDelete) {
		// boolean sTrue = false;
		File fileSource = new File(filein);

		POSITION_X = 245; // fix width
		POSITION_Y = 90; // fix height
		POSITION_U = 370;
		POSITION_Z = 25;
		if (StringUtils.isEmpty(fileType)) {
			LOG.info("Filetype is null or emplty!");
			return false;
		}
		if (fileSource.exists()) {
			PrivateKey key = PRIVATEKEY;
			Certificate[] chain = CHAIN;
			try {
				if (fileType.equals(".xlsx") || fileType.equals(".docx")) {
					OOXMLSign xmlSign = new OOXMLSign();
					File file = xmlSign.sign(filein, fileout, key, chain[0]);
					if (file == null || !file.exists()) {
						return false;
					}
				}
				if (fileType.equals(".pdf")) {
					PdfReader reader = new PdfReader(filein);
					FileOutputStream fout = new FileOutputStream(fileout);
					PdfStamper stp = PdfStamper.createSignature(reader, fout, '\0', null, true);
					PdfSignatureAppearance sap = stp.getSignatureAppearance();
					sap.setCrypto(key, chain, null, PdfSignatureAppearance.WINCER_SIGNED);
					sap.setReason(reason);
					sap.setLocation(location);
					sap.setSignDate(Calendar.getInstance());
					if (StringUtils.isNotEmpty(PATH_SIGN_IMAGE)) {
						sap.setImage(Image.getInstance(PATH_SIGN_IMAGE));
					}
					// comment next line to have an invisible signature
					int n = stp.getReader().getNumberOfPages();
					sap.setVisibleSignature(new Rectangle(POSITION_X, POSITION_Y, POSITION_U, POSITION_Z), n, visible);
					stp.close();
					fout.close();
					reader.close();
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (isDelete) {
				LOG.info("Delete " + filein);
				fileSource.delete();
			}
		}
		LOG.info("File " + filein + " source not exists!");
		return false;
	}

	@SuppressWarnings("null")
	public boolean SignFileSHA2(String UrlSource, String UrlDes, String sFileType, String sReason_Sign,
			String sLocation_Sign, String sVisibleSignature, boolean DeleteFileSource) {
		boolean sTrue = false;
		File fileSource = new File(UrlSource);

		POSITION_X = 245; // fix width
		POSITION_Y = 90; // fix height
		POSITION_U = 370;
		POSITION_Z = 25;

		if (fileSource.exists()) {
			try {
				PrivateKey key = PRIVATEKEY;
				Certificate[] chain = CHAIN;

				if (sFileType != null && sFileType.equals(".pdf")) {
					PdfReader reader = null;
					PdfStamper stp = null;
					FileOutputStream fout = null;

					try {
						try {
							reader = new PdfReader(UrlSource);
						} catch (IOException ie) {
							reader.close();
							System.out.println("------ Error: " + getStackTrace(ie));
							return false;
						}
						fout = new FileOutputStream(UrlDes);
						stp = PdfStamper.createSignature(reader, fout, '\0', null, true);
						PdfSignatureAppearance sap = stp.getSignatureAppearance();
						sap.setCrypto(key, chain, null, PdfSignatureAppearance.WINCER_SIGNED);
						sap.setReason(sReason_Sign);
						sap.setLocation(sLocation_Sign);
						sap.setSignDate(Calendar.getInstance());
						if (StringUtils.isNotEmpty(PATH_SIGN_IMAGE)) {
							sap.setImage(Image.getInstance(PATH_SIGN_IMAGE));
						}
						// comment next line to have an invisible signature
						int n = stp.getReader().getNumberOfPages();
						sap.setVisibleSignature(new Rectangle(POSITION_X, POSITION_Y, POSITION_U, POSITION_Z), n,
								sVisibleSignature);
						stp.close();
						reader.close();
						fout.close();
						sTrue = true;

					} catch (IOException e) {
						reader.close();
						stp.close();
						fout.close();
						LOG.debug("------Error: Sign file " + UrlSource + " (pdf) not success. Detail error: "
								+ getStackTrace(e));
						return false;
					}
				}
				if (sFileType != null && (sFileType.equals(".xlsx") || sFileType.equals(".docx"))) {
					try {
						OOXMLSign myFile = new OOXMLSign();
						myFile.signSHA2(UrlSource, UrlDes, key, chain[0]);
						sTrue = true;
					} catch (Exception e) {
						LOG.debug("------Error: Sign file " + UrlSource + " (excel) not success  -----" + e.toString());
						e.printStackTrace();
						return false;
					}
				}
			} catch (Exception e) {
				LOG.debug("------Error: Sign file " + UrlSource + "  not success  ----- " + getStackTrace(e));
				return false;
			}
			if (DeleteFileSource) {
				fileSource.delete();
			}
		} else {// File exited
			LOG.debug("------Error: path file " + UrlSource + " source not exists  -----");
			return false;
		}
		if (sTrue) {
			return true;
		} else {
			LOG.debug("------Error: path file " + UrlSource + " source not invalue type  -----");
			return false;
		}

	}

}
