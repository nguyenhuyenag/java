package com.basic.thread.sync;

public class BankATM extends Thread {

	private String threadName = "";
	private long withdrawAmount = 0;
	private BankAccount bankAccount;

	public BankATM(String threadName, BankAccount bankAccount, long withdrawAmount) {
		this.threadName = threadName;
		this.bankAccount = bankAccount;
		this.withdrawAmount = withdrawAmount;
	}

	@Override
	public void run() {
		bankAccount.withdraw(threadName, withdrawAmount);
	}

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		// Người chồng rút 15 triệu
		BankATM husband = new BankATM("Husband", bankAccount, 15000000);
		husband.start();

		// Người vợ rút hết 20 triệu
		BankATM wife = new BankATM("Wife", bankAccount, 20000000);
		wife.start();
	}

}
