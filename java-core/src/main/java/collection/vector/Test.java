package collection.vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> arrayList = new ArrayList<>();
		Vector<Integer> vector = new Vector<>();
		Runnable addTask = () -> {
			for (int i = 0; i < 1000; i++) {
				synchronized (arrayList) {
					arrayList.add(i);
				}
				vector.add(i);
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(addTask);
		executorService.submit(addTask);

		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);

		int sumArrayList = arrayList.stream().mapToInt(Integer::intValue).sum();
		int sumVector = vector.stream().mapToInt(Integer::intValue).sum();

		System.out.println("Sum of ArrayList: " + sumArrayList);
		System.out.println("Sum of Vector: " + sumVector);
	}

}
