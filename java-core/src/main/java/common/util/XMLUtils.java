package common.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLUtils {

	/**
	 * Đọc dữ liệu của 1 tag: <name>Java</name> => Java
	 */
	public static String getTagValue(String xml, String parent, String tagName) {
		if (StringUtils.isEmpty(xml)) {
			return "";
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try (StringReader sr = new StringReader(xml)) {
			Document doc = factory.newDocumentBuilder().parse(new InputSource(sr));
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(parent);
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element el = (Element) nNode;
					Node tagNode = el.getElementsByTagName(tagName).item(0);
					if (tagNode != null) {
						return tagNode.getTextContent();
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getStructAndTextOfTag(String xml, String tagName) {
		if (StringUtils.isEmpty(xml) || StringUtils.isEmpty(tagName)) {
			return "";
		}
		String start = "<" + tagName + ">";
		String end = "</" + tagName + ">";
		String between = StringUtils.substringBetween(xml, start, end);
		if (StringUtils.isEmpty(between)) {
			return "";
		}
		return start + between + end;
	}
	
	public static boolean isXMLValid(String string) {
		try (StringReader sr = new StringReader(string)) {
			SAXParserFactory.newInstance() //
					.newSAXParser() //
					.getXMLReader() //
					.parse(new InputSource(sr));
			return true;
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		// 	String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TDiep><TTChung><PBan>2.0.0</PBan><MNGui>TCT</MNGui><MNNhan>V0309478306</MNNhan><MLTDiep>202</MLTDiep><MTDiep>TCTB2C5E9AF7DEF49B5BA33411171A2DF30</MTDiep><MTDTChieu>V03094783068DD2707F86154E8594A24EFC2BAE1227</MTDTChieu><MST>0106324653</MST><SLuong>1</SLuong></TTChung><DLieu><HDon xmlns:inv=\"http://laphoadon.gdt.gov.vn/2014/09/invoicexml/v1\" xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"><DLHDon Id=\"TS24_2111051448445960106322455\"><TTChung><PBan>2.0.0</PBan><THDon>Hóa đơn giá trị gia tăng</THDon><KHMSHDon>1</KHMSHDon><KHHDon>C21TCT</KHHDon><SHDon>14</SHDon><NLap>2021-11-05</NLap><DVTTe>đ</DVTTe><TGia>1</TGia><HTTToan>TM/CK</HTTToan><MSTTCGP>0309478306</MSTTCGP><TTKhac><TTin><TTruong>PBHThi</TTruong><KDLieu>string</KDLieu><DLieu>32</DLieu></TTin><TTin><TTruong>TTrang</TTruong><KDLieu>numeric</KDLieu><DLieu>1</DLieu></TTin><TTin><TTruong>MNHDon</TTruong><KDLieu>string</KDLieu><DLieu>2111051448445960106322455</DLieu></TTin><TTin><TTruong>NCDoi</TTruong><KDLieu>string</KDLieu><DLieu/></TTin><TTin><TTruong>NTNCDoi</TTruong><KDLieu>string</KDLieu><DLieu/></TTin><TTin><TTruong>CTCHDon</TTruong><KDLieu>string</KDLieu><DLieu>https://www.xuathoadon.com.vn</DLieu></TTin><TTin><TTruong>DTToan</TTruong><KDLieu>string</KDLieu><DLieu>1</DLieu></TTin><TTin><TTruong>BHQDThoai</TTruong><KDLieu>string</KDLieu><DLieu/></TTin><TTin><TTruong>HTNTe</TTruong><KDLieu>string</KDLieu><DLieu>0</DLieu></TTin><TTin><TTruong>MauIn</TTruong><KDLieu>string</KDLieu><DLieu>TS24_8fcc47d001344f5cbb2638c4c19bb20b</DLieu></TTin><TTin><TTruong>TSuat</TTruong><KDLieu>string</KDLieu><DLieu>10</DLieu></TTin><TTin><TTruong>BDSCCKhau</TTruong><KDLieu>string</KDLieu><DLieu>0</DLieu></TTin></TTKhac></TTChung><NDHDon><NBan><Ten>Mã số Thuế Test 109</Ten><MST>0106324653</MST><DChi>114 phố Đội Cấn, Phường Đội Cấn, Ba Đình, Tp. Hà Nội</DChi><SDThoai>0796424349</SDThoai><DCTDTu>ktpm.ts24@gmail.com</DCTDTu><STKNHang/><TNHang/><Fax/><Website/><TTKhac><TTin><TTruong>QHuyen</TTruong><KDLieu>string</KDLieu><DLieu>Ba Đình</DLieu></TTin><TTin><TTruong>TThanh</TTruong><KDLieu>string</KDLieu><DLieu>Tp. Hà Nội</DLieu></TTin><TTin><TTruong>QGia</TTruong><KDLieu>string</KDLieu><DLieu>VN</DLieu></TTin><TTin><TTruong>NLap</TTruong><KDLieu>string</KDLieu><DLieu>AC</DLieu></TTin><TTin><TTruong>Logistic</TTruong><KDLieu>string</KDLieu><DLieu>AC</DLieu></TTin></TTKhac></NBan><NMua><Ten>Công ty test</Ten><MST>0106322455</MST><DChi>285/94B cmt8</DChi><MKHang/><SDThoai>231213</SDThoai><DCTDTu>tho.nguyen@ts24.co.vn</DCTDTu><HVTNMHang>CHD</HVTNMHang><STKNHang>123123</STKNHang><TNHang>ACB</TNHang><TTKhac><TTin><TTruong>Fax</TTruong><KDLieu>string</KDLieu><DLieu>123231</DLieu></TTin></TTKhac></NMua><DSHHDVu><HHDVu><TChat>1</TChat><STT>1</STT><MHHDVu>MH_233</MHHDVu><THHDVu>Ve SG DN</THHDVu><DVTinh>Cái</DVTinh><SLuong>1</SLuong><DGia>1200000</DGia><TLCKhau>0</TLCKhau><STCKhau>0</STCKhau><ThTien>1200000</ThTien><TSuat>10%</TSuat><TTKhac><TTin><TTruong>TThue</TTruong><KDLieu>numeric</KDLieu><DLieu>120000</DLieu></TTin><TTin><TTruong>ThTCThue</TTruong><KDLieu>numeric</KDLieu><DLieu>1320000</DLieu></TTin><TTin><TTruong>KHThi</TTruong><KDLieu>string</KDLieu><DLieu>0</DLieu></TTin></TTKhac></HHDVu></DSHHDVu><TToan><THTTLTSuat><LTSuat><TSuat>10%</TSuat><TThue>84000.0</TThue><ThTien>1200000</ThTien></LTSuat></THTTLTSuat><TgTCThue>1200000</TgTCThue><TgTThue>84000</TgTThue><DSLPhi><LPhi><TLPhi>Chi phí khác</TLPhi><TPhi>0</TPhi></LPhi></DSLPhi><TTCKTMai>0</TTCKTMai><TgTTTBSo>1284000</TgTTTBSo><TgTTTBChu>Một triệu hai trăm tám mươi bốn nghìn đồng.</TgTTTBChu><TTKhac><TTin><TTruong>TgTTTBCTAnh</TTruong><KDLieu>string</KDLieu><DLieu>One million two hundred eighty four thousand Vietnam dongs</DLieu></TTin><TTin><TTruong>TgTTTBCTViet</TTruong><KDLieu>string</KDLieu><DLieu>Một triệu hai trăm tám mươi bốn nghìn đồng.</DLieu></TTin></TTKhac></TToan></NDHDon><TTKhac/></DLHDon><MCCQT Id=\"Id-3fca5333d7894598844aae52ece50271\">00474597512BE94B7BAB367996EF464828</MCCQT><DSCKS><NBan><Signature Id=\"NBan\" xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\"/><Reference URI=\"#TS24_2111051448445960106322455\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/><DigestValue>fYWyS9sbYrkYFEMny+uLrtzlk0UzVr7qA63fjdQ+4fk=</DigestValue></Reference><Reference Type=\"http://www.w3.org/2000/09/xmldsig#SignatureProperties\" URI=\"#TimeStamp\"><DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/><DigestValue>I4yXVkPe1weHqCqyUM7CpeqEhDStHp2TJGX4Tcmgqcg=</DigestValue></Reference></SignedInfo><SignatureValue>aFERuOgSpr3/7FTPpJZuMwsinYZrW90qQF7kpwH2nWkWtpwjJFpz+EnBuHsj26W3o1FZbTae1rd+5TLr/Fr+uOdq3IBYcvp0FrSch1jDTptsg4jxx7rN9RzxzE2aGvDWoVdpel+DtJBMcwPwXcvSlrIm5mgaAWW2kGw61BB4z45MTa8ct6SwqLgcGkiud4zh6hsyqk12yylUSVlHOUzWPalgt16wVdrUFTqPnLXWh7g1cpPWLCq+Kui+AorEMmLSIsMVK36/2fQyv79bN5UDE8fPqJ8iqxVpHlGahWnQEFIL5qsZSik/KXerURNRlalf1VTCyfwOGjpY2VXFf2hTZA==</SignatureValue><KeyInfo><X509Data><X509SubjectName>C=VN, S=TP Hồ Chí Minh, L=\"285/94B Cách mạng tháng 8, Phường 12, Quận 10, TP Hồ Chí Minh\", O=MÃ SỐ THUẾ TEST 109, CN=MÃ SỐ THUẾ TEST 109, OID.0.9.2342.19200300.100.1.1=MST:0106324653, E=info@ts24.com.vn</X509SubjectName><X509Certificate>MIIFszCCBJugAwIBAgIQVAEBCAltigLi8izpi9cWjjANBgkqhkiG9w0BAQsFADBRMQswCQYDVQQGEwJWTjEjMCEGA1UECgwaU0FGRVRZIENFUlRJRlkgQ09SUE9SQVRJT04xHTAbBgNVBAMMFFNBRkUtQ0EgU0hBLTI1NiAyMDIwMB4XDTIxMTEwNTAxMDcyMVoXDTIzMDIwNjAxMDcyMVowggEEMR8wHQYJKoZIhvcNAQkBFhBpbmZvQHRzMjQuY29tLnZuMR4wHAYKCZImiZPyLGQBAQwOTVNUOjAxMDYzMjQ2NTMxITAfBgNVBAMMGE3DgyBT4buQIFRIVeG6viBURVNUIDEwOTEhMB8GA1UECgwYTcODIFPhu5AgVEhV4bq+IFRFU1QgMTA5MVIwUAYDVQQHDEkyODUvOTRCIEPDoWNoIG3huqFuZyB0aMOhbmcgOCwgUGjGsOG7nW5nIDEyLCBRdeG6rW4gMTAsIFRQIEjhu5MgQ2jDrSBNaW5oMRowGAYDVQQIDBFUUCBI4buTIENow60gTWluaDELMAkGA1UEBhMCVk4wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCHKMsynwR+eibtYXndti/o9bS/A4SK4ZSxBQUOKus5sOYgTg/TdZxuuxJ7cfrAwNqWRTxP6Y7DEtDOQsZYWO3NAgQoM+/mkomNRc+aWVtWr7EXYkQlvU9KWNrLeBgZkJliTA6bTotH1OS4x7YUjRNwLFYls38dMa7EADm0cOkc6P5nlYViv7KpM9Tx1uJ3S/WuQAWo3yQf/M4V5oDfC2XDysW5IxPHuQBZpc3VyuxaU3USCmjYnxrZtmmEHrWRDd5TuBbAubgm2KnJxq0fOaMGdiVepnuTxU7NRS7lXdgscIkrfQB/Dgm3vg4sXjYIDEWQ+abNw068n8xduBRm01FNAgMBAAGjggHQMIIBzDCBswYIKwYBBQUHAQEEgaYwgaMwMgYIKwYBBQUHMAKGJmh0dHBzOi8vcm9vdGNhLmdvdi52bi9jcnQvdm5yY2EyNTYucDdiMEAGCCsGAQUFBzAChjRodHRwOi8vd3d3LnNhZmVjZXJ0LmNvbS52bi93d3cvY2VydC9TQUZFLUNBLTIwMjAuY2VyMCsGCCsGAQUFBzABhh9odHRwOi8vb2NzcDIwMjAuc2FmZWNlcnQuY29tLnZuMB0GA1UdDgQWBBR6eSTfbnpL2rRkUWFlzZ32wLKKJjAMBgNVHRMBAf8EAjAAMB8GA1UdIwQYMBaAFFkA4fVoAKegCQ7q9nQ8m1PihNPYMEkGA1UdIARCMEAwPgYKKwYBBAGB7QMBCDAwMC4GCCsGAQUFBwIBFiJodHRwOi8vd3d3LnNhZmVjZXJ0LmNvbS52bi93d3cvcnBhMC8GA1UdHwQoMCYwJKAioCCGHmh0dHA6Ly9jcmwyMDIwLnNhZmVjZXJ0LmNvbS52bjAOBgNVHQ8BAf8EBAMCBPAwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMBsGA1UdEQQUMBKBEGluZm9AdHMyNC5jb20udm4wDQYJKoZIhvcNAQELBQADggEBAHP1QSiuZhYiY+uqgWBq1qX/+N3ZngBSV7W4ay0n7xpMEwrhszafGZQRZSjCASdUAwtu9WjH/V215EKey9ZjttxELflqnt6NSMi54ZpFOGfgGoq+bn/dzya5Xu+Z/+emh0rLi/uArhX3WSDSDzj1eZP8+UbUXxewR5tFIMTwJzCt8LCn+iXtSF6qBpfuQZ4PozsmlQsD19OkABlxpCUjl2SgK+Vx9nfl3Mp7bLkcYNy7QaOiyX/PpKvoMd1teCsYvSzquXy14B2BRpJ30ujrJB9x0Wows5QP5mL6GVNbEbwwf5H3FuDWi9mrXMRbLmoa0jsGYExuNbPQwZgzPmqshWU=</X509Certificate></X509Data></KeyInfo><Object Id=\"TimeStamp\"><SignatureProperties><SignatureProperty Id=\"proid\" Target=\"#NBan\"><SigningTime>2021-11-05T14:48:47</SigningTime></SignatureProperty></SignatureProperties></Object></Signature></NBan><NMua/><CCKSKhac/><CQT><Signature Id=\"Tct-uuid\" xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\"/><Reference URI=\"#TS24_2111051448445960106322455\"><DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/><DigestValue>fYWyS9sbYrkYFEMny+uLrtzlk0UzVr7qA63fjdQ+4fk=</DigestValue></Reference><Reference URI=\"#SigningTime-17df25b26639432c8e6e1fdca4b08b28\"><DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/><DigestValue>l0r1EWJqGWrJWRDhszuy1FX3J1HsiZvSbOQRs1Z7VlY=</DigestValue></Reference><Reference URI=\"#Id-3fca5333d7894598844aae52ece50271\"><DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/><DigestValue>OXLIUgMOVBLUODxxPRjgOKf93M4Bywd+NgdpFomlTes=</DigestValue></Reference></SignedInfo><SignatureValue>0gCV529f1BedirOyTBrfvK88fVTCW6RI3m6C2oFr4CPfKElH9ONrvdchiDI9Rj+YI83eo7/0cKLu43pX4JWW6ww1tl847ucYFjeTX3SY9QHogpG/EC1Ny82Gw5GU8NAD1Qmg28JwgqbTlhhRwhlQRorkytl3S0Bm6gq2I/gFh0yOqA2LjPB6FpHl296xJ9ZHahAwaHg6mzROpu/eoQJClRYPxPXx9Hb2k0j5OpJcvwG2MQECvsgm0wPUmhcE9gAngAJKlMQMFfzgGBNB0o3U6ODqD6SYLQaggPyc6b62vNn8UcIrFvdFvc66UpIf0eay2J+jpNBWktpHznY2ikZ5pA==</SignatureValue><KeyInfo><X509Data><X509SubjectName>CN=Tổng cục thuế Test 01</X509SubjectName><X509Certificate>MIIDRzCCAi+gAwIBAgIQbYJ+PW9g1fGMCAT216XJkjANBgkqhkiG9w0BAQsFADAYMRYwFAYDVQQDDA1DWUJFUkxPVFVTLUNBMB4XDTIxMTAyMDEzNDkxM1oXDTIzMTAyMDEzNDkxM1owJjEkMCIGA1UEAwwbVOG7lW5nIGPhu6VjIHRodeG6vyBUZXN0IDAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5WuS2+ptB81jC10L0KiQvML2ncjqvsgnkhItbpDYdTOzhphJgioOqRaGaXW55HMNRV2hRcQ96DXQVEWq72QRRA36d6lCSbeHTpieL0bfqwy+TV6qnMqntpGtFcUZLwYeBaUusQA2thGG6YHZpQLicIjYcUuvHzLt9CXWo4XJEWl2EnOORyzB4nkzbko2SGl63/qIA/VHc5Y2Cn7ykPpd+LjrP6AeE2JgmE9CIHAgwYZNZZfKWjF+64OFs/QerOOI1LqVlvx+XbbeLB5qwM38Kkc4PywyuVj5NM2kbZekPzJJRsqsMHPxI2jDILIPqvYvwhVZkKEmeukiYgdWE+8kcwIDAQABo38wfTAMBgNVHRMBAf8EAjAAMB8GA1UdIwQYMBaAFHJm6SIoV+NUQVkehr2Ptlj3B7YzMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDAdBgNVHQ4EFgQU9r3qRBc6SwSzJPl6txxiFrmE4UwwDgYDVR0PAQH/BAQDAgXgMA0GCSqGSIb3DQEBCwUAA4IBAQCRJURHsPjLAkNKiq+zfruPuFMMwIJu0OYm/jcBxmUsfEiNvVUOFRi/9AklZ01bmKVdpjEsP0mbh0RUk4OiK6d8spx0ShN80KjcISW/wjMaLkMgUbb2sVbVSnsMrenbpa6U1Gms5AV5NREOqKPUYNS6otNsVbkKPRDtw9KyQHC/XHydaANVsIa6LqgadVngf5F/4XnU9eYqQAzrJaHPWvWjwdkwxje8XViBEsqcTC24YfayJcZc1gkA2DIsW/2eUCmABvJi7n3VngLVxakXI6YOchsRKPmKlqZJQZ5yaYsD9eBfCbG37+J7npGMYDRQATq8PCa9CNQtPJlUdulN359b</X509Certificate></X509Data></KeyInfo><Object Id=\"SigningTime-17df25b26639432c8e6e1fdca4b08b28\"><SignatureProperties><SignatureProperty Target=\"signatureProperties\"><SigningTime>2021-11-05T14:49:44</SigningTime></SignatureProperty></SignatureProperties></Object></Signature></CQT></DSCKS><DSCKS/></HDon></DLieu></TDiep>";
		// System.out.println(getTextOfTag(xml, "HDon", "MCCQT"));
		// System.out.println(isXMLValid("123asasa"));
	}

}
