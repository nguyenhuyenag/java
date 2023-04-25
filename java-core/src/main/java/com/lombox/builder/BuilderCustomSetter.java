package com.lombox.builder;

import java.io.File;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class Message {

	private String sender;
	private String recipient;
	private String text;
	private File file;

	public Message text(String text) {
		this.text = text;
		verifyTextOrFile();
		return this;
	}

	public Message file(File file) {
		this.file = file;
		verifyTextOrFile();
		return this;
	}

	private void verifyTextOrFile() {
		if (text != null && file != null) {
			throw new IllegalStateException("Cannot send 'text' and 'file'.");
		}
	}
}

public class BuilderCustomSetter {

	public static void main(String[] args) {
		Message message = Message.builder() //
				.sender("user@somedomain.com") //
				.recipient("someuser@otherdomain.com") //
				.text("How are you today?") //
				.file(new File("/path/to/file")) //
				.build();
		System.out.println(message);
	}

}
