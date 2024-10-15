package common.util.lzma;

import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream;
import org.apache.commons.compress.utils.FileNameUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
    Cần 2 thư viện: commons-compress, xz
 */
public class LZMASample {

    // Method to compress a PDF file to LZMA format
    public static File compressToLzma(String inputFilePath, String outputLzmaPath) {
        File compressedFile = new File(outputLzmaPath);
        try (InputStream fileInputStream = new FileInputStream(inputFilePath);
             OutputStream fileOutputStream = new FileOutputStream(compressedFile);
             LZMACompressorOutputStream lzmaOutputStream = new LZMACompressorOutputStream(fileOutputStream)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                lzmaOutputStream.write(buffer, 0, len);
            }
            System.out.println("Compression completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compressedFile; // Return the compressed file
    }

    // Method to decompress an LZMA file back to its original PDF format
    public static File decompressLzma(String inputLzmaPath, String outputPdfPath) {
        File decompressedFile = new File(outputPdfPath);
        try (InputStream fileInputStream = new FileInputStream(inputLzmaPath);
             LZMACompressorInputStream lzmaInputStream = new LZMACompressorInputStream(fileInputStream);
             OutputStream fileOutputStream = new FileOutputStream(decompressedFile)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = lzmaInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
            System.out.println("Decompression completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decompressedFile;
    }

    public static void main(String[] args) throws IOException {
        String path = "C:/Users/huyennv/Desktop/ts24pro_mobile";

        String inputFile = path + "/0309478306999-333-HDLD.pdf";

        String compressedLzma = path + "/compressed-file.lzma";
        String format = FileNameUtils.getExtension(inputFile);
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
        File compressedFile = compressToLzma(inputFile, compressedLzma);
        System.out.println("Compressed file: " + compressedFile.getAbsolutePath());

        // Decompress the LZMA file back to PDF
        File decompressedFile = decompressLzma(compressedLzma, decompressedLzma);
        System.out.println("Decompressed file: " + decompressedFile.getAbsolutePath());
    }

}
