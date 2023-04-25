package com.lombox.builder;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.ToString;

//class annotations as before
@Builder
@ToString
class Pojo {

	@Default
	private String name = "foo";

	@Default
	private boolean original = true;
}

public class BuilderDefault {

	public static void main(String[] args) {
		Pojo build = Pojo.builder().build();
		System.out.println(build);
	}

}
