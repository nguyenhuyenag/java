package com.basic;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public final class ReadNumber {

	public static final String KHONG = "không";
	public static final String MOT = "một";
	public static final String HAI = "hai";
	public static final String BA = "ba";
	public static final String BON = "bốn";
	public static final String NAM = "năm";
	public static final String SAU = "sáu";
	public static final String BAY = "bảy";
	public static final String TAM = "tám";
	public static final String CHIN = "chín";
	public static final String LAM = "lăm";
	public static final String LE = "lẻ";
	public static final String MUOI = "mươi";
	public static final String MUOIF = "mười";
	public static final String MOTS = "mốt";
	public static final String TRAM = "trăm";
	public static final String NGAN = "ngàn";
	public static final String TRIEU = "triệu";
	public static final String TY = "tỷ";
	public static final String[] number = { KHONG, MOT, HAI, BA, BON, NAM, SAU, BAY, TAM, CHIN };

	private static String[] MangChuSo = new String[10];
	// private static String tu_bon;
	private static String StrSo;
	private static int So_Nhom;
	private static int Stt_Nhom;
	private static int Stt_So;
	private static String So_Phu;
	private static Double soCongthem = 1E-13;// 0.0000000000001;

	private static String[] singleDigit = { "", " one", " two", " three", " four", " five", " six", " seven", " eight",
			" nine" };

	private static String[] tens = { " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	private static String[] twoDigits = { "", "", " twenty", " thirty", " forty", " fifty", " sixty", " seventy",
			" eighty", " ninety" };

	private static String[] ChuSo = { " không", " một", " hai", " ba", " bốn", " năm", " sáu", " bảy", " tám",
			" chín" };
	private static String[] Tien = { "", " nghìn", " triệu", " tỷ", " nghìn tỷ", " triệu tỷ" };

	public static String readNumber(String number) {
		ArrayList<String> kq = new ArrayList<String>();
		String traVe = "", kiTu = "";
		// Cắt chuỗi string chữ số ra thành các chuỗi nhỏ 3 chử số
		if (number != null && !number.equals("")) {
			ArrayList<String> List_Num = Split(number, 3);
			while (List_Num.size() != 0) {
				// Xét 3 số đầu tiên của chuỗi (số đầu tiên của List_Num)
				switch (List_Num.size() % 3) {
				// 3 số đó thuộc hàng trăm
				case 1:
					kq.addAll(read_3num(List_Num.get(0)));
					break;
				// 3 số đó thuộc hàng nghìn
				case 2:
					ArrayList<String> nghin = read_3num(List_Num.get(0));
					if (!nghin.isEmpty()) {
						kq.addAll(nghin);
						kq.add(NGAN);
					}
					break;
				// 3 số đó thuộc hàng triệu
				case 0:
					ArrayList<String> trieu = read_3num(List_Num.get(0));
					if (!trieu.isEmpty()) {
						kq.addAll(trieu);
						kq.add(TRIEU);
					}
					break;
				}
				// Xét nếu 3 số đó thuộc hàng tỷ
				if (List_Num.size() == (List_Num.size() / 3) * 3 + 1 && List_Num.size() != 1)
					kq.add(TY);

				// Xóa 3 số đầu tiên để tiếp tục 3 số kế
				List_Num.remove(0);
			}
			for (int i = 0; i < kq.size(); i++) {
				kiTu = kq.get(i);
				traVe += kiTu + " ";
			}
		}
		// return traVe;
		return StringUtils.capitalize(traVe);
	}

	// Đọc 3 số
	private static ArrayList<String> read_3num(String a) {
		ArrayList<String> kq = new ArrayList<String>();
		int num = -1;
		try {
			num = Integer.parseInt(a);
		} catch (Exception ex) {
		}
		if (num == 0)
			return kq;
		int hang_tram = -1;
		try {
			hang_tram = Integer.parseInt(a.substring(0, 1));
		} catch (Exception ex) {
		}
		int hang_chuc = -1;
		try {
			hang_chuc = Integer.parseInt(a.substring(1, 2));
		} catch (Exception ex) {
		}
		int hang_dv = -1;
		try {
			hang_dv = Integer.parseInt(a.substring(2, 3));
		} catch (Exception ex) {
		}

		// xét hàng trăm
		if (hang_tram != -1) {
			kq.add(number[hang_tram]);
			kq.add(TRAM);
		}
		// xét hàng chục
		switch (hang_chuc) {
		case -1:
			break;
		case 1:
			kq.add(MUOIF);
			break;
		case 0:
			if (hang_dv != 0)
				kq.add(LE);
			break;
		default:
			kq.add(number[hang_chuc]);
			kq.add(MUOI);
			break;
		}
		// xét hàng đơn vị
		switch (hang_dv) {
		case -1:
			break;
		case 1:
			if ((hang_chuc != 0) && (hang_chuc != 1) && (hang_chuc != -1))
				kq.add(MOTS);
			else
				kq.add(number[hang_dv]);
			break;
		case 5:
			if ((hang_chuc != 0) && (hang_chuc != -1))
				kq.add(LAM);
			else
				kq.add(number[hang_dv]);
			break;
		case 0:
			if (kq.isEmpty())
				kq.add(number[hang_dv]);
			break;
		default:
			kq.add(number[hang_dv]);
			break;
		}
		return kq;
	}

	private static ArrayList<String> Split(String str, int chunkSize) {
		int du = str.length() % chunkSize;
		// Nếu độ dài chuỗi không phải bội số của chunkSize thì thêm # vào trước cho đủ.
		if (du != 0)
			for (int i = 0; i < (chunkSize - du); i++)
				str = "#" + str;
		return splitStringEvery(str, chunkSize);
	}

	// Hàm cắt chuỗi ra thành chuỗi nhỏ
	private static ArrayList<String> splitStringEvery(String s, int interval) {
		ArrayList<String> arrList = new ArrayList<String>();
		int arrayLength = (int) Math.ceil(((s.length() / (double) interval)));
		String[] result = new String[arrayLength];
		int j = 0;
		int lastIndex = result.length - 1;
		for (int i = 0; i < lastIndex; i++) {
			result[i] = s.substring(j, j + interval);
			j += interval;
		}
		result[lastIndex] = s.substring(j);
		arrList.addAll(Arrays.asList(result));
		return arrList;
	}

	public static String DOC_SOTIEN_ENG(Double ps_nSo, String ps_sDVT, Boolean ps_bSoBon) {
		Double So = ps_nSo;
		String Sosaudauphay = null;
		So = ps_nSo;
		// tu_bon = " four";
		// if (ps_bSoBon) {
		// tu_bon = "four";
		// }

		MangChuSo[0] = " zero";
		MangChuSo[1] = " one";
		MangChuSo[2] = " two";
		MangChuSo[3] = " three";
		MangChuSo[4] = " four";
		MangChuSo[5] = " five";
		MangChuSo[6] = " six";
		MangChuSo[7] = " seven";
		MangChuSo[8] = " eight";
		MangChuSo[9] = " nine";

		String SoChu = "";
		if (So < 0) {
			So = -So;
			SoChu = SoChu + " minus";
		}
		// long b = So.longValue();
		// long a = (long)(So -Long.valueOf(So.longValue())) ;
		// Sosaudauphay = String.valueOf(So - (int)So.intValue());
		// Sosaudauphay = String.valueOf((So -So.longValue()));
		Sosaudauphay = String.valueOf(So - So.longValue());
		Sosaudauphay += "1E-13";
		So = Double.parseDouble(String.valueOf(So.longValue()));

		if (So == 0) {
			SoChu = SoChu + " zero";
		} else {
			StrSo = String.valueOf(So.longValue());
			if (StrSo.length() % 3 == 1) {
				StrSo = "00" + StrSo;
			}

			if (StrSo.length() % 3 == 2) {
				StrSo = "0" + StrSo;
			}

			So_Nhom = StrSo.length() / 3;
			Stt_Nhom = So_Nhom;
			Stt_So = 0;

			// &&Cho den vi tri cua chu so dau tien cua nhom cuoi cung
			while (Stt_So <= (StrSo.length() - 2)) {
				So_Phu = StrSo.substring(Stt_So, Stt_So + 3).toString();
				// Stt_Nhom = (int)Math.Round(Convert.toDecimal((StrSo.length() - Stt_So + 1) /
				// 3), 0);
				Stt_Nhom = (int) Math.round(Integer.parseInt(String.valueOf((StrSo.length() - Stt_So + 1) / 3)));
//sua   String.valueOf(((StrSo.length() - Stt_So + 1) / 3)), 2)
				if (DOC_SOTIEN_ENG_NHOM(So_Phu, Stt_Nhom, So_Nhom).length() > 0) {

					// SoChu = SoChu + DOI_SO_CHU_NHOM_ENG(So_Phu, Stt_Nhom, So_Nhom) + " and";
					SoChu = SoChu + DOC_SOTIEN_ENG_NHOM(So_Phu, Stt_Nhom, So_Nhom);
				} else {
					SoChu = SoChu + DOC_SOTIEN_ENG_NHOM(So_Phu, Stt_Nhom, So_Nhom);
				}

				Stt_So = Stt_So + 3;
			}

		}

		SoChu = Left(SoChu.trim(), SoChu.length());
		// Bangvs - Da sua -> 2013.03.05

		if (Double.parseDouble(Sosaudauphay) > Double.valueOf(0 + soCongthem)) {
			SoChu = SoChu + " dot";
			Sosaudauphay = Sosaudauphay.toString().substring(2,
					String.valueOf(ps_nSo).length() - So.toString().length() - 1);
			// Cat lay phan sau dau phay)
			if (Left(Sosaudauphay, 1) != "0") {
				// &&Cat nhung so 0 o ben phai do STR() di
				while (Right(Sosaudauphay, 1) == "0") {
					Sosaudauphay = Left(Sosaudauphay, Sosaudauphay.length() - 1);
				}
				// &&Cong them cac so khong vao dang truoc chuoi de duoc chan cac to hop 3 so
				if (Sosaudauphay.length() % 3 == 1) {
					Sosaudauphay = "00" + Sosaudauphay;
				}

				if (Sosaudauphay.length() % 3 == 2) {
					Sosaudauphay = "0" + Sosaudauphay;
				}

				// So_Nhom = (int)Math.Round(Convert.ToDecimal(Sosaudauphay.length() / 3), 0);
				So_Nhom = (int) Math.round(Integer.parseInt(String.valueOf(Sosaudauphay.length() / 3)));
				// sua
				Stt_Nhom = So_Nhom;
				Stt_So = 0;

				// &&Cho den vi tri cua chu so dau tien cua nhom cuoi cung
				while (Stt_So <= (Sosaudauphay.length() - 2)) {
					So_Phu = Sosaudauphay.substring(Stt_So, Stt_So + 3);
					// Stt_Nhom = (int)Math.Round(Convert.ToDecimal((Sosaudauphay.length() - Stt_So
					// + 1) / 3), 0);
					Stt_Nhom = (int) Math
							.round(Integer.parseInt(String.valueOf((Sosaudauphay.length() - Stt_So + 1) / 3)));
					// sua
					SoChu = SoChu + DOC_SOTIEN_ENG_NHOM(So_Phu, Stt_Nhom, So_Nhom);
					Stt_So = Stt_So + 3;
				}
			} else {
				while (Right(Sosaudauphay, 1) == "0") {
					Sosaudauphay = Left(Sosaudauphay, Sosaudauphay.length() - 1);
				}
				int i = 0;
				int j = 0;
				for (i = 0; i <= Sosaudauphay.length() - 1; i++) {
					// j = Convert.ToInt16(Sosaudauphay.substring(i, 1));
					j = Integer.parseInt(Sosaudauphay.substring(i, 1));
					SoChu = SoChu + MangChuSo[j];
				}
			}

		}
		SoChu = (Left(SoChu, 1).toUpperCase() + SoChu.substring(1) + ps_sDVT);
		// Bangvs - Da sua -> 2013.03.05
		return SoChu;
	}

	private static String DOC_SOTIEN_ENG_NHOM(String Nhom_So, int Stt_Nhom, Object So_Nhom) {

		String Tram = null;
		String Chuc = null;
		String Don_Vi = null;
		String Tram_Chu = null;
		String Chuc_Chu = null;
		String Don_Vi_Chu = null;
		String Nhom_Chu = null;

		Nhom_Chu = "";
		Tram = Left(Nhom_So, 1);
		Chuc = Nhom_So.toString().substring(1, 2);
		Don_Vi = Right(Nhom_So, 1);
		Tram_Chu = MangChuSo[Integer.parseInt(Tram)];
		Chuc_Chu = MangChuSo[Integer.parseInt(Chuc)];
		Don_Vi_Chu = MangChuSo[Integer.parseInt(Don_Vi)];

		if ((!Tram.equals("0"))) {
			Nhom_Chu = Nhom_Chu + Tram_Chu + " hundred";
		}

		switch (Chuc_Chu.trim()) {

		case "and":
			if (Don_Vi_Chu.trim() != " zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;

		case "zero":

			if (Don_Vi_Chu.trim() != " zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;

		case "one":

			switch (Don_Vi_Chu.trim()) {

			case "one":
				Nhom_Chu = Nhom_Chu + " eleven";
				break;
			case "two":
				Nhom_Chu = Nhom_Chu + " twelve";
				break;
			case "three":
				Nhom_Chu = Nhom_Chu + " thirteen";
				break;
			case "four":
				Nhom_Chu = Nhom_Chu + " fourteen";
				break;
			case "five":
				Nhom_Chu = Nhom_Chu + " fifteen";
				break;
			case "zero":
				Nhom_Chu = Nhom_Chu + " ten";
				break;
			default:
				Nhom_Chu = Nhom_Chu + " " + Don_Vi_Chu.trim() + "teen";
				break;

			}
			break;

		case "two":
			Nhom_Chu = Nhom_Chu + " twenty";
			if (Don_Vi_Chu.trim() != "zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;
		case "three":
			Nhom_Chu = Nhom_Chu + " thirty";
			if (Don_Vi_Chu.trim() != "zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;
		case "four":
			Nhom_Chu = Nhom_Chu + " forty";
			if (Don_Vi_Chu.trim() != "zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;
		case "five":
			Nhom_Chu = Nhom_Chu + " fifty";
			if (Don_Vi_Chu.trim() != "zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;

		case "six":
			Nhom_Chu = Nhom_Chu + " sixty";
			if (Don_Vi_Chu.trim() != "zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;
		case "seven":
			Nhom_Chu = Nhom_Chu + " seventy";
			if (Don_Vi_Chu.trim() != "zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;
		case "eight":
			Nhom_Chu = Nhom_Chu + " eighty";
			if (Don_Vi_Chu.trim() != "zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;
		case "nine":
			Nhom_Chu = Nhom_Chu + " ninety";
			if (Don_Vi_Chu.trim() != "zero") {
				Nhom_Chu = Nhom_Chu + Don_Vi_Chu;
			}
			break;
		}

		if ((Tram.equals("0")) & (Chuc.equals("0")) & (!Don_Vi.equals("0")) & (Stt_Nhom > 1)) {
			Nhom_Chu = Don_Vi_Chu;
		}
		if ((Tram.equals("0")) & (Chuc.equals("0")) & (!Don_Vi.equals("0")) & (So_Nhom.equals("1"))) {
			Nhom_Chu = Don_Vi_Chu;
		}

		switch ((int) Stt_Nhom) {
		case 2:
			Nhom_Chu = Nhom_Chu + " thousand";
			break;
		case 3:
			Nhom_Chu = Nhom_Chu + " million";
			break;
		case 4:
			Nhom_Chu = Nhom_Chu + " billion";
			break;
		case 5:
			Nhom_Chu = Nhom_Chu + " thousand";
			break;
		case 6:
			Nhom_Chu = Nhom_Chu + " million";
			break;
		}

		if ((Tram.equals("0")) & (Chuc.equals("0")) & (Don_Vi.equals("0"))) {
			Nhom_Chu = "";
		}
		return Nhom_Chu;
	}

	static String Left(String str, int length) {
		if (str != null && !str.equals("")) {
			// str = str;
		} else {
			str = "";
		}
//	str = (str ?? String.Empty);

		return str.substring(0, Math.min(length, str.length()));
	}

	static String Right(String str, int length) {
		if (str != null && !str.equals("")) {
			// str = str;
		} else {
			str = "";
		}
		if (str.length() >= length) {
			return str.substring(str.length() - length, str.length());
		} else {
			return str;
		}

//    return (str.length() >= length) ? str.substring(str.length() - length, length) : str;
	}

	public static String convertToWords(String input) {
		long number = Long.parseLong(input);
		int size = input.length();
		if (size <= 3) {
			int num = (int) number;
			return handle3Digits(num);
		} else if (size > 3 && size <= 6) {
			int thousand = (int) (number / 1000);
			int hundred = (int) (number % 1000);
			String thousands = handle3Digits(thousand);

			String hundreds = handle3Digits(hundred);
			String word = "";

			if (!thousands.isEmpty()) {
				word = thousands + " thousand";
			}
			word += hundreds;
			return word;
		} else if (size > 6 && size <= 9) {
			int million = (int) (number / 1000000);
			number = number % 1000000;
			int thousand = (int) (number / 1000);
			int hundred = (int) (number % 1000);

			String millions = handle3Digits(million);
			String thousands = handle3Digits(thousand);
			String hundreds = handle3Digits(hundred);

			String word = "";

			if (!millions.isEmpty()) {
				word = millions + " million";
			}
			if (!thousands.isEmpty()) {
				word += thousands + " thousand";
			}
			word += hundreds;
			return word;
		}

		return "Not implemented yet.";
	}

	private static String handle3Digits(int number) {
		if (number <= 0)
			return "";

		String word = "";
		if (number / 100 > 0) {
			int dividend = number / 100;
			word = singleDigit[dividend] + " hundred";
			number = number % 100;
		}
		if (number / 10 > 1) {
			int dividend = number / 10;
			number = number % 10;
			word += twoDigits[dividend];
		} else if (number / 10 == 1) {
			number = number % 10;
			word += tens[number];
			return word;
		} else {
			number = number % 10;
		}
		if (number > 0) {
			word += singleDigit[number];
		}

		return word;
	}

	public static String DocTienBangChu(double SoTien, String strTail) {
		String[] arr = String.valueOf(SoTien).split("\\.");
		String sDoc = "";
		if (arr.length == 2) {
			long so1 = Long.valueOf(arr[0]);
			sDoc = DocTienBangChu(so1);
			long so2 = Long.valueOf(arr[1]);
			if (so2 > 0)
				sDoc += " phẩy " + DocTienBangChu(so2);
		} else
			sDoc = DocTienBangChu((long) SoTien);
		if (sDoc != "")
			sDoc += " " + strTail + ".";
		return sDoc;
	}

	public static String DocTienBangChu(long SoTien, String strTail) {

		String[] arr = String.valueOf(SoTien).split("\\.");
		String sDoc = "";
		if (arr.length == 2) {
			long so1 = Long.valueOf(arr[0]);
			sDoc = DocTienBangChu(so1);
			long so2 = Long.valueOf(arr[1]);
			if (so2 > 0)
				sDoc += " phẩy " + DocTienBangChu(so2).toLowerCase();
		} else
			sDoc = DocTienBangChu((long) SoTien);
		if (sDoc != "")
			sDoc += " " + strTail + ".";
		return sDoc;
	}

	public static String DocTienBangChu(long SoTien) {
		int lan, i;
		long songuyen;

		String KetQua = "", tmp = "";
		int[] ViTri = new int[6];
		if (SoTien < 0)
			return "Số tiền âm";
		if (SoTien == 0)
			return "Không";
		if (SoTien > 0) {
			songuyen = SoTien;
		} else {
			songuyen = -SoTien;
		}

		// Kiểm tra số quá lớn
		if (SoTien > Long.parseLong("8999999999999999")) {
			SoTien = 0;
			return "";
		}
		ViTri[5] = (int) (songuyen / Long.parseLong("1000000000000000"));
		songuyen = songuyen - Long.parseLong(String.valueOf(ViTri[5])) * Long.parseLong("1000000000000000");
		ViTri[4] = (int) (songuyen / Long.parseLong("1000000000000"));
		songuyen = songuyen - Long.parseLong(String.valueOf(ViTri[4])) * Long.parseLong("1000000000000");
		ViTri[3] = (int) (songuyen / 1000000000);
		songuyen = songuyen - Long.parseLong(String.valueOf(ViTri[3])) * 1000000000;
		ViTri[2] = (int) (songuyen / 1000000);
		ViTri[1] = (int) ((songuyen % 1000000) / 1000);
		ViTri[0] = (int) (songuyen % 1000);
		if (ViTri[5] > 0) {
			lan = 5;
		} else if (ViTri[4] > 0) {
			lan = 4;
		} else if (ViTri[3] > 0) {
			lan = 3;
		} else if (ViTri[2] > 0) {
			lan = 2;
		} else if (ViTri[1] > 0) {
			lan = 1;
		} else {
			lan = 0;
		}
		for (i = lan; i >= 0; i--) {
			tmp = DocSo3ChuSo(ViTri[i]);
			KetQua += tmp;
			if (ViTri[i] != 0)
				KetQua += Tien[i];
			if ((i > 0) && (StringUtils.isNotEmpty(tmp)))
				KetQua += ",";// && (!string.IsNullOrEmpty(tmp))
		}
		if (KetQua.substring(KetQua.length() - 1, KetQua.length()) == ",")
			KetQua = KetQua.substring(0, KetQua.length() - 1);
		KetQua = KetQua.trim();
		return KetQua.substring(0, 1).toUpperCase() + KetQua.substring(1);
	}

	// Hàm đọc số có 3 chữ số
	private static String DocSo3ChuSo(int baso) {
		int tram, chuc, donvi;
		String KetQua = "";
		tram = (int) (baso / 100);
		chuc = (int) ((baso % 100) / 10);
		donvi = baso % 10;
		if ((tram == 0) && (chuc == 0) && (donvi == 0))
			return "";
		if (tram != 0) {
			KetQua += ChuSo[tram] + " trăm";
			if ((chuc == 0) && (donvi != 0))
				KetQua += " linh";
		}
		if ((chuc != 0) && (chuc != 1)) {
			KetQua += ChuSo[chuc] + " mươi";
			if ((chuc == 0) && (donvi != 0))
				KetQua = KetQua + " linh";
		}
		if (chuc == 1)
			KetQua += " mười";
		switch (donvi) {
		case 1:
			if ((chuc != 0) && (chuc != 1)) {
				KetQua += " mốt";
			} else {
				KetQua += ChuSo[donvi];
			}
			break;
		case 5:
			if (chuc == 0) {
				KetQua += ChuSo[donvi];
			} else {
				KetQua += " lăm";
			}
			break;
		default:
			if (donvi != 0) {
				KetQua += ChuSo[donvi];
			}
			break;
		}
		return KetQua;
	}

	public static String DocTienBangChuUSD(double SoTien) {
		String[] arr = String.valueOf(SoTien).replaceAll(",", ".").split("\\.");
		String sDoc = "";
		if (arr.length == 2) {
			long so1 = Long.parseLong(arr[0]);
			sDoc = DocTienBangChu(so1);
			long so2 = Long.parseLong(arr[1]);
			if (so2 > 0)
				sDoc += " đôla Mỹ và " + DocTienBangChu(so2).toLowerCase() + " xen.";
		} else
			sDoc = DocTienBangChu((long) SoTien) + " đôla Mỹ.";
		return sDoc;
	}

	public static String DocTienBangChuNgoaiTe(double SoTien) {
		try {
			String[] arr = String.valueOf(SoTien).replaceAll(",", ".").split("\\.");
			String sDoc = "";
			if (arr.length == 2) {
				long so1 = Long.parseLong(arr[0]);
				sDoc = DocTienBangChu(so1);
				// String so2 = Convert.ToString(arr[1].PadRight(2, '0'));
				String so2 = "";
				if (arr[1] != null && !arr[1].equals("")) {
					if (arr[1].length() == 1) {
						so2 = arr[1] + "0";
					} else {
						so2 = arr[1];
					}
				} else {
					so2 = arr[1] + "00";
				}
				// String so2 = arr[1]+"00";
				// so2 = so2.substring(0, 2);
				if (Double.parseDouble(so2) > 0)
					// sDoc += " đôla Mỹ và " + ChuyenSo(so2).ToLower() + "xen.";
					sDoc += " đôla Mỹ " + ChuyenSo(so2).toLowerCase() + "xen.";
			} else
				sDoc = DocTienBangChu((long) SoTien) + " đôla Mỹ.";
			return sDoc.replaceAll("  ", " ");
		} catch (Exception e) {
			return "";
		}
	}

	private static String ChuyenSo(String number) {
		String[] dv = { "", "mươi", "trăm", "nghìn", "triệu", "tỉ" };
		String[] cs = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };

		int length = number.length();
		number += "ss";
		StringBuilder doc = new StringBuilder();
		int rd = 0;

		int i = 0;
		while (i < length) {
			// So chu so o hang dang duyet
			int n = (length - i + 2) % 3 + 1;

			// Kiem tra so 0
			int found = 0;
			int j;
			for (j = 0; j < n; j++) {
				if (number.toCharArray()[i + j] == '0')
					continue;
				found = 1;
				break;
			}

			// Duyet n chu so
			int k;
			if (found == 1) {
				rd = 1;
				for (j = 0; j < n; j++) {
					int ddv = 1;
					switch (number.toCharArray()[i + j]) {
					case '0':
						if (n - j == 3)
							doc.append(cs[0]);
						if (n - j == 2) {
							if (number.toCharArray()[i + j + 1] != '0')
								doc.append("lẻ");
							ddv = 0;
						}
						break;
					case '1':
						switch (n - j) {
						case 3:
							doc.append(cs[1]);
							break;
						case 2:
							doc.append("mười");
							ddv = 0;
							break;
						case 1:
							k = (i + j == 0) ? 0 : i + j - 1;
							doc.append(
									(number.toCharArray()[k] != '1' && number.toCharArray()[k] != '0') ? "mốt" : cs[1]);
							break;
						}
						break;
					case '5':
						doc.append((i + j == length - 1) ? "năm" : cs[5]);
						break;
					default:
						doc.append(cs[number.toCharArray()[i + j] - 48]);
						break;
					}

					doc.append(" ");

					// Doc don vi nho
					if (ddv == 1)
						doc.append(dv[n - j - 1] + " ");
				}
			}

			// Doc don vi lon
			if (length - i - n > 0) {
				if ((length - i - n) % 9 == 0) {
					if (rd == 1)
						for (k = 0; k < (length - i - n) / 9; k++)
							doc.append("tỉ ");
					rd = 0;
				} else if (found != 0)
					doc.append(dv[((length - i - n + 1) % 9) / 3 + 2] + " ");
			}

			i += n;
		}

		return (length == 1) && (number.toCharArray()[0] == '0' || number.toCharArray()[0] == '5')
				? cs[number.toCharArray()[0] - 48]
				: doc.toString();
	}

	public static void main(String[] args) {
		String n = "123456";
		System.out.println(readNumber(n));
	}

}