 /*
 	* @project: excelSign
 	*@author:   ngangv
	*May 25, 2010 1:30:11 PM
	*/
package digital;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class CertificateInfo {
	X509Certificate certifiate;
	PrivateKey privateKey;
	PublicKey  publicKey;
	Certificate[] chain;

	public X509Certificate getCertifiate() {
		return certifiate;
	}
	public void setCertifiate(X509Certificate certifiate) {
		this.certifiate = certifiate;
	}
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}
	public PublicKey getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}
	public Certificate[] getChain() {
		return chain;
	}
	public void setChain(Certificate[] chain) {
		this.chain = chain;
	}

}
