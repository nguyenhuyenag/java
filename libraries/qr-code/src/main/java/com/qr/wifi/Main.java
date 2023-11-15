package com.qr.wifi;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("[+] Generating QR code...");

		WifiQrCodeGenerator generator = new WifiQrCodeGenerator();

		String ssid = null;
		AuthenticationMode authenticationMode = AuthenticationMode.WPA2;
		String password = null;
		String outputFile = null;

		generator.withSsid(ssid) //
				.withAuthenticationMode(authenticationMode) //
				.withPassword(password) //
				.toOutputFile(outputFile);
		
		System.out.println("[.] Params: " + generator);
		System.out.println("[.] Raw QR Code Payload: " + generator.getPaylodString());
		generator.generateQrCodePicture();
		System.out.println("[+] QR code generated. Output: " + outputFile);
	}

}
