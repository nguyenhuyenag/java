package com;

import common.util.XmlUtils;

public class Main {
	
	public static void main(String[] args) {
		String xml = "<TDiep>\r\n" + 
				"	<TTChung>\r\n" + 
				"		<PBan>1.0.0</PBan>\r\n" + 
				"		<MNGui>TCT</MNGui>\r\n" + 
				"		<MNNhan>V0309478306</MNNhan>\r\n" + 
				"		<MLTDiep>999</MLTDiep>\r\n" + 
				"		<MTDiep>TCT_MTDiep_999</MTDiep>\r\n" + 
				"		<MTDTChieu>V030947830659FEA6EA42BA4C13906BDB819545CEC1</MTDTChieu>\r\n" + 
				"	</TTChung>\r\n" + 
				"	<DLieu>\r\n" + 
				"		<TBao>\r\n" + 
				"			<MTDiep>999</MTDiep>\r\n" + 
				"			<MNGui>TCT</MNGui>\r\n" + 
				"			<NNhan>2021-10-30T14:00:00</NNhan>\r\n" + 
				"			<TTTNhan>0</TTTNhan>\r\n" + 
				"			<DSLDo>\r\n" + 
				"				<LDo>\r\n" + 
				"					<MTa>TCT đã nhận thông điệp thành công</MTa>\r\n" + 
				"					<MLoi />\r\n" + 
				"				</LDo>\r\n" + 
				"			</DSLDo>\r\n" + 
				"		</TBao>\r\n" + 
				"	</DLieu>\r\n" + 
				"</TDiep>";
		System.out.println(XmlUtils.readData(xml, "MNGui"));
	}

}
