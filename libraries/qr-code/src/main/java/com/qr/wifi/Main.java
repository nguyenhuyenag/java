package com.qr.wifi;

import java.nio.file.Paths;

import org.apache.commons.lang3.SystemUtils;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("[+] Generating QR code...");

		WifiQrCodeGenerator generator = new WifiQrCodeGenerator();

		String ssid = "VNPT2";
		// AuthenticationMode authenticationMode = AuthenticationMode.WPA2;
		String password = "123456";
		String outputFile = Paths.get(SystemUtils.USER_DIR, "output", "wifi_qr_code_2.png").toString();

		generator.withSsid(ssid) //
				.withAuthenticationMode(AuthenticationMode.WPA2) //
				.withPassword(password) //
				.toOutputFile(outputFile);
		
		System.out.println("[.] Params: " + generator);
		System.out.println("[.] Raw QR Code Payload: " + generator.getPaylodString());
		generator.generateQrCodePicture();
		System.out.println("[+] QR code generated. Output: " + outputFile);
	}

}
