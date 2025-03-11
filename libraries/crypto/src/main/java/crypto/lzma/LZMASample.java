package crypto.lzma;

import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
    Cần 2 thư viện: commons-compress, xz

    https://www.baeldung.com/apache-commons-compress-project
 */
public class LZMASample {

    // Hàm chung để xử lý đọc từ InputStream và ghi vào OutputStream
    private static void transferData(InputStream inputStream, OutputStream outputStream) throws IOException {
        IOUtils.copy(inputStream, outputStream);
    }

    // Hàm nén dữ liệu bằng LZMA
    public static byte[] compressByteArray(byte[] data) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             LZMACompressorOutputStream lzmaOutputStream = new LZMACompressorOutputStream(baos);
             ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data)) {
            transferData(byteArrayInputStream, lzmaOutputStream);
            lzmaOutputStream.finish();
            return baos.toByteArray();
        }
    }

    // Hàm giải nén dữ liệu LZMA
    public static byte[] decompressByteArray(byte[] data) throws IOException {
        try (ByteArrayInputStream baos = new ByteArrayInputStream(data);
             LZMACompressorInputStream lzmaInputStream = new LZMACompressorInputStream(baos);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            transferData(lzmaInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static Path compressToLzma(String inputFilePath, String outputLzmaPath) throws IOException {
        byte[] inputData = Files.readAllBytes(Paths.get(inputFilePath));
        byte[] compressedData = compressByteArray(inputData);
        return Files.write(Paths.get(outputLzmaPath), compressedData);
    }

    public static Path decompressLzma(String inputLzmaFilePath, String outputFilePath) throws IOException {
        byte[] compressedData = Files.readAllBytes(Paths.get(inputLzmaFilePath));
        byte[] decompressedData = decompressByteArray(compressedData);
        return Files.write(Paths.get(outputFilePath), decompressedData);
    }

    public static void main(String[] args) throws IOException {
        String path = "C:/Users/huyennv/Desktop/ts24pro_mobile";

        String inputFile = path + "/ts24pro_mobile.txt";

        String format = FilenameUtils.getExtension(inputFile);
        String compressedLzma = path + "/compressed-" + format + ".lzma";
        String decompressedLzma = path + "/decompressed-file." + format;

        // TODO
        Path path1 = Paths.get(compressedLzma);
        if (Files.exists(path1)) {
            Files.delete(path1);
        }
        Path path2 = Paths.get(decompressedLzma);
        if (Files.exists(path2)) {
            Files.delete(path2);
        }

        // Compress the PDF to LZMA
        Path compressedFile = compressToLzma(inputFile, compressedLzma);
        System.out.println("Compressed file: " + compressedFile.toString());

        // Decompress the LZMA file back to PDF
        Path decompressedFile = decompressLzma(compressedLzma, decompressedLzma);
        System.out.println("Decompressed file: " + decompressedFile.toString());
    }

}
