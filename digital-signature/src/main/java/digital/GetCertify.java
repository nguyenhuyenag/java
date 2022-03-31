/*
	* @project: excelSign
	*@author:   ngangv
*May 20, 2010 4:57:17 PM
*/
package digital;

public class GetCertify {
	public CertificateInfo certificates = new CertificateInfo();

	public GetCertify() {
		/*
		 * try{ KeyStore ks; //char[] pin = { '1', '2', '3', '4', '5', '6', '7', '8' };
		 * ks = KeyStore.getInstance("Windows-MY","SunMSCAPI");
		 * Security.addProvider(ks.getProvider()); ks.load(null,null); for (Enumeration
		 * e = ks.aliases(); e.hasMoreElements();) { String ali = (String)
		 * e.nextElement(); if(ali.startsWith("CÔNG")){ PrivateKey key =
		 * (PrivateKey)ks.getKey(ali,null);
		 * 
		 * Certificate[] chain = ks.getCertificateChain(ali); Certificate cert
		 * =ks.getCertificate(ali); //PrivateKey privateKeyTest = (PrivateKey)
		 * ks.getKey(ali,"12345678".toCharArray()); certificates.setChain(chain);
		 * certificates.setPrivateKey(key);
		 * certificates.setPublicKey(cert.getPublicKey()); if (cert instanceof
		 * X509Certificate) { certificates.setCertifiate((X509Certificate)cert);
		 * //System.out.println(certificates.getCertifiate()); } } } }catch (Exception
		 * e) { e.printStackTrace(); }
		 */
		// getinfomation();

	}

//	private void getinfomation() {
//		try {
//			if (loadLibrary()) {
//				System.out.println("you load library success");
//			} else {
//				System.out.println("you can't load library");
//				return;
//			}
//			Provider[] ps = Security.getProviders();
//			Provider p = Security.getProvider("SunPKCS12-FeitianPKCS");
//
//			// Read the keystore form the smart card
//			char[] pin1 = { '1', '2', '3', '4', '5', '6', '7', '8' };
//			KeyStore keyStore = KeyStore.getInstance("PKCS12", p);
//			keyStore.load(null, pin1);
//			for (Enumeration e = keyStore.aliases(); e.hasMoreElements();) {
//				String ali = (String) e.nextElement();
//				// if(ali.startsWith("CÔNG")){
//				PrivateKey key = (PrivateKey) keyStore.getKey(ali, null);
//				Certificate[] chain = keyStore.getCertificateChain(ali);
//				Certificate cert = keyStore.getCertificate(ali);
//				certificates.setChain(chain);
//				certificates.setPrivateKey(key);
//				certificates.setPublicKey(cert.getPublicKey());
//
//				if (cert instanceof X509Certificate) {
//					certificates.setCertifiate((X509Certificate) cert);
//				}
//				break;
//				// }
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public static boolean loadLibrary() {
//		try {
//			String pkcs11config = "name = FeitianPKCS#11 \n" + "library = c:\\windows\\system32\\vdctdcsp11.dll \n"
//					+ "slot = 1";
//			byte[] pkcs11configBytes = pkcs11config.getBytes();
//			ByteArrayInputStream configStream = new ByteArrayInputStream(pkcs11configBytes);
//			Provider pkcs11Provider = new sun.security.pkcs11.SunPKCS11(configStream);
//			Security.addProvider(pkcs11Provider);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}

}
