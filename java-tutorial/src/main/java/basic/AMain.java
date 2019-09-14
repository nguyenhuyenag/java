package basic;

import java.util.concurrent.TimeUnit;

import common.util.DateTimeUtils;

public class AMain {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			System.out.println(DateTimeUtils.now());
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
