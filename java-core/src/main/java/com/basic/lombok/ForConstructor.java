package com.basic.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
class NoArgsConstructors {

}

@Getter
@AllArgsConstructor
class AllArgsConstructors {
	private Long id;
	private String name;
}

@Getter
@RequiredArgsConstructor
class RequiredArgsConstructors {
	private final String email;
	private final String name;
	private String password;
}
