/*
	* @project: digitalOffice
	*@author:   nganv
*Jun 21, 2010 2:05:56 PM
*/
package digital.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URL;

import be.fedict.eid.applet.service.signer.TemporaryDataStorage;
import be.fedict.eid.applet.service.signer.ooxml.AbstractOOXMLSignatureService;

public class OOXMLSignatureServiceImpl extends AbstractOOXMLSignatureService {

	private final URL ooxmlUrl;

	private final TemporaryTestDataStorage temporaryDataStorage;

	private final ByteArrayOutputStream signedOOXMLOutputStream;

	public OOXMLSignatureServiceImpl(URL ooxmlUrl) {
		this.temporaryDataStorage = new TemporaryTestDataStorage();
		this.signedOOXMLOutputStream = new ByteArrayOutputStream();
		this.ooxmlUrl = ooxmlUrl;
	}

	@Override
	protected URL getOfficeOpenXMLDocumentURL() {
		return this.ooxmlUrl;
	}

	@Override
	protected OutputStream getSignedOfficeOpenXMLDocumentOutputStream() {
		return this.signedOOXMLOutputStream;
	}

	public byte[] getSignedOfficeOpenXMLDocumentData() {
		return this.signedOOXMLOutputStream.toByteArray();
	}

	@Override
	protected TemporaryDataStorage getTemporaryDataStorage() {
		return this.temporaryDataStorage;
	}
}
