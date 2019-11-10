package com.basic.lombok;

import lombok.Getter;
import lombok.Setter;

class User {
	@Getter private int age;
}

@Getter
@Setter
class NewUser {
	private int age;
	private String name;
}

public class Lombok {
	
}
