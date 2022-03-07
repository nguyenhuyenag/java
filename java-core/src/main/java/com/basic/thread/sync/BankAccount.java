package com.basic.thread.sync;

public class BankAccount {

	private long amount = 20000000; // Số tiền có trong tài khoản

	public boolean checkAccountBalance(long withDrawAmount) {
		try {
			Thread.sleep(2000); // giả sử thời gian đọc csdl và kiểm tra tiền
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (withDrawAmount <= amount) {
			return true; // Cho phép rút tiền
		}
		return false; // Không cho phép rút tiền
	}

	public void withdraw(String threadName, long withdrawAmount) {
		// In thông tin người rút
		System.out.println(threadName + " withdraw: " + withdrawAmount);
		if (checkAccountBalance(withdrawAmount)) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			amount -= withdrawAmount;
		}
		// Số dư tài khoản
		System.out.println(threadName + " see balance: " + amount);
	}

}
