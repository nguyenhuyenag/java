package common.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4SafeDecompressor;

public class LZ4Utils {

	public static String compressToString(String str) {
		LZ4Factory lz4Factory = LZ4Factory.safeInstance();
		// LZ4Factory lz4Factory = LZ4Factory.fastestInstance();
		byte[] byteArr = str.getBytes(StandardCharsets.UTF_8);
		LZ4Compressor compressor = lz4Factory.highCompressor();
		byteArr = compressor.compress(byteArr);
		return Base64Utils.encodeToString(byteArr);
	}

	public static String decompressToString(String strZipped) {
		LZ4Factory factory = LZ4Factory.safeInstance();
		byte[] byteArr = Base64Utils.decode(strZipped);
		if (byteArr != null) {
			int len = byteArr.length;
			byte[] restored = new byte[len * 3];
			LZ4SafeDecompressor decompressor = factory.safeDecompressor();
			decompressor.decompress(byteArr, 0, len, restored, 0);
			return new String(restored, StandardCharsets.UTF_8);
		}
		return "";
	}

	public static void main(String[] args) {
		String xml = "<TTChung><PBan>2.0.0</PBan><MSo>01/ĐKTĐ-HĐĐT</MSo><Ten>Nhận</Ten><LDKUNhiem>2</LDKUNhiem><CQTQLy>Chi cục thuế Quận 4</CQTQLy><MCQTQLy>70107</MCQTQLy><NLHe>Phòng kiểm thử</NLHe><DCLHe>285/94B, Xã Thới Tam Thôn, Huyện Hóc Môn, Tp. Hồ Chí Minh</DCLHe><DTLHe>1234567890</DTLHe><DDanh>Chi cục thuế Quận 4</DDanh><NLap>2021-10-19</NLap></TTChung>";
		String zip = compressToString(xml);
		System.out.println("Encode: " + zip);
		System.out.println("Decode: " + decompressToString(zip));
	}

}
