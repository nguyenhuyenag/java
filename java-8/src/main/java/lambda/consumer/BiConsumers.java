package lambda.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumers {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Java", 5);
		map.put("PHP", 2);
		map.put("C#", 1);
		BiConsumer<String, Integer> biConsumer = (k, v) -> System.out.println(k + " : " + v);
		map.forEach(biConsumer);
	}

}
