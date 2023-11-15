package com.qr.wifi;

public enum AuthenticationMode {
	
	WPA("WPA"), WPA2("WPA2"), WEP("WEP"), NOPASS("nopass");

	private final String key;

	AuthenticationMode(String key) {
		this.key = key;
	}

	public String getKey() {
		return this.key;
	}

	public static AuthenticationMode get(String key) {
		for (AuthenticationMode mode : AuthenticationMode.values()) {
			if (mode.getKey().equalsIgnoreCase(key)) {
				return mode;
			}
		}
		throw new IllegalArgumentException("Authentication mode " + key + " does not exists");
	}

}
