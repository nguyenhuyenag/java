package com.basic.thread.synchronize;

public class BankAccount {

	long amount = 20; // Số tiền có trong tài khoản

	public boolean checkAccountBalance(long withDrawAmount) {
		try {
			Thread.sleep(1000); // Giả lập thời gian đọc cơ sở dữ liệu và kiểm tra tiền
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (withDrawAmount <= amount) {
			return true; // Cho phép rút tiền
		}
		return false; // Không cho phép rút tiền
	}

	public synchronized void withdraw(String threadName, long withdrawAmount) {
		// In thông tin người rút
		System.out.println(threadName + " check: " + withdrawAmount);
		if (checkAccountBalance(withdrawAmount)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			amount -= withdrawAmount;
			System.out.println(threadName + " withdraw successful: " + withdrawAmount);
		} else {
			System.out.println(threadName + " withdraw error!");
		}
		// In ra số dư tài khoản
		System.out.println(threadName + " see balance: " + amount);
	}

}
