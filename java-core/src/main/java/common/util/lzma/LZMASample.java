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

    https://www.baeldung.com/apache-commons-compress-project
 */
public class LZMASample {

    // Method to compress a PDF file to LZMA format
//    public static File compressToLzma(String inputFilePath, String outputLzmaPath) throws IOException {
//        Path compressedFile = Paths.get(inputFilePath);
//        byte[] bytes = Files.readAllBytes(compressedFile);
//        byte[] bytesLZMA = compressByteArray(bytes);
//        return Files.write(Paths.get(outputLzmaPath),bytesLZMA).toFile();
////        try (InputStream fileInputStream = new FileInputStream(inputFilePath);
////             OutputStream fileOutputStream = new FileOutputStream(compressedFile);
////             LZMACompressorOutputStream lzmaOutputStream = new LZMACompressorOutputStream(fileOutputStream)) {
////            byte[] buffer = new byte[1024];
////            int len;
////            while ((len = fileInputStream.read(buffer)) != -1) {
////                lzmaOutputStream.write(buffer, 0, len);
////            }
////            System.out.println("Compression completed!");
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return compressedFile; // Return the compressed file
//    }

//    public static File compressToLzma(String inputFilePath, String outputLzmaPath) throws IOException {
//        Path compressedInput = Paths.get(inputFilePath);
//        byte[] byteArrayInput = Files.readAllBytes(compressedInput);
//        byte[] byteArrayLZMA = compressByteArray(byteArrayInput);
//        return Files.write(Paths.get(outputLzmaPath),byteArrayLZMA).toFile();
//    }

//    // Method to decompress an LZMA file back to its original PDF format
//    public static File decompressLzma(String inputLzmaPath, String outputPdfPath) {
//        File decompressedFile = new File(outputPdfPath);
//        try (InputStream fis = new FileInputStream(inputLzmaPath);
//             LZMACompressorInputStream lzmaInputStream = new LZMACompressorInputStream(fis);
//             OutputStream fos = new FileOutputStream(decompressedFile)) {
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = lzmaInputStream.read(buffer)) != -1) {
//                fos.write(buffer, 0, len);
//            }
//            System.out.println("Decompression completed!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return decompressedFile;
//    }

    // Method to compress a byte array using LZMA
//    public static byte[] compressByteArray(byte[] inputData) throws IOException {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        // Wrap the output stream with LZMACompressorOutputStream to compress data
//        try (LZMACompressorOutputStream lzmaOutputStream = new LZMACompressorOutputStream(byteArrayOutputStream);
//             ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputData);) {
//            byte[] buffer = new byte[1024]; // Buffer for reading the input data in chunks
//            int len;
//            while ((len = byteArrayInputStream.read(buffer)) != -1) {
//                lzmaOutputStream.write(buffer, 0, len);
//            }
//             // return byteArrayOutputStream.toByteArray(); <- error
//        } finally {
//            byteArrayOutputStream.close();
//        }
//        return byteArrayOutputStream.toByteArray(); // ok
//    }

    public static byte[] compressByteArray(byte[] inputData) throws IOException {
        // Wrap the output stream with LZMACompressorOutputStream to compress data
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             LZMACompressorOutputStream lzmaOutputStream = new LZMACompressorOutputStream(byteArrayOutputStream);
             ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputData)) {
            byte[] buffer = new byte[1024]; // Buffer for reading the input data in chunks
            int len;
            while ((len = byteArrayInputStream.read(buffer)) != -1) {
                lzmaOutputStream.write(buffer, 0, len);
            }
            // Ensure the stream is fully flushed
            lzmaOutputStream.finish();  // Explicitly finish the compression
            return byteArrayOutputStream.toByteArray();
        }
    }

    // Utility method to decompress a byte array from LZMA format
    private static byte[] decompressByteArray(byte[] compressedData) throws IOException {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
             LZMACompressorInputStream lzmaInputStream = new LZMACompressorInputStream(byteArrayInputStream);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();) {
            byte[] buffer = new byte[1024];
            int len;
            // Read from the LZMA stream and write to the output stream
            while ((len = lzmaInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            // Return the decompressed byte array
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

        String inputFile = path + "/0309478306999-333-HDLD.pdf";

        String format = FileNameUtils.getExtension(inputFile);
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
