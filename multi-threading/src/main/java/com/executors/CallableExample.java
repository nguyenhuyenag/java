package com.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * - Mỗi đối tượng CallableDemo có thể xem là một thread, khi được submit vào
 * ExecutorService nó sẽ được thực thi.
 * 
 * - executor.shutdown(): Tắt executor khi không còn task (đối tượng Callable)
 * nào ở bên trong (các task đã hoàn thành). Nếu không tắt thì chương trình sẽ
 * chạy mãi vì luôn có một thread kiểm tra task trong executor để thực thi.
 */
public class CallableExample implements Callable<Integer> {

	private int a;
	private int b;

	public CallableExample(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int sum() {
		int sum = this.a + this.b;
		System.out.println(String.format("%d + %d = %d", a, b, sum));
		return sum;
	}

	@Override
	public Integer call() throws Exception {
		return this.sum();
	}

	/**
	 * Kết quả hiển thị không theo thứ tự được submit vào executor vì nó chạy cùng
	 * lúc.
	 */
	public static void example1() throws InterruptedException, ExecutionException {
		CallableExample c1 = new CallableExample(1, 2);
		CallableExample c2 = new CallableExample(1, 3);
		CallableExample c3 = new CallableExample(2, 3);
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.submit(c1);
		executor.submit(c2);
		executor.submit(c3);
		System.out.println("Done");
		executor.shutdown();
	}

	/**
	 * - Khi gọi f1.get() thì nó sẽ block thread chính lại để khi nào đối tượng c1
	 * thực hiện xong và trả về kết quả.
	 * 
	 * - Trường hợp đối tượng c1 mất quá nhiều thời gian để tính tổng 2 số thì cả
	 * chương trình sẽ bị delay rất lâu. Giải pháp cho trường hợp này là sử dụng
	 * method get() với thời gian timeout: f1.get(1, TimeUnit.SECONDS)
	 */
	public static void example2() throws InterruptedException, ExecutionException {
		CallableExample c1 = new CallableExample(1, 2);
		CallableExample c2 = new CallableExample(1, 3);
		CallableExample c3 = new CallableExample(2, 3);
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Future<Integer> f1 = executor.submit(c1);
		f1.get();
		executor.submit(c2);
		executor.submit(c3);
		System.out.println("Done");
		executor.shutdown();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		example1();
		example2();
	}

}
