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

import digital.impl.AbstractExelSign;

public class Signs {

	final Logger logger = LoggerFactory.getLogger(Signs.class);

	private static PrivateKey PRIVATEKEY;
	private static Certificate[] CHAIN;
	private static String PATH_SIGN_IMAGE;

	private static int POSITION_SIGN_IMAGE_X, POSITION_SIGN_IMAGE_Y, POSITION_SIGN_IMAGE_U, POSITION_SIGN_IMAGE_Z;

	public Signs() {

	}

	public Signs(String pathSign, String passSign) {
		new Signs(pathSign, passSign, null);
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

	public boolean SignFile(String UrlSource, String UrlDes, String fileType, String sReason_Sign,
			String sLocation_Sign, String sVisibleSignature, boolean DeleteFileSource) {
		boolean sTrue = false;
		File fileSource = new File(UrlSource);

		POSITION_SIGN_IMAGE_X = 245; // fix width
		POSITION_SIGN_IMAGE_Y = 90; // fix height
		POSITION_SIGN_IMAGE_U = 370;
		POSITION_SIGN_IMAGE_Z = 25;

		if (fileSource.exists()) {
			PrivateKey key = PRIVATEKEY;
			Certificate[] chain = CHAIN;
			try {
				if (fileType != null && fileType.equals(".pdf")) {
					PdfReader reader = null;
					PdfStamper stp = null;
					FileOutputStream fout = null;
					try {
						reader = new PdfReader(UrlSource);
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

						sap.setVisibleSignature(new Rectangle(POSITION_SIGN_IMAGE_X, POSITION_SIGN_IMAGE_Y,
								POSITION_SIGN_IMAGE_U, POSITION_SIGN_IMAGE_Z), n, sVisibleSignature);

						stp.close();
						reader.close();
						fout.close();
						return true;
					} catch (IOException e) {
						reader.close();
						stp.close();
						fout.close();
						e.printStackTrace();
					}
					return false;
				}
				if (fileType != null && (fileType.equals(".xlsx") || fileType.equals(".docx"))) {
					try {
						AbstractExelSign myFile = new AbstractExelSign();
						myFile.sign(UrlSource, UrlDes, key, chain[0]);
						sTrue = true;

					} catch (Exception e) {
						e.printStackTrace();
						return false;

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			if (DeleteFileSource) {
				fileSource.delete();
			}
		} else {
			logger.debug("------Error: path file " + UrlSource + " source not exists  -----");
			return false;
		}
		if (sTrue) {
			return true;
		} else {
			logger.debug("------Error: path file " + UrlSource + " source not invalue type  -----");
			return false;
		}
	}

	@SuppressWarnings("null")
	public boolean SignFileSHA2(String UrlSource, String UrlDes, String sFileType, String sReason_Sign,
			String sLocation_Sign, String sVisibleSignature, boolean DeleteFileSource) {

		boolean sTrue = false;
		File fileSource = new File(UrlSource);

		POSITION_SIGN_IMAGE_X = 245; // fix width
		POSITION_SIGN_IMAGE_Y = 90; // fix height
		POSITION_SIGN_IMAGE_U = 370;
		POSITION_SIGN_IMAGE_Z = 25;

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

						sap.setVisibleSignature(new Rectangle(POSITION_SIGN_IMAGE_X, POSITION_SIGN_IMAGE_Y,
								POSITION_SIGN_IMAGE_U, POSITION_SIGN_IMAGE_Z), n, sVisibleSignature);

						stp.close();
						reader.close();
						fout.close();
						sTrue = true;

					} catch (IOException e) {
						reader.close();
						stp.close();
						fout.close();
						logger.debug("------Error: Sign file " + UrlSource + " (pdf) not success. Detail error: "
								+ getStackTrace(e));
						return false;
					}
				}

				if (sFileType != null && (sFileType.equals(".xlsx") || sFileType.equals(".docx"))) {
					try {
						AbstractExelSign myFile = new AbstractExelSign();
						myFile.signSHA2(UrlSource, UrlDes, key, chain[0]);
						sTrue = true;

					} catch (Exception e) {
						logger.debug(
								"------Error: Sign file " + UrlSource + " (excel) not success  -----" + e.toString());
						e.printStackTrace();
						return false;

					}
				}

			} catch (Exception e) {

				logger.debug("------Error: Sign file " + UrlSource + "  not success  ----- " + getStackTrace(e));
				return false;
			}
			if (DeleteFileSource) {

				fileSource.delete();

			}
		} else {// File exited
			logger.debug("------Error: path file " + UrlSource + " source not exists  -----");
			return false;
		}
		if (sTrue) {
			return true;
		} else {
			logger.debug("------Error: path file " + UrlSource + " source not invalue type  -----");
			return false;
		}

	}

}
