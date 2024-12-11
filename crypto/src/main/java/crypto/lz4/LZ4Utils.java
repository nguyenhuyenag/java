package crypto.lz4;

import crypto.util.Base64Utils;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

import java.nio.charset.StandardCharsets;

public class LZ4Utils {

    public static String compressToString(String str) {
        LZ4Factory lz4Factory = LZ4Factory.safeInstance();
        byte[] byteArr = str.getBytes(StandardCharsets.UTF_8);
        LZ4Compressor compressor = lz4Factory.highCompressor();
        byteArr = compressor.compress(byteArr);
        return Base64Utils.encodeToString(byteArr);
    }

    public static void main(String[] args) {

    }

}
