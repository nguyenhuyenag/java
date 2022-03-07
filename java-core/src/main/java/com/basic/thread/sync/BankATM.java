package com.basic.thread.sync;

/**
 * - Mutual Exclusive. Có thể hiểu là Loại trừ lẫn nhau. Cách này hệ thống sẽ
 * giúp ưu tiên một Thread và giúp ngăn chặn các Thread khác, khỏi nguy cơ xung
 * đột với nhau. Do đặc tính này của cơ chế làm chúng ta liên tưởng tới một sự
 * can thiệp mạnh tay, quyết liệt của hệ thống, nên mới có cái tên “loại trừ”.
 * Cách này sẽ được mình gói gọn trong bài học kế tiếp.
 * 
 * - Cooperation. Có thể hiểu là Cộng tác với nhau. Cách này bản thân các Thread
 * sẽ bắt tay với nhau, cùng nhau điều tiết thứ tự ưu tiên để có thể tự bản thân
 * chúng tránh sự xung đột. Cách này sẽ được mình trình bày ở bài kế tiếp theo
 * bài về cách loại trừ trên đây.
 * 
 */
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
		BankATM husband = new BankATM("Husband", bankAccount, 15);
		husband.start();
		// Người vợ rút hết 20 triệu
		BankATM wife = new BankATM("Wife", bankAccount, 20);
		wife.start();
	}

}
