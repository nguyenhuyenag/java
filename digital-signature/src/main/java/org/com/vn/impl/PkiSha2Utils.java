/*
 * eID Applet Project.
 * Copyright (C) 2008-2009 FedICT.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version
 * 3.0 as published by the Free Software Foundation.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, see
 * http://www.gnu.org/licenses/.
 */

/*
 * Copyright (C) 2008-2009 FedICT.
 * This file is part of the eID Applet Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.com.vn.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.jce.X509KeyUsage;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;
//import org.bouncycastle.x509.X509V3CertificateGenerator;
import org.joda.time.DateTime;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class PkiSha2Utils {

	public static final byte[] SHA2_DIGEST_INFO_PREFIX = new byte[] { 0x30, 0x31, 0x30, 0x0d, 0x06, 0x09, 0x60, (byte) 0x86, 0x48, 0x01, 0x65, 0x03, 0x04, 0x02, 0x01, 0x05, 0x00,
			0x04, 0x20 };

	private PkiSha2Utils() {
		super();
	}

	static KeyPair generateKeyPair() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		SecureRandom random = new SecureRandom();
		keyPairGenerator.initialize(new RSAKeyGenParameterSpec(1024,
				RSAKeyGenParameterSpec.F4), random);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		return keyPair;
	}

	private static SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey)
			throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(publicKey
				.getEncoded());
		SubjectPublicKeyInfo info = new SubjectPublicKeyInfo(
				(ASN1Sequence) new ASN1InputStream(bais).readObject());
		return new SubjectKeyIdentifier(info);
	}

	final public static String PROVIDER = BouncyCastleProvider.PROVIDER_NAME;

	private static AuthorityKeyIdentifier createAuthorityKeyId(
			PublicKey publicKey) throws IOException {

		ByteArrayInputStream bais = new ByteArrayInputStream(publicKey
				.getEncoded());
		SubjectPublicKeyInfo info = new SubjectPublicKeyInfo(
				(ASN1Sequence) new ASN1InputStream(bais).readObject());

		return new AuthorityKeyIdentifier(info);
	}
	static X509Certificate generateCertificate( PublicKey entityKey, PrivateKey caKey) throws InvalidKeyException, IllegalStateException, NoSuchAlgorithmException, SignatureException, CertificateException, NoSuchProviderException{
		//CertificateUtilities
		 Security.addProvider(new BouncyCastleProvider());

		 X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
		 Hashtable attrs = new Hashtable();

		                attrs.put(X509Principal.C, "AU");
		               attrs.put(X509Principal.O, "The Legion of the Bouncy Castle");
		               attrs.put(X509Principal.L, "Melbourne");
		               attrs.put(X509Principal.ST, "Victoria");
		                attrs.put(X509Principal.E, "feedback-crypto@bouncycastle.org");

		              /* Vector ord = new Vector();*/
		                Vector values = new Vector();



		               values.addElement("AU");
		                values.addElement("The Legion of the Bouncy Castle");
		               values.addElement("Melbourne");
		               values.addElement("Victoria");
		                 values.addElement("feedback-crypto@bouncycastle.org");

		               certGen.setSerialNumber(BigInteger.valueOf(1));
		               certGen.setIssuerDN(new X509Principal(attrs));
		                certGen.setNotBefore(new Date(
		                       System.currentTimeMillis() - 50000));
		                certGen
		                         .setNotAfter(new Date(
		                              System.currentTimeMillis() + 50000));
	               certGen.setSubjectDN(new X509Principal(attrs));
		                certGen.setPublicKey(entityKey);
		               certGen.setSignatureAlgorithm("SHA256withRSA");
		                certGen.addExtension("2.5.29.15", true, new X509KeyUsage(
		                      X509KeyUsage.encipherOnly));
		                certGen.addExtension("2.5.29.37", true, new DERSequence(
		                       KeyPurposeId.anyExtendedKeyUsage));
		              certGen.addExtension("2.5.29.17", true, new GeneralNames(
		                      new GeneralName(GeneralName.rfc822Name,
		                               "test@test.test")));
		              if(caKey instanceof RSAPrivateKey){
		            	  System.out.println("rsaKey");
		              }

		              Security.addProvider(new BouncyCastleProvider());
		              X509Certificate cert = certGen.generate(caKey,"BC");
		               cert.checkValidity(new Date());
		                cert.verify(entityKey);

		                ByteArrayInputStream sbIn = new ByteArrayInputStream(cert
		                       .getEncoded());
		                ASN1InputStream sdIn = new ASN1InputStream(sbIn);
		               ByteArrayInputStream bIn = new ByteArrayInputStream(cert
		                       .getEncoded());
		                CertificateFactory certFact = CertificateFactory.getInstance(
		                       "X.509");

		               cert = (X509Certificate) certFact.generateCertificate(bIn);

		               System.out.println("my test");


		return null;
	}
	static X509Certificate generateCertificate(PublicKey subjectPublicKey,
			String subjectDn, DateTime notBefore, DateTime notAfter,
			X509Certificate issuerCertificate, PrivateKey issuerPrivateKey,
			boolean caFlag, int pathLength, String crlUri, String ocspUri,
			KeyUsage keyUsage) throws IOException, InvalidKeyException,
			IllegalStateException, NoSuchAlgorithmException,
			SignatureException, CertificateException, NoSuchProviderException {

		String signatureAlgorithm = "SHA256withRSA";
		X509V3CertificateGenerator certificateGenerator = new X509V3CertificateGenerator();
		certificateGenerator.reset();

		certificateGenerator.setSignatureAlgorithm(signatureAlgorithm);
		certificateGenerator.setPublicKey(subjectPublicKey);
		//set date time expire date
		certificateGenerator.setNotAfter(issuerCertificate.getNotAfter());
		certificateGenerator.setNotBefore(issuerCertificate.getNotBefore());
		/**end**/
		X509Principal issuerDN;
		//System.out.println(issuerCertificate.getIssuerDN().getName());
		if (null != issuerCertificate) {
			issuerDN = new X509Principal(issuerCertificate.getIssuerDN().getName());

		} else {
			issuerDN = new X509Principal(subjectDn);
		}
		certificateGenerator.setIssuerDN(issuerDN);
		certificateGenerator.setSubjectDN(new X509Principal(subjectDn));

		certificateGenerator.setSerialNumber(issuerCertificate.getSerialNumber());

		certificateGenerator.copyAndAddExtension(X509Extensions.SubjectAlternativeName, false, issuerCertificate);
		certificateGenerator.copyAndAddExtension(X509Extensions.AuthorityInfoAccess, false, issuerCertificate);
		certificateGenerator.copyAndAddExtension(X509Extensions.AuthorityKeyIdentifier, false, issuerCertificate);
		certificateGenerator.copyAndAddExtension(X509Extensions.SubjectKeyIdentifier,
				false, issuerCertificate);
		certificateGenerator.copyAndAddExtension(X509Extensions.CertificatePolicies, false, issuerCertificate);

		certificateGenerator.copyAndAddExtension(X509Extensions.BasicConstraints, true, issuerCertificate);
		certificateGenerator.copyAndAddExtension(X509Extensions.ExtendedKeyUsage, false, issuerCertificate);
		certificateGenerator.copyAndAddExtension(X509Extensions.CRLDistributionPoints, false, issuerCertificate);

		/**add information into digital sign**/

		certificateGenerator.copyAndAddExtension(X509Extensions.KeyUsage, true, issuerCertificate);

		X509Certificate certificate;
		certificate =certificateGenerator.generate(issuerPrivateKey);

		CertificateFactory certificateFactory = CertificateFactory
				.getInstance("X.509");

		certificate = (X509Certificate) certificateFactory
				.generateCertificate(new ByteArrayInputStream(certificate
						.getEncoded()));
		System.out.println(certificate);
		return certificate;

	}


	static Document loadDocument(InputStream documentInputStream)
			throws ParserConfigurationException, SAXException, IOException {
		InputSource inputSource = new InputSource(documentInputStream);
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = documentBuilder.parse(inputSource);
		return document;
	}

	static String toString(Node dom) throws TransformerException {
		Source source = new DOMSource(dom);
		StringWriter stringWriter = new StringWriter();
		Result result = new StreamResult(stringWriter);
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		/*
		 * We have to omit the ?xml declaration if we want to embed the
		 * document.
		 */
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.transform(source, result);
		return stringWriter.getBuffer().toString();
	}
}
