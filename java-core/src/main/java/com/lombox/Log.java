package com.lombox;

import lombok.extern.slf4j.Slf4j;

@Slf4j // or: @Log @CommonsLog @Log4j @Log4j2 @XSlf4j
public class Log {

	// log.debug(), log.info(), ...
	public static void main(String[] args) {
		log.debug("Show log");
	}

}
