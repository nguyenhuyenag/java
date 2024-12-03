package crypto.lz4;

import crypto.util.Base64Utils;
import crypto.util.DataUtils;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4SafeDecompressor;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class LZ4Utils {

    public static String compressToString(String str) {
        LZ4Factory lz4Factory = LZ4Factory.safeInstance();
        // LZ4Factory lz4Factory = LZ4Factory.fastestInstance();
        byte[] byteArr = str.getBytes(StandardCharsets.UTF_8);
        LZ4Compressor compressor = lz4Factory.highCompressor();
        byteArr = compressor.compress(byteArr);
        return Base64Utils.encodeToString(byteArr);
    }

//    public static String decompressToString(String strZipped) {
//        LZ4Factory factory = LZ4Factory.safeInstance();
//        byte[] byteArr = Base64Utils.decodeToByte(strZipped);
//        if (byteArr != null) {
//            int len = byteArr.length;
//            byte[] restored = new byte[3 * len];
//            LZ4SafeDecompressor decompressor = factory.safeDecompressor();
//            decompressor.decompress(byteArr, 0, len, restored, 0);
//            return new String(restored, StandardCharsets.UTF_8);
//        }
//        return "";
//    }

    // TODO: Error
    public static String decompressToString(String strZipped) {
        LZ4Factory factory = LZ4Factory.safeInstance();
        byte[] byteArr = Base64Utils.decodeToByte(strZipped);

        if (byteArr != null) {
            LZ4SafeDecompressor decompressor = factory.safeDecompressor();
            // Try decompression into a dynamically resizing buffer
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                int chunkSize = 1024;
                byte[] chunk = new byte[chunkSize];
                int decompressedSize;

                // Decompress data in chunks
                int offset = 0;
                while (offset < byteArr.length) {
                    decompressedSize = decompressor.decompress(byteArr, offset, chunk.length, chunk, 0);
                    outputStream.write(chunk, 0, decompressedSize);
                    offset += decompressedSize;
                }

                return outputStream.toString(StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    public static void main(String[] args) {
        String xml = DataUtils.xml();

        String encrypt = compressToString(xml);
        System.out.println(encrypt);

        String decrypt = decompressToString(encrypt);
        // System.out.println(decrypt);
    }

}
