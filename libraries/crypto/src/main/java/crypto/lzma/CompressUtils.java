package crypto.lzma;

import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompressUtils {

    public static void compressFile(Path file, Path destination) throws CompressorException, IOException {
        String format = FileNameUtils.getExtension(destination);
        try (OutputStream os = Files.newOutputStream(destination);
             BufferedOutputStream bos = new BufferedOutputStream(os);
             CompressorOutputStream<?> compressor = new CompressorStreamFactory()
                     .createCompressorOutputStream(format, bos)) {
            IOUtils.copy(Files.newInputStream(file), compressor);
        }
    }

    public static void decompress(Path file, Path destination) throws CompressorException, IOException {
        try (InputStream is = Files.newInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(is);
             OutputStream out = Files.newOutputStream(destination);
             CompressorInputStream decompressor = new CompressorStreamFactory()
                     .createCompressorInputStream(bis)) {
            IOUtils.copy(decompressor, out);
        }
    }

    public static void main(String[] args) throws CompressorException, IOException {
        String path = "C:/Users/huyennv/Desktop/ts24pro_mobile";

        String file = "/0309478306999-333-HDLD.pdf";

        Path inputFile = Paths.get(path + file);
        String format = FileNameUtils.getExtension(inputFile);
        Path destination = Paths.get(path + "/compressed-" + format + ".lzma");
        CompressUtils.compressFile(inputFile, destination);
        System.out.println("Compressed success: " + Files.isRegularFile(destination));
    }

}
