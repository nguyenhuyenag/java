package learn;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class Main {

	// private static String bytesIntoHumanReadable(long bytes) {
	// long kilobyte = 1024;
	// long megabyte = kilobyte * 1024;
	// long gigabyte = megabyte * 1024;
	// long terabyte = gigabyte * 1024;
	// if ((bytes >= 0) && (bytes < kilobyte)) {
	// return bytes + " B";
	// } else if ((bytes >= kilobyte) && (bytes < megabyte)) {
	// return (bytes / kilobyte) + " KB";
	// } else if ((bytes >= megabyte) && (bytes < gigabyte)) {
	// return (bytes / megabyte) + " MB";
	// } else if ((bytes >= gigabyte) && (bytes < terabyte)) {
	// return (bytes / gigabyte) + " GB";
	// } else if (bytes >= terabyte) {
	// return (bytes / terabyte) + " TB";
	// } else {
	// return bytes + " Bytes";
	// }
	// }

	public static String floatForm(double d) {
		return new DecimalFormat("#.##").format(d);
	}

	public static String bytesToHuman(long size) {
		long Kb = 1 * 1024;
		long Mb = Kb * 1024;
		long Gb = Mb * 1024;
		long Tb = Gb * 1024;
		long Pb = Tb * 1024;
		long Eb = Pb * 1024;
		if (size < Kb)
			return floatForm(size) + " byte";
		if (size >= Kb && size < Mb)
			return floatForm((double) size / Kb) + " Kb";
		if (size >= Mb && size < Gb)
			return floatForm((double) size / Mb) + " Mb";
		if (size >= Gb && size < Tb)
			return floatForm((double) size / Gb) + " Gb";
		if (size >= Tb && size < Pb)
			return floatForm((double) size / Tb) + " Tb";
		if (size >= Pb && size < Eb)
			return floatForm((double) size / Pb) + " Pb";
		if (size >= Eb)
			return floatForm((double) size / Eb) + " Eb";

		return "???";
	}
	
	/*
	 * Input	Decimal (SI)
					1k = 1000	Binary (IEC)
					1k = 1024
		0	"0 B"	"0 B"
		27	"27 B"	"27 B"
		999	"999 B"	"999 B"
		1000	"1.0 kB"	"1000 B"
		1023	"1.0 kB"	"1023 B"
		1024	"1.0 kB"	"1.0 KiB"
		1728	"1.7 kB"	"1.7 KiB"
		1855425871872	"1.9 TB"	"1.7 TiB"
		Long.MAX_VALUE	"9.2 EB"	"8.0 EiB"
	 */
	public static String humanReadableByteCount(long bytes, boolean si) {
		int unit = si ? 1000 : 1024;
		if (bytes < unit)
			return bytes + " B";
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}

	public static void main(String[] args) {
		// Path csv = Paths.get("file/data-csv.csv");
		// long size = csv.toFile().length();
		File file = new File("file/data-csv.csv");
		// FilesUtils.readAllLines(csv).forEach(t -> System.out.println(t));
		// System.out.println(FileUtils.byteCountToDisplaySize(file.length()));
		System.out.println(humanReadableByteCount(file.length(), false));
	}

}
