package com;

public class Main {

	public static void main(String[] args) {
		String s = "<TTChung>\r\n" + 
				"	<PBan>2.0.0</PBan>\r\n" + 
				"	<MSo>01/ĐKTĐ-HĐĐT</MSo>\r\n" + 
				"	<Ten>Nhận</Ten>\r\n" + 
				"	<LDKUNhiem>2</LDKUNhiem>\r\n" + 
				"	<CQTQLy>Chi cục thuế Quận 4</CQTQLy>\r\n" + 
				"	<MCQTQLy>70107</MCQTQLy>\r\n" + 
				"	<NLHe>Phòng kiểm thử</NLHe>\r\n" + 
				"	<DCLHe>285/94B, Xã Thới Tam Thôn, Huyện Hóc Môn, Tp. Hồ Chí Minh</DCLHe>\r\n" + 
				"	<DTLHe>1234567890</DTLHe>\r\n" + 
				"	<DDanh>Chi cục thuế Quận 4</DDanh>\r\n" + 
				"	<NLap>2021-10-19</NLap>\r\n" + 
				"</TTChung>";
		System.out.println(s.replaceAll("\\r\\n", "").replaceAll("	", ""));
	}

}
